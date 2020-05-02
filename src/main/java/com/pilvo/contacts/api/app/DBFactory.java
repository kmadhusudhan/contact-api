package com.pilvo.contacts.api.app;

import com.pilvo.contacts.api.exceptions.DBConfigIntializationRequired;
import org.skife.jdbi.v2.DBI;

public class DBFactory {
        private static DBI dbi;
        protected DBFactory(DBI dbi) {
            DBFactory.dbi = dbi;
        }
        public static DBI getDBI(){
            if(null != dbi){
                return dbi;
            }
            throw new DBConfigIntializationRequired();
        }
}
