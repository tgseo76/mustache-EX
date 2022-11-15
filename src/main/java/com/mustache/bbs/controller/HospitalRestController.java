package com.mustache.bbs.controller;

import com.mustache.bbs.domain.Hospital;
import com.mustache.bbs.domain.dto.HospitalResponse;
import com.mustache.bbs.repository.HospitalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {

    private final HospitalRepository hospitalRepository;

    public HospitalRestController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) { // ResponseEntity도 DTO타입
        Optional<Hospital> hospital = hospitalRepository.findById(id); // Entity
        HospitalResponse hospitalResponse = Hospital.of(hospital.get()); // DTO
        return ResponseEntity.ok().body(hospitalResponse); // Return은 DTO로
    }
}
