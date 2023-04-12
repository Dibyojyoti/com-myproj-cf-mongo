package com.myproj.cf.mongo.config;


import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Configuration
public class  CfEnvConfig extends MongoDBConfigTemplate {


  private static final Logger logger = LoggerFactory.getLogger(CfEnvConfig.class);
  private MongoDBAccessModel  mongoDBAccessModel;
  private final ObjectMapper jsonParser = new ObjectMapper();


  @PostConsutruct
  public void init() throws Exception {
    String vCapString = System.getenv("VCAP_SERVICES");
    initMongoDB( vCapString );
  }
@Bean
 public MongoDBAccessModel getMongoCreentials() {return mongoDBAccessModel;}
 
 private void  initMongoDB(String vCapString) {
   logger.info("Initializing Mongo DB configurations from VCAP...");
   try {
    JsonNode jsonNodeVcap = jsonParser.readTree(vCapString);
    if( jsonNodeVcap.has("mongodb")) {
      JsonNode mongodb =  jsonNodeVcap.get("mongodb").get(0);
      monDBAccessModel =  jsonParser.treeToValue(mongodb, MonDBAccessModel.class);
    } else {
      logger.error("No mongodb in vcap");
    }
   } catch(Exception e) {
    logger.error("could not initialzeDB {}", e);
   }
 }
  @Override    
  public String getDbName(){return mongoDBAccessModel.getDbName();}
  @Override  
  public String getDbInstanceName() {return mongoDBAccessModel.getInstanceName();}
  @Override  
  public String getDbPlan() {return mongoDBAccessModel.getPlan();}
  @Override  
  public String getDbRole() {return mongoDBAccessModel.getRole();}
  @Override  
  public String getDbPort() {return mongoDBAccessModel.getPort();}
  @Override  
  public String getDbUsername() {return mongoDBAccessModel.getUsername();}
  @Override  
  public String getDbPassword() {return mongoDBAccessModel.getPassword();}
  @Override  
  public String getDbUrl() { return mongoDBAccessModel.getUri(); }
}
