package com.ims.edm.v1.warehouse.service;

import com.ims.edm.v1.warehouse.entity.Warehouse;
import org.springframework.stereotype.Service;

@Service
public interface WarehouseService {

    Warehouse createWarehous(Warehouse warehouse);

}
