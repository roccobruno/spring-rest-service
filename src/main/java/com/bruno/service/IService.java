package com.bruno.service;

import com.bruno.exception.InternalServerErrorException;
import com.bruno.model.RecordBO;
import com.bruno.model.filter.Filter;

import java.util.List;

public interface IService<T extends RecordBO> {

    Long countRecords(Filter filter) throws InternalServerErrorException;
    List<T> getRecords(Filter filter, String baseUrl) throws InternalServerErrorException;
    String getFilesFolderLocation();
    String getCsvFileHeader();

}
