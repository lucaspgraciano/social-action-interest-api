package com.br.socialactioninterest.repositories;

import com.br.socialactioninterest.entities.SocialAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.List;

@EnableJpaRepositories
public interface SocialActionRepository extends JpaRepository<SocialAction, Long> {

    List<SocialAction> findByNameContaining(String name);
}
