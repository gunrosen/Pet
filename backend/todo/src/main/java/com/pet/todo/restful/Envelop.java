package com.pet.todo.restful;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

/**
 * Created by Gun on 8/24/18.
 */
public class Envelop extends HashMap<String,Object>{

    public Envelop(Object data){
        setData(data);
    }

    private void setData(Object data) {
        put("data", data);
    }

    private Object getData(){
        return get("data");
    }

    public ResponseEntity<?> toResponseEntity(){
        Object data = getData();
        return new ResponseEntity<Object>(data, HttpStatus.OK);
    }
}
