package com.pilvo.contacts.api.dao;

import com.pilvo.contacts.api.models.Contact;
import com.pilvo.contacts.api.models.mappers.ContactMapper;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.Define;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;

import java.util.List;

@UseStringTemplate3StatementLocator
@RegisterMapper({ContactMapper.class})
public interface ContactDAO {

    @SqlQuery("select * from contacts where isDeleted=false order by <sortColumn> <order>  LIMIT :limit OFFSET :offset")
    List<Contact> getAll(@BindBean Contact contact, @Define("sortColumn") String sortColumn, @Define("order") String order);

    @SqlQuery("select count(*) from contacts where isDeleted=false")
    long getCount();

    @SqlQuery("select * from contacts where isDeleted=false and (email=:searchTerm or name=:searchTerm) order by <sortColumn> <order>  LIMIT :limit OFFSET :offset")
    List<Contact> getSearchAll(@BindBean Contact contact, @Define("sortColumn") String sortColumn, @Define("order") String order);

    @SqlQuery("select count(*) from contacts where isDeleted=false and (email=:searchTerm or name=:searchTerm)")
    long getSearchCount(@BindBean Contact contact);

    @SqlUpdate("insert into contacts(name,email,phoneNumber) values(:name,:email,:phoneNumber)")
    @GetGeneratedKeys
    long save(@BindBean Contact contact);

    @SqlQuery("select * from contacts where id=:id and isDeleted=false")
    Contact get(@Bind("id") long id);

    @SqlQuery("select * from contacts where email=:email and isDeleted=false")
    Contact getByEmail(@Bind("email") String email);

    @SqlUpdate("update contacts set name=:name,email=:email,phoneNumber=:phoneNumber where id=:id")
    void update(@BindBean Contact contact);

    @SqlUpdate("update contacts set isDeleted=true where id=:id")
    void delete(@Bind("id") long id);
}
