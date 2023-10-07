package com.br.social.action.interest.create;

import com.br.social.action.interest.*;
import com.br.social.action.interest.dtos.SocialActionDto;
import com.br.social.action.interest.repositories.SocialActionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.UUID;

@org.springframework.stereotype.Service
public class CreateSocialActionService implements Service<CreateSocialActionRequest, CreateSocialActionResponse> {

    @Autowired
    private SocialActionRepository repository;

    @Override
    public CreateSocialActionResponse execute(CreateSocialActionRequest request) {
        SocialAction socialAction = repository
                .save(SocialActionDto.toDto(
                        new SocialAction(
                                UUID.randomUUID(),
                                request.name(),
                                request.description(),
                                LocalDateTime.now(),
                                null,
                                null
                        )))
                .toEntity();

        return new CreateSocialActionResponse(socialAction.getId());

    }

}
