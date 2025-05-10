package com.userservice.tata.Address;

import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<AddressEntity, Long>, JpaSpecificationExecutor<AddressEntity> {
    @Transactional
    @Modifying
    @Query("update AddressEntity ae set ae.AddressStatus = 1 where ae.AddressID =:id")
    int active(@Param("id")Long id);
}
