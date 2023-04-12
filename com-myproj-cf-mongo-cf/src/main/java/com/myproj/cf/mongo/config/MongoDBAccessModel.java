package com.myproj.cf.mongo.config;  


import com.fasterxml.jackson.annotation.JsonIgnorePorperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnorePorperties(ignoreUnknown = true)
public class MongoDBAccessModel {
  @JsonProperty("credentials")
  private Credentials credentials;
  @JsonProperty("instance_name")
  private String instanceName;
  @JsonProperty("plan")
  private String plan;


  //getters of above 3 props
  public String getDbName() { return credentials.getDbName();}
  public String getRole() { return credentials.getRole();}
  public String getPassword() { return credentials.getPassword();}
  public String getPort() { return credentials.getPort();}
  public String getUserName() { return credentials.getUserName();}
  public String getUri() { return credentials.geturi();}


  @JsonIgnorePorperties(ignoreUnknown = true)
  public static class Credentials {
  @JsonProperty("dbname")
  private String dbname ;
  @JsonProperty("role")
  private String role ;
  @JsonProperty("password")
  private String password;
  @JsonProperty("port")
  private String port;
  @JsonProperty("username")
  private String username;
  @JsonProperty("uri")
  private String uri;
  //getters
  }
