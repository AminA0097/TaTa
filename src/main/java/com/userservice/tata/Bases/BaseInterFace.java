package com.userservice.tata.Bases;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
public interface BaseInterFace<T> {
    public Specification<T> createFilter(Class<T> entityClass, String filter) throws Exception;
    public boolean checkExist(Class<T> entityClass,String filter) throws Exception;
    public String save(T entity) throws Exception;
    public String test();
}