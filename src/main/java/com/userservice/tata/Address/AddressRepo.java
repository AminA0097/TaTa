package com.userservice.tata.Address;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
public interface AddressRepo extends
        JpaRepository<AddressEntity, Long>,
        QuerydslPredicateExecutor<AddressEntity>,
        JpaSpecificationExecutor<AddressEntity> {
    @Transactional
    @Modifying
    @Query("update AddressEntity ae set ae.AddressStatus = 1 where ae.AddressID =:id")
    int active(@Param("id")Long id);
}
