package com.userservice.tata.Bases;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
public interface BaseInterFace<T> {
    public boolean checkExist(String filter) throws Exception;
    public List<?> getList(String filter,int pageNum,int pageSize)throws Exception;
    public String test();
}