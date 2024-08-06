package co.istad.forumproject.dto.Request;


import lombok.Builder;

@Builder
public record CreateNewQuestionRequest(
        String slug,
        String title,
        String description
) {
}
