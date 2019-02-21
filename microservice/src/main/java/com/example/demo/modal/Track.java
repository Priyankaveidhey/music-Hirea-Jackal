package com.example.demo.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "track")
public class Track
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id = 0l;

  @Column(name = "name")
  private String name;

  @Column(name = "genre")
  private Long genre;

  @Column(name = "rating")
  private int rating;

  @Column(name = "created_time")
  private Long createdTime = System.currentTimeMillis() / 1000;

  @Column(name = "updated_time")
  private Long updatedtime = 0L;

  @PrePersist
  public void prePersit()
  {

    if (this.id == null || this.id == 0L)
      this.createdTime = System.currentTimeMillis() / 1000;
    else
      this.updatedtime = System.currentTimeMillis() / 1000;

  }
}
