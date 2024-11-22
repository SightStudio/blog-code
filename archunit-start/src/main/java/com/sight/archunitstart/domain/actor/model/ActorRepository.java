package com.sight.archunitstart.domain.actor.model;

import com.sight.archunitstart.dto.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {

}
