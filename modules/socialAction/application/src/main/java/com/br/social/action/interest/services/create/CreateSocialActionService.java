package com.br.social.action.interest.services.create;

import com.br.social.action.interest.SocialAction;
import com.br.social.action.interest.repositories.SocialActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateSocialActionService {

    @Autowired
    private SocialActionRepository repository;

    public CreateSocialActionResponse execute(CreateSocialActionRequest request) {
        SocialAction socialAction = SocialAction.create(request.name(), request.description());
        return new CreateSocialActionResponse(repository.save(socialAction).id);
    }

}
