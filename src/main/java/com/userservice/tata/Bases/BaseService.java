package com.userservice.tata.Bases;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.PathBuilder;
import com.userservice.tata.Address.AddressDto;
import com.userservice.tata.Filter.QueryDSL;
import com.userservice.tata.Util.Remote;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
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
    protected String buildFinalFilter(String filter)throws Exception {
        if (filter != null && !filter.trim().isEmpty()) {
            return filter.trim();
        }
        List<String> constraintFilters = getConstraint();
        return String.join(";",constraintFilters);

    }
    protected List<String> getConstraint() throws Exception {
        List<String> constraints = new ArrayList<>();
        if(!constraints.contains("e.deleted@eq0")){
            constraints.add("e.deleted@eq0");
        }
        return constraints;
    }
    @Override
    @Transactional
    public List<?> getList(String filter, int pageNum, int pageSize) throws Exception {
        pageNum = pageNum > 0 ? pageNum : 1;
        pageSize = pageSize > 20 ? pageSize : 20;
        String finalFilter = buildFinalFilter(filter);
        Class<?> dtoClass = Remote.getDtoNameFromRemote(this.getClass());
        Class<?> entityClass = Remote.getEntityClassFromRemote(this.getClass());
        QueryDSL queryDSL = new QueryDSL();
        BooleanBuilder predicate = queryDSL.createFilter(entityClass, finalFilter);
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        PathBuilder<?> entityPath = new PathBuilder<>(entityClass, "e");
        List<?> results = queryFactory.select(entityPath)
                .from(entityPath)
                .where(predicate)
                .offset((pageNum - 1) * pageSize)
                .limit(pageSize)
                .fetch();
        Constructor<?> constructor = dtoClass.getConstructor(entityClass);
        List<Object> list = new ArrayList<>();
        for (Object o : results) {
            list.add(constructor.newInstance(o));
        }
        if (list.isEmpty()) {
            throw new Exception("No data found");
        }

        return list;
//        return Mapper.mapToDto(dtoClass, results);
    }


    @Override
    public String test() {
        String repoName = Remote.getRepoNameFromRemote();
        System.out.println(repoName);
        return repoName;
    }


    @Override
    public boolean checkExist(String filter) throws Exception {
        return false;
//        String repoName = Remote.getRepoNameFromRemote();
//        Class<?> entityClass = Remote.getEntityClassFromRemote();
//
//        QueryDSL queryDSL = new QueryDSL();
//        BooleanBuilder predicate = queryDSL.createFilter(entityClass, filter);
//
//        QuerydslPredicateExecutor<?> predicateRepository =
//                (QuerydslPredicateExecutor<?>) applicationContext.getBean(repoName);
//
//        return predicateRepository.exists(predicate);
    }


}
