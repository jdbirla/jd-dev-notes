# SpringBoot

## References
* <https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/>
* <https://github.com/spring-projects/spring-boot>
* <https://github.com/spring-io/start.spring.io>
* <https://github.com/spring-io/initializr>
---

## Spring Boot Project Folder Structure
```
└── MyJavaProject
    ├── src
    │   ├── main
    │   │   ├── java
    │   │   │   └── com.jd.blog
    │   │   │       └── bootstrap
    │   │   │       └── config
    │   │   │       └── conroller
    │   │   │       └── entity
    │   │   │       └── exception
    │   │   │       └── payload
    │   │   │       └── repository
    │   │   │       └── security
    │   │   │       └── service
    │   │   │           └── impl
    │   │   │        └── utils
    │   │   └── resources
    │   │       └── application.properties
    │   │   
    │   │       
    │   └── test
    │       ├── java
    │       │   └── com
    │       │       └── example
    │       │           └── MyApplicationTest.java
    │       └── resources
    │           └── test.properties
    ├── target
    │   ├── classes
    │   │   └── com
    │   │       └── example
    │   │           └── MyApplication.class
    │   └── test-classes
    │       └── com
    │           └── example
    │               └── MyApplicationTest.class
    ├── pom.xml
    └── README.md

```
---
## Featrues
### Banner
<https://www.baeldung.com/spring-boot-custom-banners>
<https://www.baeldung.com/spring-boot-color-banner>

### Disable H2 in Spring Boot Test
- Disable H2 DB `@AutoConfigurationTestDataBase(replace = AutoConfigurationTestDatabase.Replace.NONE)
![image](https://user-images.githubusercontent.com/69948118/236414915-80f23a38-90fa-481e-bdf7-ed4d696c1149.png)

### Actuator Implementation
- <https://github.com/jdbirla/JD_Spring_Boot_Master/blob/master/Actuator.md>
- <https://howtodoinjava.com/spring-boot/info-endpoint-custom-info/>
- <https://howtodoinjava.com/spring-boot/actuator-endpoints-example/>

### All annotation
- <https://github.com/jdbirla/JD_spring-master-class/blob/master/Spring_Annotatoin_world.adoc>

### DTO Pattern

### How to follow good coding standards in Spring Boot
https://levelup.gitconnected.com/how-to-follow-good-coding-standards-in-spring-boot-a22dd735e3ec


### How to call Spring Boot Rest API’s Concurrently
<https://levelup.gitconnected.com/how-to-call-spring-boot-rest-apis-concurrently-e23f93448d25>

### Hikari configuration in Spring boot
- <https://springframework.guru/hikari-configuration-for-mysql-in-spring-boot-2/>

### Flyway Migration
- <https://springframework.guru/database-migration-with-flyway/>

### Using Filters in Spring Web Applications
- <https://springframework.guru/using-filters-in-spring-web-applications/>
- Some of the common use cases of filters are:
   - Logging requests and response
   - Logging request processing time
   - Formatting of request body or header
   - Verifying authentication tokens
   - Compressing response
   - Performing Image conversions

### Scheduling in Spring Boot
- <https://springframework.guru/scheduling-in-spring-boot/>

### MySQL Stored Procedures with Spring Boot
#### Approach 1 – @NamedStoredProcedureQuery Annotation
#### Approach-2 @Procedure Annotation
```sql
CREATE PROCEDURE 'GET_TOTAL_BLOGS_BY_TITLE' (IN title_in VARCHAR(50), OUT count_out INT)
BEGIN
 SELECT COUNT(*) into count_out from blog WHERE title = title_in;
END
```
```java
@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {

    @Procedure
    int GET_TOTAL_BLOGS_BY_TITLE(String title);

    @Procedure("GET_TOTAL_BLOGS_BY_TITLE")
    int getTotalBlogsByTitle(String title);

    @Procedure(procedureName = "GET_TOTAL_BLOGS_BY_TITLE")
    int getTotalBlogsByTitleProcedureName(String model);

    @Procedure(value = "GET_TOTAL_BLOGS_BY_TITLE")
    int getTotalBlogsByTitleValue(String model);

    @Procedure(name = "Blog.getTotalBlogsByTitleEntiy")
    int getTotalBlogsByTitleEntiy(@Param("model_in") String model);



}
```
```java
@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public int getTotalBlogsByTitle(String title) {
        return blogRepository.getTotalBlogsByTitle(title);
    }

    public int getTotalBlogsByTitleProcedureName(String title) {
        return blogRepository.getTotalBlogsByTitleProcedureName(title);
    }

    public int getTotalBlogsByTitleValue(String title) {
        return blogRepository.getTotalBlogsByTitleValue(title);
    }

    public int getTotalBlogsByTitleExplicit(String title) {
        return blogRepository.GET_TOTAL_BLOGS_BY_TITLE(title);
    }

    public int getTotalBlogsByTitleEntity(String title) {
        return blogRepository.getTotalBlogsByTitleEntiy(title);
    }

}
```

----
## Utility
### Lombok
<https://howtodoinjava.com/?s=lombok>
<https://www.baeldung.com/?s=lombok>

### Flyway
<https://medium.com/javarevisited/database-migration-in-spring-boot-using-flyway-ee791db8aea0>

### Java Tools
- <https://github.com/jdbirla/JD_JAVA_Learning/tree/master/Java_Tools>

### Java Faker API
- [baeldung](https://www.baeldung.com/java-faker) - avaFaker library to generate real-looking fake data!.
- [github ilinkj](https://github.com/DiUS/java-faker) 

### Mapper 
#### Model Mapper
    <http://modelmapper.org/>
```java
    private Post mapToEntity(PostDto postDto) {
        Post post = mapper.map(postDto,Post.class);
        return post;
    }
```
#### mapstruct
- <https://github.com/mapstruct/mapstruct>
```java
@Mapper 1
public interface CarMapper {
 
    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class ); 3
 
    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDto carToCarDto(Car car); 2
}

@Test
public void shouldMapCarToDto() {
    //given
    Car car = new Car( "Morris", 5, CarType.SEDAN );
 
    //when
    CarDto carDto = CarMapper.INSTANCE.carToCarDto( car );
 
    //then
    assertThat( carDto ).isNotNull();
    assertThat( carDto.getMake() ).isEqualTo( "Morris" );
    assertThat( carDto.getSeatCount() ).isEqualTo( 5 );
    assertThat( carDto.getType() ).isEqualTo( "SEDAN" );
}
```
