package com.warehouse.v1.service;

import com.warehouse.v1.model.Warehouse;
import org.springframework.stereotype.Service;

@Service
public interface WarehouseService {

    Warehouse createWarehous(Warehouse warehouse);

}
