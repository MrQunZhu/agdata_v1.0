package org.clesun.utils;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * Created by clesun on 2017/4/27.
 */
public class UsualValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
