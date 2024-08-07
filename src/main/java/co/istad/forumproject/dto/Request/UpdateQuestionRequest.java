package co.istad.forumproject.dto.Request;

import jakarta.validation.constraints.NotBlank;

public record UpdateQuestionRequest(

        @NotBlank
        String description
) {
}
