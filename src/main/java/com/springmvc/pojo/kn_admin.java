package com.springmvc.pojo;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public class kn_admin  implements Serializable{
 private Integer id;
 private String title;
 private String account;


 public void setId(Integer id) {
  this.id = id;
 }


 public void setTitle(String title) {
  this.title = title;
 }

 public String getTitle() {

  return title;
 }




 public Integer getId() {
  return id;
 }

 public void setAccount(String account) {
  this.account = account;
 }

 public String getAccount() {
  return account;
 }
}