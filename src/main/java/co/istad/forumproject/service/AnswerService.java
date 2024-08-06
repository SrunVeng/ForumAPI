package co.istad.forumproject.service;

import co.istad.forumproject.dto.Request.CreateNewAnswerRequest;




public interface AnswerService {

    //Create Answer (content,createdBy) (slug)
    CreateNewAnswerRequest createNewAnswer(String slug, CreateNewAnswerRequest createNewAnswerRequest);

}
