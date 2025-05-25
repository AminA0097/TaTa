package com.userservice.tata.Util;

import com.userservice.tata.Annotation.DtoField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Mapper {
    private static final Logger log = LoggerFactory.getLogger(Mapper.class);

    public static <D, T> List<D> mapToDto(Class<D> destinationClass, List<T> resList) throws Exception {
        List<D> destinationList = new ArrayList<>();

        for (T sourceObject : resList) {
            Class<?> sourceClass = sourceObject.getClass();
            Field[] sourceFields = sourceClass.getDeclaredFields();

            D destination = destinationClass.getDeclaredConstructor().newInstance();
            Field[] destinationFields = destinationClass.getDeclaredFields();

            for (Field destinationField : destinationFields) {
                try {
                    destinationField.setAccessible(true);

                    // If annotated with @DtoField, handle relational mapping
                    if (destinationField.isAnnotationPresent(DtoField.class)) {
                        DtoField relationField = destinationField.getAnnotation(DtoField.class);
                        Class<?> relatedEntityClass = relationField.entityClass();
                        String relatedEntityFieldName = relationField.entityField();

                        for (Field sourceField : sourceFields) {
                            sourceField.setAccessible(true);
                            if (sourceField.getName().equals(destinationField.getName())) {
                                Object relatedEntity = sourceField.get(sourceObject);
                                if (relatedEntity != null) {
                                    Field relatedEntityField = relatedEntityClass.getDeclaredField(relatedEntityFieldName);
                                    relatedEntityField.setAccessible(true);
                                    Object relatedValue = relatedEntityField.get(relatedEntity);
                                    destinationField.set(destination, relatedValue);
                                }
                            }
                        }
                    } else {
                        // Regular field: match by name
                        for (Field sourceField : sourceFields) {
                            if (sourceField.getName().equals(destinationField.getName())) {
                                sourceField.setAccessible(true);
                                Object value = sourceField.get(sourceObject);
                                destinationField.set(destination, value);
                                break;
                            }
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Mapping failed for field " + destinationField.getName() + ": " + e.getMessage());
                }
            }

            destinationList.add(destination);
        }

        return destinationList;
    }
}
