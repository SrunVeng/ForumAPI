package co.istad.forumproject.dto.Response;

import co.istad.forumproject.model.Answer;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;


@Builder
public record QuestionResponse(
        String slug,
        String title,
        String description,
        Long viewCount,
        LocalDate createdAt,
        String createdBy
) {

}
