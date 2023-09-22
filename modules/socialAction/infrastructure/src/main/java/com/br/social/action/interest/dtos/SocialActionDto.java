package com.br.social.action.interest.dtos;

import com.br.social.action.interest.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "SOCIAL_ACTIONS", schema = "SOCIAL_ACTIONS")
public class SocialActionDto {

    @jakarta.persistence.Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;


    public static SocialActionDto toDto(SocialAction entity) {
        SocialActionDto dto = new SocialActionDto();
        dto.id = UUID.randomUUID();
        dto.name = entity.getName().getValue();
        dto.description = entity.getDescription().getValue();
        dto.createdAt = entity.getCreatedAt().getValue();
        dto.updatedAt = entity.getUpdatedAt().getValue();
        dto.completedAt = entity.getCompletedAt().getValue();
        return dto;
    }

    public SocialAction toEntity() throws Exception {
        Id id = new Id(this.id);
        Name name = new Name(this.name);
        Description description = new Description(this.description);
        CreatedAt createdAt = new CreatedAt(this.createdAt);
        UpdatedAt updatedAt = new UpdatedAt(this.updatedAt);
        CompletedAt completedAt = new CompletedAt(this.completedAt);
        return new SocialAction(id, name, description, createdAt, updatedAt, completedAt);
    }

    public UUID getId() {
        return id;
    }
}
