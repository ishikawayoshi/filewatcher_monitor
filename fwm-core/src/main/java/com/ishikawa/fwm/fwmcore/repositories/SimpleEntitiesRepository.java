package com.ishikawa.fwm.fwmcore.repositories;

import com.ishikawa.fwm.fwmcore.entities.SimpleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleEntitiesRepository extends JpaRepository<SimpleEntity,Long> {

}
