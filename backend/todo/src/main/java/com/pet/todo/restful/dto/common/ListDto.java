package com.pet.todo.restful.dto.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Gun on 8/24/18.
 */
public class ListDto<T extends Serializable> implements Serializable{

    private Long count;
    private List<T> list;

    public ListDto(Long count, List<T> list) {
        this.count = count;
        this.list = list;
    }

    public ListDto(List<T> list) {
        this.list = list;
        this.count = (long) list.size();
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
