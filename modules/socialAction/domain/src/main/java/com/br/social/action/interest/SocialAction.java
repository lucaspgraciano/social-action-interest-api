package com.br.social.action.interest;

import java.time.LocalDateTime;
import java.util.UUID;

public record SocialAction(
    UUID id,
    String name,
    String description,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    LocalDateTime completedAt
) {}