package com.userservice.tata.Bases;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.PathBuilder;
import com.userservice.tata.Annotation.EntityField;
import com.userservice.tata.Annotation.IsBoolean;
import com.userservice.tata.Filter.QueryDSL;
import com.userservice.tata.Filter.QueryDSL.*;
import com.userservice.tata.Util.Mapper;
import com.userservice.tata.Util.Remote;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.From;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.ArrayList;
import java.util.List;

public class BaseService<T> implements BaseInterFace<T> {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private EntityManager em;
    public boolean convertToBoolean(String value) {
        if (value.equals("0")) {
            return false;
        } else if (value.equals("1")) {
            return true;
        } else {
            throw new IllegalArgumentException("Invalid boolean value: " + value);
        }
    }
    protected List<String> getConstraint(List filter) throws Exception {
        List filterList = new ArrayList();
        if(!filter.contains("e.deleted@eq0;")) {
//            filterList.add("e.deleted@eq0;");
        }
        if(filter.size() != 0) {
            for (Object o : filter) {
                filterList.add(o.toString());
            }
        }
        return filterList;
    }
    @Override
    public List<?> getList(String filter, int pageNum, int pageSize) throws Exception {
        pageNum = pageNum > 0 ? pageNum : 1;  // Page numbers start from 1
        pageSize = pageSize > 20 ? pageSize : 20;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);

        String repoName = Remote.getRepoNameFromRemote();
        Class<?> entityClass = Remote.getEntityClassFromRemote();
        Class<?> dtoClass = Remote.getDtoNameFromRemote();

        QueryDSL queryDSL = new QueryDSL();
        BooleanBuilder predicate = queryDSL.createFilter(entityClass, filter);
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        PathBuilder<?> entityPath = new PathBuilder<>(entityClass, "e");
        List<?> results = queryFactory.select(entityPath)
                .from(entityPath)
                .where(predicate)
                .offset((pageNum - 1) * pageSize)
                .limit(pageSize)
                .fetch();

        if (results.isEmpty()) {
            throw new Exception("No data found");
        }

        return Mapper.mapToDto(dtoClass, results);
    }


    @Override
    public String test() {
        String repoName = Remote.getRepoNameFromRemote();
        System.out.println(repoName);
        return repoName;
    }


    @Override
    public boolean checkExist(String filter) throws Exception {
        String repoName = Remote.getRepoNameFromRemote();
        Class<?> entityClass = Remote.getEntityClassFromRemote();

        QueryDSL queryDSL = new QueryDSL();
        BooleanBuilder predicate = queryDSL.createFilter(entityClass, filter);

        QuerydslPredicateExecutor<?> predicateRepository =
                (QuerydslPredicateExecutor<?>) applicationContext.getBean(repoName);

        return predicateRepository.exists(predicate);
    }


}
