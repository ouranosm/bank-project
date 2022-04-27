package com.ouranosm.bankproject.repository;

import com.ouranosm.bankproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Xenofon Zinoviou
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
