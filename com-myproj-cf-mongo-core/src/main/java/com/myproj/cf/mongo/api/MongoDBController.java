package com.myproj.cf.mongo.api;  


import java.util.List;


import javax.inject.Inject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.data.mongodb.core.MongoTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.myproj.cf.mongo.config.MongoDBConfigTemplate;
import com.myproj.cf.mongo.model.Employee;
import com.myproj.cf.mongo.model.MongoDbDetails;
import com.myproj.cf.mongo.model.ErrorResponse;


@RestController 
public class  MongoDbController {
  private static final Logger logger = LoggerFactory.getLogger(MongoDbController.class);
  private final ObjectMapper jsonParser = new ObjectMapper();


  @Inject
  private MongoDBConfigTemplate mDbConfig;


  @Autowired
  MongoTemplate mongoTemplate;


  @RequestMapping(value = "/mdb_details", method = {RequestMethod.GET})
  public  ResponseEntity<Object> getDbDetails() {
     ResponseEntity<Object> response = null;
     ErrorResponse errorResponse = null;
     MongoDbDetails mongoDbDetails = null;
     try {
        mongoDbDetails = new  MongoDbDetails(mDbConfig.getDbInstanceName(),
                                                              mDbConfig.getDbPlan(),
                                                              mDbConfig.getDbName(),
                                                              mDbConfig.getDbRole(),
                                                              mDbConfig.getDbPort(),
                                                              mDbConfig.getDbUsername(),
                                                              mDbConfig.getDbPassword(),
                                                              mDbConfig.getDbUri());
        response = new ResponseEntity<Object>( jsonParser.writeValueAsString(mongoDbDetails), HttpStatus.OK);
     } catch(Exception e) {
        logger.error("Exception getting DBdetails {}", e);
        errorResponse = new ErrorResponse();
        errorResponse.setMessage(e.getMessage());
        response = new ResponseEntity<Object>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
     }
     return response;
  }
  @RequestMapping(value = "/get_employees", method = {RequestMethod.GET})
  public  ResponseEntity<Object> getVersion() {
     ResponseEntity<Object> response = null;
     ErrorResponse errorResponse = null;
       
     try {
       Employee employee1 = new Employee("employee1", "35");
       Employee employee2 = new Employee("employee2", "45");
       mongoTemplate.insert(employee1, "employee"); //"employee" is a collection
       mongoTemplate.insert(employee2, "employee"); //"employee" is a collection
       List<Employee> employees = mongoTemplate.findAll(Employee.class, "employee");
       response = new ResponseEntity<Object>( jsonParser.writeValueAsString(empllyees), HttpStatus.OK);
       mongoTemplate.dropCollection("employee");
     } catch(Exception e) {
        logger.error("Exception  {}", e);
        errorResponse = new ErrorResponse();
        errorResponse.setMessage(e.getMessage());
        response = new ResponseEntity<Object>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
     }
     return response;
  }  
}
