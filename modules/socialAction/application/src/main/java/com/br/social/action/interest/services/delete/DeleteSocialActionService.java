package com.br.social.action.interest.services.delete;

import com.br.social.action.interest.SocialAction;
import com.br.social.action.interest.repositories.SocialActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteSocialActionService {

    @Autowired
    private SocialActionRepository repository;

    public DeleteSocialActionResponse execute(DeleteSocialActionRequest request) throws NotFoundException {
        Optional<SocialAction> socialAction = repository.findById(request.id());

        if (socialAction.isEmpty()) throw new NotFoundException();

        repository.delete(socialAction.get());

        return new DeleteSocialActionResponse(socialAction.get().getId());
    }
}
