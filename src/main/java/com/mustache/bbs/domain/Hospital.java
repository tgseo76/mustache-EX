package com.mustache.bbs.domain;

import com.mustache.bbs.repository.HospitalRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name="hospital")
@NoArgsConstructor
@AllArgsConstructor

public class Hospital {
    @Id // GeneratedValue안씀
    private Integer id; // Long --> bigint

    @Column(name="hospital_name")  //컬럼에 옵션을 여러가지 정할 수 있습니다. 컬럼명을 매핑할 수 있습니다.
    private String HospitalName;

    private String roadNameAddress;


}
