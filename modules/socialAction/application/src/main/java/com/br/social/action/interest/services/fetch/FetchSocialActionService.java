package com.br.social.action.interest.services.fetch;

import com.br.social.action.interest.Service;
import com.br.social.action.interest.dtos.SocialActionDto;
import com.br.social.action.interest.repositories.SocialActionRepository;

@org.springframework.stereotype.Service
public class FetchSocialActionService implements Service<FetchSocialActionRequest, FetchSocialActionResponse> {

    private final SocialActionRepository repository;

    public FetchSocialActionService(SocialActionRepository repository) { this.repository = repository; }

    @Override
    public FetchSocialActionResponse execute(FetchSocialActionRequest request) {
        if (request.name().isBlank()) {
            return new FetchSocialActionResponse(this.repository.findAll().stream()
                    .map(SocialActionDto::toEntity)
                    .toList());
        }

        return new FetchSocialActionResponse(this.repository.findByNameContaining(request.name()).stream()
                .map(SocialActionDto::toEntity)
                .toList());
    }
}
