package com.myproj.cf.mongo.config;


import org.springframework.bean.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;


import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;


@Configuration
public class  MyMongoDBConfig {
 @Autowired
  MongoDBConfigTemplate mongoDBConfig;


  @Bean
  public MongoTemplate mongoTemplate() throws Exception {
    MongoClient mongoClient = MongoClients.create(new ConnectionString(mongoDBConfig.getDbUri()));
    return new MongoTemplate(mongoClient,  mongoDBConfig.getDbName());
  }
}
