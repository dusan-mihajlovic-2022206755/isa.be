package com.ISAProjekat.dusanm.exceptions.user;

import com.ISAProjekat.dusanm.exceptions.BaseException;

public class UserAlreadyExistException extends BaseException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
