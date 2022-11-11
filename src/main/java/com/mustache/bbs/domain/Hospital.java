package com.mustache.bbs.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name="hospital")
public class Hospital {
    @Id // GeneratedValue안씀
    private Integer id; // Long --> bigint
}
