package com.facility.v1.service;

import com.facility.v1.model.Facility;
import org.springframework.stereotype.Service;

@Service
public interface FacilityService {

    Facility createFacility(Facility facility);

    int updateFacilityAddress();

    int deleteFacility(String id);

    Facility getFacilityById(String id);

}
