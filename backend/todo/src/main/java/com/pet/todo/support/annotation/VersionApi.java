package com.pet.todo.support.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by Gun on 9/28/18.
 */
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public  @interface VersionApi {
    V value();
    public static enum V{
        VER_1,VER_2
    }
}
