package com.br.social.action.interest.repositories;

import com.br.social.action.interest.dtos.SocialActionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.List;

@EnableJpaRepositories
public interface SocialActionRepository extends JpaRepository<SocialActionDto, Long> {

    List<SocialActionDto> findByNameContaining(String name);
}
