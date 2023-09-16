package com.br.socialactioninterest.controllers;

import com.br.socialactioninterest.dtos.SocialActionDto;
import com.br.socialactioninterest.entities.SocialAction;
import com.br.socialactioninterest.repositories.SocialActionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/social-actions")
public class SocialActionController {
    @Autowired
    private SocialActionRepository repository;

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(name = "name", required = false, defaultValue = "") String name) {
        if (!name.isEmpty())
            return ResponseEntity.ok(repository.findByNameContaining(name));

        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody SocialActionDto dto) {
        SocialAction socialAction = SocialAction.create(dto.name(), dto.description());
        return ResponseEntity.ok(repository.save(socialAction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        Optional<SocialAction> socialAction = repository.findById(id);

        if (socialAction.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok(socialAction.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @Valid @RequestBody SocialActionDto dto) {
        Optional<SocialAction> socialAction = repository.findById(id);

        if (socialAction.isPresent()) {
            socialAction.get().name = dto.name();
            socialAction.get().description = dto.description();
            socialAction.get().updated_at = LocalDateTime.now();
            return ResponseEntity.ok(repository.save(socialAction.get()));
        }

        return ResponseEntity.notFound().build();
    }
}
