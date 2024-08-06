package co.istad.forumproject.service.impl;

import co.istad.forumproject.dto.Request.CreateNewAnswerRequest;
import co.istad.forumproject.mapping.QuestionMapping;
import co.istad.forumproject.model.Answer;
import co.istad.forumproject.model.Question;
import co.istad.forumproject.repository.QuestionRepository;
import co.istad.forumproject.repository.Util;
import co.istad.forumproject.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
@RequiredArgsConstructor

public class AnswerServiceImpl implements AnswerService {

    private final QuestionRepository questionRepository;
    private final QuestionMapping questionMapping;
    private final Util util;

    // CreateNewAnswerRequest
    @Override
    public CreateNewAnswerRequest createNewAnswer(String slug, CreateNewAnswerRequest createNewAnswerRequest) {
        //Validate Slug
        boolean isExisting = questionRepository.findAllQuestion().stream()
                .anyMatch(question -> question.getSlug()
                        .equals(slug));
        if (!isExisting) {
            throw new RuntimeException();
        }
        CreateNewAnswerRequest newAnswerRequest = CreateNewAnswerRequest.builder()
                .createdBy(createNewAnswerRequest.createdBy())
                .content(createNewAnswerRequest.content())
                .build();
        Answer newAnswer = questionMapping.fromCreateAnswer(newAnswerRequest);
        newAnswer.setCreatedAt(LocalDate.now());
        newAnswer.setId(23);
        newAnswer.setUuid(util.generateUUID());
        newAnswer.setViewCount(0L);
        newAnswer.setIsAccepted(true);
        newAnswer.setTitle("ABC");
        Question question = questionRepository.findAllQuestion().stream().filter(q -> q.getSlug()
                        .equals(slug))
                .findFirst().orElseThrow();
        questionRepository.AddAnswer(question.getSlug(), newAnswer);
        return newAnswerRequest;
    }

}
