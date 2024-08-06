package co.istad.forumproject.service.impl;


import co.istad.forumproject.dto.Request.CreateNewQuestionRequest;
import co.istad.forumproject.dto.Request.UpdateQuestionRequest;
import co.istad.forumproject.dto.Response.QuestionDetailsResponse;
import co.istad.forumproject.dto.Response.QuestionResponse;
import co.istad.forumproject.mapping.QuestionMapping;
import co.istad.forumproject.model.Question;
import co.istad.forumproject.repository.QuestionRepository;
import co.istad.forumproject.repository.Util;
import co.istad.forumproject.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionMapping questionMapping;
    private final Util util;


    //Find All question
    @Override
    public List<QuestionResponse> findAllQuestion() {
        List<Question> questions = questionRepository.findAllQuestion();
        //Use Mapstruct+Lombok , method reference to map Question Model to DTO
        return questions.stream().map(questionMapping::toQuestionResponse).toList();
    }

    //Find question by slug
    @Override
    public QuestionDetailsResponse findQuestionBySlug(String slug) {
        List<Question> questions = questionRepository.findAllQuestion();
        return questions.stream()
                .filter(q -> q.getSlug().equals(slug))
                //Use Mapstruct+Lombok , method reference to map Question Model to DTO
                .map(questionMapping::toQuestionDetailsResponse)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Question not found"));
    }

    @Override
    public CreateNewQuestionRequest createNewQuestion(CreateNewQuestionRequest createNewQuestionRequest) {
        //Validate Slug
        boolean isExisting = questionRepository.findAllQuestion().stream()
                .anyMatch(question -> question.getSlug()
                        .equals(createNewQuestionRequest.slug()));

        if (isExisting) {
            throw new RuntimeException();
        }

        CreateNewQuestionRequest createNewQuestionRequest1 = CreateNewQuestionRequest.builder()
                .slug(createNewQuestionRequest.slug())
                .title(createNewQuestionRequest.title())
                .description(createNewQuestionRequest.description()).build();
        Question question = questionMapping.fromCreateQuestion(createNewQuestionRequest1);
        question.setId(questionRepository.findAllQuestion().size() + 1);
        question.setCreatedAt(LocalDate.now());
        question.setCreatedBy(util.generateName());
        question.setViewCount(0L);
        question.setAnswers(new ArrayList<>());
        questionRepository.insert(question);
        return createNewQuestionRequest;
    }

    @Override
    public UpdateQuestionRequest updateDescriptionBySlug(String slug, UpdateQuestionRequest updateQuestionRequest) {
        //Validate Slug
        boolean isExisting = questionRepository.findAllQuestion().stream()
                .anyMatch(question -> question.getSlug()
                        .equals(slug));
        if (!isExisting) {
            throw new RuntimeException();
        }
        Question question = questionRepository.findAllQuestion().stream()
                .filter(q -> q.getSlug().equals(slug)).findFirst().orElseThrow();

        question.setDescription(updateQuestionRequest.description());
        questionRepository.updateDescription(question);
        return updateQuestionRequest;
    }


    //increase View
    @Override
    public void increaseViewCount(String slug, String UserName) {
        //Validate Slug
        boolean isExisting = questionRepository.findAllQuestion().stream()
                .anyMatch(question -> question.getSlug()
                        .equals(slug));

        boolean isOwner = questionRepository.findAllQuestion().stream()
                .anyMatch(q -> q.getCreatedBy().equals(UserName));

        if (!isExisting) {
            throw new RuntimeException();
        }
        if (!isOwner) {
            Question question = questionRepository.findAllQuestion().stream()
                    .filter(q -> q.getSlug().equals(slug)).findFirst().orElseThrow();
            question.setViewCount(question.getViewCount() + 1);

        }
    }

}
