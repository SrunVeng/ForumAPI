package co.istad.forumproject.mapping;

import co.istad.forumproject.dto.Request.CreateNewAnswerRequest;
import co.istad.forumproject.dto.Request.CreateNewQuestionRequest;
import co.istad.forumproject.dto.Response.AnswerResponse;
import co.istad.forumproject.dto.Response.QuestionDetailsResponse;
import co.istad.forumproject.dto.Response.QuestionResponse;
import co.istad.forumproject.model.Answer;
import co.istad.forumproject.model.Question;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface QuestionMapping {

    //Target = return type
    //Main Source = parameter


    QuestionResponse toQuestionResponse(Question question);
    QuestionDetailsResponse toQuestionDetailsResponse(Question question);
    Question fromCreateQuestion(CreateNewQuestionRequest createNewQuestionRequest);

    Answer fromCreateAnswer(CreateNewAnswerRequest newAnswerRequest);
    AnswerResponse toAnswerResponse(Answer answer);
}
