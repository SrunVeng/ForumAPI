package co.istad.forumproject.controller.Request;


import co.istad.forumproject.dto.Request.UpdateQuestionRequest;
import co.istad.forumproject.dto.Response.QuestionResponse;
import co.istad.forumproject.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/questions/update")
public class QuestionPutController {

    private final QuestionService questionService;

    @PutMapping("{slug}")
    UpdateQuestionRequest updateQuestion(@PathVariable String slug, @Valid @RequestBody UpdateQuestionRequest updateQuestionRequest) {
       return questionService.updateDescriptionBySlug(slug, updateQuestionRequest);
    }

    @PutMapping("{slug}/views")
    QuestionResponse updateViewBySlug(@PathVariable String slug, @RequestParam String userName) {
        return questionService.increaseViewCount(slug, userName);
    }

}
