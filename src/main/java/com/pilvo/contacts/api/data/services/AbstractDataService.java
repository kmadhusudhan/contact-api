package com.pilvo.contacts.api.data.services;


import com.pilvo.contacts.api.models.PaginationResponse;

public abstract class AbstractDataService<T> {
    public abstract PaginationResponse<T> getAllRecords(T model);

    public abstract T createRecord(T model);

    public abstract T fetchRecordByName(T model);

    public abstract T fetchRecordById(long id);

    public abstract T fetchRecord(T model);

    public abstract void updateRecord(T model);

    public abstract void deleteRecord(T model);
}
