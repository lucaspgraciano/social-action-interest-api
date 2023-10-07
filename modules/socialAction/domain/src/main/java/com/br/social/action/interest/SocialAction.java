package com.br.social.action.interest;

import java.time.LocalDateTime;
import java.util.UUID;

public class SocialAction {
    private final UUID id;
    private final String name;
    private final String description;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final LocalDateTime completedAt;

    public SocialAction(UUID id,
                        String name,
                        String description,
                        LocalDateTime createdAt,
                        LocalDateTime updatedAt,
                        LocalDateTime completedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.completedAt = completedAt;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getCompletedAt() { return completedAt; }
}
