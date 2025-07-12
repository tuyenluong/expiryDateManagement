package com.facility.v1.repository;

import com.facility.v1.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FacilityRepository extends JpaRepository<Facility, UUID> {
}