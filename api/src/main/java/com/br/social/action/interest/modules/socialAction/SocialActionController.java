package com.br.social.action.interest.modules.socialAction;

import com.br.social.action.interest.services.create.CreateSocialActionRequest;
import com.br.social.action.interest.services.create.CreateSocialActionResponse;
import com.br.social.action.interest.services.create.CreateSocialActionService;
import com.br.social.action.interest.services.delete.DeleteSocialActionRequest;
import com.br.social.action.interest.services.delete.DeleteSocialActionResponse;
import com.br.social.action.interest.services.delete.DeleteSocialActionService;
import com.br.social.action.interest.services.fetch.FetchSocialActionRequest;
import com.br.social.action.interest.services.fetch.FetchSocialActionResponse;
import com.br.social.action.interest.services.fetch.FetchSocialActionService;
import jakarta.validation.Valid;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/social-actions")
public class SocialActionController {

    private final CreateSocialActionService createService;
    private final DeleteSocialActionService deleteService;
    private final FetchSocialActionService fetchService;

    public SocialActionController(
            CreateSocialActionService createService,
            DeleteSocialActionService deleteService,
            FetchSocialActionService fetchService) {
        this.createService = createService;
        this.deleteService = deleteService;
        this.fetchService = fetchService;
    }

    @GetMapping
    public EntityModel<?> findAll(@RequestParam(name = "name", required = false, defaultValue = "") FetchSocialActionRequest request) throws NotFoundException {
        FetchSocialActionResponse response = fetchService.execute(request);

        return EntityModel.of(response,
                linkTo(methodOn(SocialActionController.class).findAll(request)).withSelfRel(),
                linkTo(methodOn(SocialActionController.class).delete(UUID.randomUUID())).withRel("delete"));
    }

    @PostMapping
    public EntityModel<?> create(@Valid @RequestBody CreateSocialActionRequest request) throws Exception {
        CreateSocialActionResponse response = createService.execute(request);

        return EntityModel.of(response,
                linkTo(methodOn(SocialActionController.class).create(request)).withSelfRel(),
                linkTo(methodOn(SocialActionController.class).findAll(new FetchSocialActionRequest(request.name()))).withRel("fetch"),
                linkTo(methodOn(SocialActionController.class).delete(response.id())).withRel("delete"));
    }

    @DeleteMapping("/{id}")
    public EntityModel<?> delete(@PathVariable UUID id) throws NotFoundException {
        DeleteSocialActionResponse response = deleteService.execute(new DeleteSocialActionRequest(id));

        return EntityModel.of(response,
                linkTo(methodOn(SocialActionController.class).delete(id)).withSelfRel());
    }
}
