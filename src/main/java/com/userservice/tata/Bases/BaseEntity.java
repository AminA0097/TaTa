package com.userservice.tata.Bases;

import com.userservice.tata.Annotation.IsBoolean;
import com.userservice.tata.Util.convertToDatabaseColumn;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name ="UPDATED_BY")
    private String updatedBy;
    @Column(name = "DELETED")
    @Convert(converter = convertToDatabaseColumn.class)
    @IsBoolean()
    private Boolean deleted;
}
