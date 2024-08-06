package co.istad.forumproject.service;


import co.istad.forumproject.dto.Request.CreateNewQuestionRequest;
import co.istad.forumproject.dto.Request.UpdateQuestionRequest;
import co.istad.forumproject.dto.Response.QuestionDetailsResponse;
import co.istad.forumproject.dto.Response.QuestionResponse;

import java.util.List;

public interface QuestionService {


    //findAllQuestion
    List<QuestionResponse> findAllQuestion();

    //Find question by slug
    QuestionDetailsResponse findQuestionBySlug(String slug);

    //Create New Question
    CreateNewQuestionRequest createNewQuestion(CreateNewQuestionRequest createNewQuestionRequest);

    //Update description by Slug
    UpdateQuestionRequest updateDescriptionBySlug(String slug, UpdateQuestionRequest updateQuestionRequest);

    //Count View by Request ( not Count view if owner Click ) (slug)
    void increaseViewCount( String slug,String UserName);



}
