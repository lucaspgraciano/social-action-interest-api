package com.br.social.action.interest.modules.socialAction;

import com.br.social.action.interest.services.create.CreateSocialActionRequest;
import com.br.social.action.interest.services.create.CreateSocialActionResponse;
import com.br.social.action.interest.services.create.CreateSocialActionService;
import com.br.social.action.interest.services.delete.DeleteSocialActionRequest;
import com.br.social.action.interest.services.delete.DeleteSocialActionResponse;
import com.br.social.action.interest.services.delete.DeleteSocialActionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/social-actions")
public class SocialActionController {

    private final CreateSocialActionService createService;
    private final DeleteSocialActionService deleteService;

    @Autowired
    public SocialActionController(CreateSocialActionService createService, DeleteSocialActionService deleteService) {
        this.createService = createService;
        this.deleteService = deleteService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(name = "name", required = false, defaultValue = "") String name) {
        return ResponseEntity.ok("Hello World! " + name);
    }

    @PostMapping
    public EntityModel<?> create(@Valid @RequestBody CreateSocialActionRequest request) throws NotFoundException {
        CreateSocialActionResponse response = createService.execute(request);

        return EntityModel.of(response,
                linkTo(methodOn(SocialActionController.class).create(request)).withSelfRel(),
                linkTo(methodOn(SocialActionController.class).findAll(request.name())).withRel("fetch"),
                linkTo(methodOn(SocialActionController.class).delete(new DeleteSocialActionRequest(response.id()))).withRel("delete"));
    }

    @DeleteMapping("/{id}")
    public EntityModel<?> delete(@PathVariable DeleteSocialActionRequest id) throws NotFoundException {
        DeleteSocialActionResponse response = deleteService.execute(id);

        return EntityModel.of(response,
                linkTo(methodOn(SocialActionController.class).delete(id)).withSelfRel());
    }
}
