package com.ouranosm.bankproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.OffsetDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author : Xenofon Zinoviou
 */
@Data
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Table(name = "CUSTOMER", schema = "bank_project_schema")
public class Customer {

  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "FIRST_NAME", length = 100)
  private String firstName;

  @Column(name = "LAST_NAME", length = 100)
  private String lastName;

  @Column(name = "DATE_CREATED")
  private OffsetDateTime dateCreated;

  @OneToMany(mappedBy = "customer")
  private List<Account> accounts;
}
