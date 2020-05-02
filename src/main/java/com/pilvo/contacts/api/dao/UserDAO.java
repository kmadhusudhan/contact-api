package com.pilvo.contacts.api.dao;

import com.pilvo.contacts.api.models.User;
import com.pilvo.contacts.api.models.mappers.UserMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(UserMapper.class)
public interface UserDAO {

    @SqlQuery("select * from users where userID=:userID")
    User get(@Bind("id") long id);
}
