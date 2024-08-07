package co.istad.forumproject.dto.Request;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CreateNewQuestionRequest(

        @NotBlank
        String slug,
        @NotBlank
        String title,
        @NotBlank
        String description
) {
}
