package com.br.social.action.interest.repositories;

import com.br.social.action.interest.dtos.SocialActionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.UUID;

@EnableJpaRepositories
public interface SocialActionRepository extends JpaRepository<SocialActionDto, UUID> {

    List<SocialActionDto> findByNameContaining(String name);
}
