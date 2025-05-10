package com.userservice.tata.Bases;

import com.userservice.tata.Address.AddressEntity;
import com.userservice.tata.More.EntityField;
import com.userservice.tata.More.IsBoolean;
import com.userservice.tata.More.Remote;
import jakarta.persistence.criteria.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public class BaseService<T> implements BaseInterFace<T> {
    @Autowired
    private ApplicationContext applicationContext;
    @Override
    public Specification<T> createFilter(Class<T> entityClass, String filter) throws Exception {
        System.out.println("Entering createFilter with filter: " + filter);
        return (root, query, criteriaBuilder) -> {
            if (filter == null || filter.isEmpty()) {
                return null;
            }

            List<Predicate> predicates = new ArrayList<>();
            String[] filters = filter.split(";");

            for (String f : filters) {
                if (!f.startsWith("e")) continue;

                String[] fs = f.substring(2).split("@");
                if (fs.length != 2) continue;

                String fieldName = fs[0];
                String value = fs[1];

                String[] fieldParts = fieldName.split("\\.");
                Path<?> path = root;
                Class<?> clazz = entityClass;
                Field currentEntityField = null;

                for (int i = 0; i < fieldParts.length; i++) {
                    String segment = fieldParts[i];
                    try {
                        currentEntityField = clazz.getDeclaredField(segment);
                    } catch (NoSuchFieldException e) {
                        throw new RuntimeException("Field not found: " + segment, e);
                    }

                    if (i < fieldParts.length - 1) {
                        if (currentEntityField.isAnnotationPresent(EntityField.class)) {
                            path = root.join(segment);
                            clazz = currentEntityField.getType();
                        } else {
                            path = path.get(segment);
                            clazz = currentEntityField.getType();
                        }
                    } else {
                        path = path.get(segment);
                        clazz = currentEntityField.getType();
                    }
                }

                Object typedValue = value;
                if (currentEntityField != null && currentEntityField.isAnnotationPresent(IsBoolean.class)) {
                    if (value.equalsIgnoreCase("0") || value.equalsIgnoreCase("false")) {
                        typedValue = false;
                    } else if (value.equalsIgnoreCase("1") || value.equalsIgnoreCase("true")) {
                        typedValue = true;
                    } else {
                        throw new IllegalArgumentException("Invalid boolean value: " + value);
                    }
                }

                Predicate predicate = criteriaBuilder.equal(path, typedValue);
                predicates.add(predicate);
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    @Override
    public boolean checkExist(Class<T> entityClass, String filter) throws Exception {
        String repoName = Remote.getRepoNameFromRemote(entityClass);
        Specification<T> specification = createFilter(entityClass,filter);
        JpaSpecificationExecutor<T> repository = (JpaSpecificationExecutor<T>)applicationContext.getBean(repoName);
        int res =  (int) repository.count(specification);
        if(res >0){
            return true;
        }
        return false;
    }

    @Override
    public String save(T entity) throws Exception {
        return "";
    }

    @Override
    public String test() {
        return "Test";
    }

    @Override
    public List<T> findAll() throws Exception {
        return null;
    }
}
