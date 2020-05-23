package com.ishikawa.fwm.fwmcore.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SimpleEntity extends BaseEntity<Long>{

    @Column(name = "entity_name")
    private String entity_name;
}
