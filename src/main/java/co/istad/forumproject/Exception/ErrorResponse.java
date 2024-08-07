package co.istad.forumproject.Exception;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse<T> {
    private T error;

}
