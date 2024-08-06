package co.istad.forumproject.repository;

import co.istad.forumproject.model.Answer;
import co.istad.forumproject.model.Question;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import lombok.Builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Getter
public class ForumDatabase {

    private final Util util;
    private List<Question> questions;

    @Bean
    public List<Question> initializeQuestions() {
        questions = new ArrayList<>();
        Question q1 = Question.builder()
                .id(1) // Add id here
                .createdBy(util.generateName())
                .createdAt(LocalDate.now().plusDays(1))
                .viewCount(0L)
                .title("Java: Randomly generate distinct names")
                .slug("java-randomly-generate-distinct-names")
                .description("I am answering this very late, but this is what really useful for new reader. This is a very simple and efficient way to get random VALID names. To do so, add maven repository in POM.xml")
                .answers(new ArrayList<>(Arrays.asList(
                        Answer.builder()
                                .id(2) // Add id here
                                .uuid(util.generateUUID())
                                .createdAt(LocalDate.now().plusDays(5))
                                .createdBy(util.generateName())
                                .isAccepted(false)
                                .content("Injected the dependency to the class the java of course not lorem asmkd ")
                                .build()
                )))
                .build();

        Question q2 = Question.builder()
                .id(3) // Add id here
                .createdBy(util.generateName())
                .createdAt(LocalDate.now().plusDays(1))
                .viewCount(0L)
                .title("Autism Spectrum Disorder")
                .slug("autism-spectrum-disorder")
                .description("What is autism?")
                .answers(new ArrayList<>(Arrays.asList(
                        Answer.builder()
                                .id(4) // Add id here
                                .uuid(util.generateUUID())
                                .createdAt(LocalDate.now().plusDays(5))
                                .createdBy(util.generateName())
                                .isAccepted(true)
                                .content("Autism spectrum disorder (ASD) is a neurodevelopmental condition typically diagnosed during childhood. The former name of ASD is autism, and many people still use the term. But ASD includes several conditions within the spectrum. ASD changes the way your child")
                                .build())))
                .build();
        questions.add(q1);
        questions.add(q2);
        return questions;
    }
}
