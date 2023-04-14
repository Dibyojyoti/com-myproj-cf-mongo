# com-myproj-cf-mongo
sample project to access ongo db from an application in Cloud Foundry 

https://www.baeldung.com/spring-boot-multiple-modules

com-myproj-cf-mongo
|---com-myproj-cf-mongo-cf
|    |---src
|    |    |---main
|    |    |    |---java
|    |    |    |   |---com.myproj.cf.mongo.config
|    |    |    |   |    |---CfEnvConfig
|    |    |    |   |    |---MongoDBAccessModel
|    |    |    |---resources
|    |    |    |   |---application.properties
|    |    |    |---webapp
|    |    |    |   |---WEB-INF
|    |    |    |   |   |---web.xml
|    |    |---test
|    |    |    |---java
|    |    |    |---resources
|    |---pom.xml
|---com-myproj-cf-mongo-core
|    |---src
|    |    |---main
|    |    |    |---java
|    |    |    |   |---com.myproj.cf.mongo
|    |    |    |   |    |---api
|    |    |    |   |    |    |---MongoDBController
|    |    |    |   |    |---config
|    |    |    |   |    |    |--MongoDBConfigTemplate
|    |    |    |   |    |    |--MyMongoDBConfig
|    |    |    |   |    |---model
|    |    |    |   |    |    |---ErrorResponse
|    |    |    |   |    |    |---MongoDbDetails
|    |    |    |   |    |    |---Employee
|    |    |    |   |    |---App.Java
|    |    |    |---resources
|    |    |    |   |    |---application.properties
|    |    |---test
|    |    |    |---java
|    |    |    |---resources
|    |---pom.xml
|---manifest.yaml
|---pom.xml  
