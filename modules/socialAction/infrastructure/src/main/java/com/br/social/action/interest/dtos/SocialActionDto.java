package com.br.social.action.interest.dtos;

import com.br.social.action.interest.SocialAction;
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
        dto.name = entity.getName();
        dto.description = entity.getDescription();
        dto.createdAt = entity.getCreatedAt();
        dto.updatedAt = entity.getUpdatedAt();
        dto.completedAt = entity.getCompletedAt();
        return dto;
    }

    public SocialAction toEntity() {
        return new SocialAction(id, name, description, createdAt, updatedAt, completedAt);
    }

    public UUID getId() {
        return id;
    }
}
