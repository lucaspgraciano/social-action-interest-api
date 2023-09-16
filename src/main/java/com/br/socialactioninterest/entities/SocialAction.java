package com.br.socialactioninterest.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "SOCIAL_ACTIONS", schema = "SOCIAL_ACTIONS")
public class SocialAction {
    @Id
    @SequenceGenerator(name="SOCIAL_ACTIONS_SEQ", sequenceName="SOCIAL_ACTIONS_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SOCIAL_ACTIONS_SEQ")
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;

    @Column(name = "created_at")
    public LocalDateTime created_at;

    @Column(name = "updated_at")
    public LocalDateTime updated_at;

    public static SocialAction create(String name, String description) {
        SocialAction socialAction = new SocialAction();
        socialAction.name = name;
        socialAction.description = description;
        socialAction.created_at = LocalDateTime.now();
        return socialAction;
    }
}
