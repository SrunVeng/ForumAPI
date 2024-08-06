package co.istad.forumproject.controller.Response;


import co.istad.forumproject.dto.Response.QuestionDetailsResponse;
import co.istad.forumproject.dto.Response.QuestionResponse;
import co.istad.forumproject.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
@RequiredArgsConstructor
public class QuestionGetController {

    private final QuestionService questionService;



    @GetMapping
     List<QuestionResponse> findAllQuestion() {
        return questionService.findAllQuestion();
    }

    @GetMapping("{slug}")
     QuestionDetailsResponse findQuestionBySlug(@PathVariable String slug) {
        return questionService.findQuestionBySlug(slug);
    }


}
