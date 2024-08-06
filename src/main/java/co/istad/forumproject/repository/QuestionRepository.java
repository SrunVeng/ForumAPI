package co.istad.forumproject.repository;

import co.istad.forumproject.model.Answer;
import co.istad.forumproject.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionRepository {

    private final List<Question> questions;

    // Select All Question
    public List<Question> findAllQuestion() {
        return questions;
    }

    // insert new Question
    public void insert(Question question) {
        questions.add(question);
    }

    //Update Question Description
    public void updateDescription(Question question) {
        questions.stream()
                .filter(q -> q.getSlug().equals(question.getSlug()))
                .findFirst()
                .ifPresent(q -> q.setDescription(question.getDescription()));
    }

    //Add Answer base on Question Slug
    public void AddAnswer(String slug,Answer answer){

        questions.stream().filter(q->q.getSlug().equals(slug))
                .findFirst()
                .ifPresent(q -> q.getAnswers().addLast(answer));

    }
    public void addViewCount(String slug) {
        questions.stream()
                .filter(q -> q.getSlug().equals(slug))
                .findFirst()
                .ifPresent(q -> q.setViewCount(q.getViewCount() + 1));
    }

}
