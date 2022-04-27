package com.ouranosm.bankproject.entity;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

/**
 * @author : Xenofon Zinoviou
 */
@Data
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "customer"})
@Table(name = "ACCOUNT", schema = "bank_project_schema")
public class Account {

  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "BALANCE")
  private BigDecimal balance;

  @Column(name = "DATE_CREATED")
  private OffsetDateTime dateCreated;

  @ManyToOne(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST, REFRESH, DETACH})
  @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_CUSTOMER_ID"))
  private Customer customer;

}
