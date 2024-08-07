package co.istad.forumproject.controller.Request;


import co.istad.forumproject.dto.Request.CreateNewQuestionRequest;
import co.istad.forumproject.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/questions/create")
@RequiredArgsConstructor
public class QuestionPostController {

    private final QuestionService questionService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
     CreateNewQuestionRequest createNewQuestionRequest(@Valid @RequestBody CreateNewQuestionRequest createNewQuestionRequest) {
        questionService.createNewQuestion(createNewQuestionRequest);
        return createNewQuestionRequest;
    }
}
