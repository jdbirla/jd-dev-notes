# JPA Guide
- https://medium.com/@saurabh.kundu/hibernate-a-guide-to-essential-annotations-5588d459b6f
## ID Generation
  - GenerationType.AUTO : It dependecy on data base mostly it used SEQUNCE 
  - GenerationType.Identity : It relies on auto-incremented database column
  - GenerationType.SEQUNCE : It uses databse sequnce to generate
  - GenerationType.TABLE : for pessimistic locks

##  @CreationTimestamp and @UpdateTimestamp

## Query
### Query Generation by Spring Data JPA
### @Query
 - We can write JPQL query 
  #### @Query JPQL using index parameters
  ```java
  //JPQL Query using index params
    @Query("select p from Product p where p.name  =?1 or p.description=?2")
    public Product findByNameorDescriptionJPQLIndexParam(String name, String description);
```
  #### @Query JPQL using named parameters 
```java
    //JPQL Query using named params
    @Query("select p from Product p where p.name  =:name or p.description=:desc")
    public Product findByNameorDescriptionJPQLNamedParam(@Param("name") String name, @Param("desc") String description);
```
  #### @Query for Native SQL Queries using index parameters
 ```java

    //Native SQl Query using index params
    @Query(value = "select * from products p where p.name  =?1 or p.description=?2" , nativeQuery = true)
    public Product findByNameorDescriptionSQLIndexParam(String name, String description);
```
  #### @Query for Native SQL Queries using named parameters

 ```java
    //Native SQL Query using named params

    @Query(value = "select * from products p where p.name  =:name or p.description=:desc" , nativeQuery = true)
    public Product findByNameorDescriptionSQLNamedParam(@Param("name") String name, @Param("desc") String description);
```
### Named Queries
#### @NamedQuery for JPQL named Query
```java
//Entity
@NamedQueries(
        {
                @NamedQuery(
                        name = "Product.findAllProductsOrderByNameDesc",
                        query = "select p from Product p order by p.name desc"
                ),
                @NamedQuery(
                        name = "Product.findByPrice",
                        query = "select p from Product p where p.price =:price"
                )
        }
)

// reposiroty 
public List<Product> findAllProductsOrderByNameDesc();
 public Product findByPrice(@Param("price") BigDecimal price);

```

#### @NamedNativeQuery for SQL Native named Query
```java

@NamedNativeQueries(
        {
                @NamedNativeQuery(
                        name = "Product.findAllProductsOrderByNameAsc",
                        query = "select * from products p order by p.name asc",
                        resultClass = Product.class
                ),
                @NamedNativeQuery(
                        name = "Product.findBySku",
                        query = "select * from products p where p.stock_keeping_unit = ?1",
                        resultClass = Product.class
                )
        }
)
//repository
    @Query(nativeQuery = true)
    public Product findBySku (String sku);

    @Query(nativeQuery = true)
    public List<Product> findAllProductsOrderByNameAsc();
```

