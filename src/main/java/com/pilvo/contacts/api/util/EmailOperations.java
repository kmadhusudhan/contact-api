package com.pilvo.contacts.api.util;

import com.google.common.base.Preconditions;
import com.pilvo.contacts.api.common.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailOperations {
    private Matcher matcher;
    private Pattern emailPattern = Pattern.compile(Constants.EMAIL_PATTREN, Pattern.CASE_INSENSITIVE);

    public void isValidEmail(String email) throws NullPointerException {
        matcher = emailPattern.matcher(email);
        Preconditions.checkState(matcher.matches());
    }
}
