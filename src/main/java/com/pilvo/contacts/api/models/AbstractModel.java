package com.pilvo.contacts.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class AbstractModel implements Serializable {
    protected long id;
    protected String name;
    protected Timestamp createdAt;
    protected Timestamp updatedAt;

    private String userToken;
//    private long userID;

    //pagination fields
    private long totalSize;
    private long offset;
    private long limit;
    private String orderBy;
    private String sortDirection;
    private String searchTerm;
    private boolean isDeleted;
}
