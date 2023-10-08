package com.br.social.action.interest.services.delete;

import com.br.social.action.interest.dtos.SocialActionDto;
import com.br.social.action.interest.repositories.SocialActionRepository;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteSocialActionService {
    private final SocialActionRepository repository;

    public DeleteSocialActionService(SocialActionRepository repository) { this.repository = repository; }

    public DeleteSocialActionResponse execute(DeleteSocialActionRequest request) throws NotFoundException {
        Optional<SocialActionDto> socialAction = repository.findById(request.id());

        if (socialAction.isEmpty()) throw new NotFoundException();

        repository.delete(socialAction.get());

        return new DeleteSocialActionResponse(socialAction.get().getId().toString());
    }
}
