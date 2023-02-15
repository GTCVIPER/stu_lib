package com.gtc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

  private Integer id;
  private String name;
  private Integer price;
  private String author;



}
