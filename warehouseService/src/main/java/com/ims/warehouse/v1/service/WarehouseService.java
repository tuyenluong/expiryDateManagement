package com.ims.warehouse.v1.service;

import com.ims.warehouse.v1.entity.Warehouse;
import org.springframework.stereotype.Service;

@Service
public interface WarehouseService {

    Warehouse createWarehous(Warehouse warehouse);

}
