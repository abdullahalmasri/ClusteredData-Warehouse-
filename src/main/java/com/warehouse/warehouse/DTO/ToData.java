package com.warehouse.warehouse.DTO;

public interface ToData<T> {
    /**
     * This method convert domain model object to data transfer object.
     *
     * @return the dto object
     */
    T toData();
}
