package com.userservice.tata.More;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

public class Mapper {
    private static final Logger log = LoggerFactory.getLogger(Mapper.class);
    public static <S,D> D mapToDto(S source, Class<D> destinationClass) throws Exception{
        D destination = destinationClass.getDeclaredConstructor().newInstance();
        Field[] sourceFields = source.getClass().getDeclaredFields();
        for (Field sourceField : sourceFields) {
            try{
                Field destinationField = destinationClass.getDeclaredField(sourceField.getName());
                if(sourceField.isAnnotationPresent(DtoField.class)){
                    DtoField relationField = sourceField.getAnnotation(DtoField.class);
                    Class<?> entityClass = relationField.entityClass();
                    String relatedField = relationField.entityField();
                    Object relatedEntity = sourceField.get(source);
                    if (relatedEntity != null) {
                        Field relatedEntityField = entityClass.getDeclaredField(relatedField);
                        relatedEntityField.setAccessible(true);
                        Object relatedValue = relatedEntityField.get(relatedEntity);
                        destinationField.set(destination, relatedValue);
                    }
                }
                else {
                    destinationField.set(destination, sourceField.get(source));
                }
            }catch(Exception e){
                log.warn(e.toString());
            }
        }
        return destination;
    }
}
