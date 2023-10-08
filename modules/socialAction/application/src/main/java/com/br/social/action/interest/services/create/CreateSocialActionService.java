package com.br.social.action.interest.services.create;

import com.br.social.action.interest.Service;
import com.br.social.action.interest.SocialAction;
import com.br.social.action.interest.dtos.SocialActionDto;
import com.br.social.action.interest.repositories.SocialActionRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@org.springframework.stereotype.Service
public class CreateSocialActionService implements Service<CreateSocialActionRequest, CreateSocialActionResponse> {
    private final SocialActionRepository repository;

    public CreateSocialActionService(SocialActionRepository repository) { this.repository = repository; }

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

        return new CreateSocialActionResponse(socialAction.id());

    }

}
