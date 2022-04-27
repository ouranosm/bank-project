package com.ouranosm.bankproject.repository;

import com.ouranosm.bankproject.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Xenofon Zinoviou
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
