package com.bruno.service;

import java.util.Map;

public interface IDBServiceContainer {

    Map<ServiceType, IService> getServicesMap();
    IService getService(ServiceType serviceType);


}
