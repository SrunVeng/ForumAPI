package co.istad.forumproject.dto.Response;


import lombok.Builder;
import java.time.LocalDate;



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
