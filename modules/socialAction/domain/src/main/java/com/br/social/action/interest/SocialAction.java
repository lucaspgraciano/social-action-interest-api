package com.br.social.action.interest;

public class SocialAction extends Entity {
    private final Id id;
    private final Name name;
    private final Description description;
    private final CreatedAt createdAt;
    private final UpdatedAt updatedAt;

    public SocialAction(Id id, Name name, Description description, CreatedAt createdAt, UpdatedAt updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Id getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }

    public CreatedAt getCreatedAt() {
        return createdAt;
    }

    public UpdatedAt getUpdatedAt() {
        return updatedAt;
    }
}
