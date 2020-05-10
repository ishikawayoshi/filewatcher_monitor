package com.ishikawa.fwm.fwmcore.services.impl;

import com.ishikawa.fwm.fwmcore.entities.SimpleEntity;
import com.ishikawa.fwm.fwmcore.repositories.SimpleEntitiesRepository;
import com.ishikawa.fwm.fwmcore.services.SimpleEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleEntityServiceImpl implements SimpleEntityService {

    private final SimpleEntitiesRepository simpleEntitiesRepository;

    public SimpleEntityServiceImpl(SimpleEntitiesRepository simpleEntitiesRepository) {
        this.simpleEntitiesRepository = simpleEntitiesRepository;
    }

    @Override
    public List<SimpleEntity> getAllEntities() {
        List<SimpleEntity> all = this.simpleEntitiesRepository.findAll();
        return all;
    }

}
