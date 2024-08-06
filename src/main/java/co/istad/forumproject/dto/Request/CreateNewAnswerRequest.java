package co.istad.forumproject.dto.Request;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;


@Builder
public record CreateNewAnswerRequest(
        // Declare constraint
        @Size(min = 5, max = 100)
        @NotBlank
        String content,

        @NotBlank
        String createdBy
) {
}
