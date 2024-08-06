package co.istad.forumproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Builder
@AllArgsConstructor
@Getter
@Setter
public class Answer {

    private Integer id;
    private String slug;
    private String title;
    private String content;
    private String description;
    private Long viewCount;
    private LocalDate createdAt;
    private String createdBy;
    private String uuid;
    private Boolean isAccepted;

    // Relationship with Questions
    private Question questions;

}