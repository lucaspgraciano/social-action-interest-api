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
    public CreateSocialActionResponse execute(CreateSocialActionRequest request) throws Exception {
        Id id = new Id(UUID.randomUUID());
        Name name = new Name(request.name());
        Description description = new Description(request.description());
        CreatedAt createdAt = new CreatedAt(LocalDateTime.now());
        UpdatedAt updatedAt = new UpdatedAt(null);
        CompletedAt completedAt = new CompletedAt(null);

        SocialAction socialAction = repository
                .save(SocialActionDto.toDto(new SocialAction(id, name, description, createdAt, updatedAt, completedAt)))
                .toEntity();

        return new CreateSocialActionResponse(socialAction.getId().getValue());

    }

}
