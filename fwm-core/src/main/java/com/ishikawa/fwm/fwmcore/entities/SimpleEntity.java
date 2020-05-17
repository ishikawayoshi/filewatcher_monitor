package com.ishikawa.fwm.fwmcore.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SimpleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String entity_name;
}
