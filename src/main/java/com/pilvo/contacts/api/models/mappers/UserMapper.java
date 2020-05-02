package com.pilvo.contacts.api.models.mappers;

import com.pilvo.contacts.api.models.User;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements ResultSetMapper<User> {
    public User map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        User user = new User();
        user.setPassword(r.getString("password"));
        user.setUserID(r.getString("userID"));
        return user;
    }
}