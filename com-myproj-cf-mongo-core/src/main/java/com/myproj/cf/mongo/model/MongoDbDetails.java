package  package com.myproj.cf.mongo.model;


public class  MongoDBDetails{
  private String dbInstanceName;
  private String dbPlan;
  private String dbName;
  private String dbRole:
  private String dbPort;
  private String dbUsername;
  private String dbPassword;
  private String uri;


  public   MongoDBDetails( String dbInstanceName,  String dbPlan, String dbName ,String dbRole , 
                                     String dbPort, String dbUsername, String dbPassword, String uri) {
    Objects.requireNotNull( <field>, " <field> must not be null");
    this.<field> = <field>;
  }
  //add getters
  public String getDbUrl() {return "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;}
}
