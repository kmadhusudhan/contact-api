package com.pilvo.contacts.api.models.mappers;

import com.pilvo.contacts.api.models.Contact;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactMapper implements ResultSetMapper<Contact> {
    public Contact map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        Contact contact = new Contact();
        contact.setEmail(r.getString("email"));
        contact.setPhoneNumber(r.getString("phoneNumber"));
        contact.setCreatedAt(r.getTimestamp("createdAT"));
        contact.setUpdatedAt(r.getTimestamp("updateAT"));
        contact.setDeleted(r.getBoolean("isDeleted"));
        return contact;
    }
}
