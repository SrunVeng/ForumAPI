package co.istad.forumproject.dto.Response;


import lombok.Builder;

@Builder
public record AnswerResponse(
        String uuid,
        String content
) {
}
