package co.istad.forumproject.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Builder
public class Question {
    private Integer id;
    private String slug;
    private String title;
    private String description;
    private Long viewCount;
    private LocalDate createdAt;
    private String createdBy;

    // Relationship with answers
    private List<Answer> answers = new ArrayList<>();

}