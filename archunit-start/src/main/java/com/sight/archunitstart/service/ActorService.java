package com.sight.archunitstart.service;

import com.sight.archunitstart.domain.actor.model.ActorRepository;
import com.sight.archunitstart.dto.Actor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;

    public void saveActor() {
        actorRepository.save(new Actor());
    }
}
