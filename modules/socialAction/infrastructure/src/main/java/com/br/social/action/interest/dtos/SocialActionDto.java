package com.br.social.action.interest.dtos;

import com.br.social.action.interest.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

@Entity
@Table(name = "SOCIAL_ACTIONS", schema = "SOCIAL_ACTIONS")
public class SocialActionDto {

    @jakarta.persistence.Id
    @SequenceGenerator(name="SOCIAL_ACTIONS_SEQ", sequenceName="SOCIAL_ACTIONS_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SOCIAL_ACTIONS_SEQ")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    public static SocialActionDto toDto(SocialAction entity) {
        SocialActionDto dto = new SocialActionDto();
        dto.id = entity.getId().getValue();
        dto.name = entity.getName().getValue();
        dto.description = entity.getDescription().getValue();
        dto.created_at = entity.getCreatedAt().getValue();
        dto.updated_at = entity.getUpdatedAt().getValue();
        return dto;
    }

    public SocialAction toEntity() throws Exception {
        Id id = new Id(this.id);
        Name name = new Name(this.name);
        Description description = new Description(this.description);
        CreatedAt createdAt = new CreatedAt(this.created_at);
        UpdatedAt updatedAt = new UpdatedAt(this.updated_at);
        return new SocialAction(id, name, description, createdAt, updatedAt);
    }

    public Long getId() {
        return id;
    }
}
