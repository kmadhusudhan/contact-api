package com.pilvo.contacts.api.data.services;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.pilvo.contacts.api.common.Constants;
import com.pilvo.contacts.api.dao.ContactDAO;
import com.pilvo.contacts.api.models.Contact;
import com.pilvo.contacts.api.models.PaginationResponse;

import java.util.List;

public class ContactDataService extends AbstractDataService<Contact> {
    @Inject
    @Named(Constants.CONTACTS_DAO)
    ContactDAO contactDAO;

    public PaginationResponse<Contact> getAllRecords(Contact model) {
        PaginationResponse paginationRecords = new PaginationResponse();
        List<Contact> contactList;
        long totalCount;
        if(model.getSearchTerm() == null) {
            contactList = contactDAO.getAll(model,model.getOrderBy(),model.getSortDirection());
            totalCount = contactDAO.getCount();
        } else {
            contactList = contactDAO.getSearchAll(model,model.getOrderBy(),model.getSortDirection());
            totalCount = contactDAO.getSearchCount(model);
        }
        paginationRecords.setItems(contactList);
        paginationRecords.setTotal(totalCount);
        return paginationRecords;
    }

    public Contact createRecord(Contact model) {
        contactDAO.save(model);
        return model;
    }

    public Contact fetchRecordByName(Contact model) {
       return contactDAO.getByEmail(model.getEmail());
    }

    public Contact fetchRecordById(long id) {
        return contactDAO.get(id);
    }

    public Contact fetchRecord(Contact model) {
        return null;
    }

    public void updateRecord(Contact model) {
        contactDAO.update(model);
    }

    public void deleteRecord(Contact model) {
        contactDAO.delete(model.getId());
    }
}
