package co.istad.forumproject.controller.Request;


import co.istad.forumproject.dto.Request.CreateNewAnswerRequest;
import co.istad.forumproject.service.AnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/answers/create")
@RequiredArgsConstructor
public class AnswerPostController {

    private final AnswerService answerService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("{slug}")
    // Validate constraint
    CreateNewAnswerRequest createNewAnswerRequest(@PathVariable String slug,@Valid @RequestBody CreateNewAnswerRequest createNewAnswerRequest) {
        answerService.createNewAnswer(slug, createNewAnswerRequest);
        return createNewAnswerRequest;
    }
}
