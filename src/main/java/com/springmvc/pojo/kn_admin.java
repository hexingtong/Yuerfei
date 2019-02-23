package com.springmvc.pojo;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public class kn_admin  implements Serializable{
 private Integer id;
 private Integer title;
 private Integer account;
 private Integer pwd;
 private Integer level;

 public void setId(Integer id) {
  this.id = id;
 }

 public void setTitle(Integer title) {
  this.title = title;
 }

 public void setAccount(Integer account) {
  this.account = account;
 }

 public void setPwd(Integer pwd) {
  this.pwd = pwd;
 }

 public void setLevel(Integer level) {
  this.level = level;
 }

 public Integer getId() {
  return id;
 }

 public Integer getTitle() {
  return title;
 }

 public Integer getAccount() {
  return account;
 }

 public Integer getPwd() {
  return pwd;
 }

 public Integer getLevel() {
  return level;
 }

 @Override
 public String toString() {
  return "kn_admin{" +
          "id=" + id +
          ", title=" + title +
          ", account=" + account +
          ", pwd=" + pwd +
          ", level=" + level +
          '}';
 }
}