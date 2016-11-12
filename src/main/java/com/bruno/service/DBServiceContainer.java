package com.bruno.service;

import com.bruno.service.pagamenti.IPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DBServiceContainer implements IDBServiceContainer {

    private Map<ServiceType, IService> serviceMap = new HashMap<ServiceType, IService>();

    @Autowired
    private IPagamentoService pagamentoService;


    @Override
    public Map<ServiceType, IService> getServicesMap() {
        if(serviceMap.isEmpty())
            serviceMap.put(ServiceType.PAGAMENTI, pagamentoService);
        return serviceMap;
    }

    @Override
    public IService getService(ServiceType serviceType) {
        return getServicesMap().get(serviceType);
    }
}
