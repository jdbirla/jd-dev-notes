# JPA Guide
- https://medium.com/@saurabh.kundu/hibernate-a-guide-to-essential-annotations-5588d459b6f
## ID Generation
  - GenerationType.AUTO : It dependecy on data base mostly it used SEQUNCE 
  - GenerationType.Identity : It relies on auto-incremented database column
  - GenerationType.SEQUNCE : It uses databse sequnce to generate
  - GenerationType.TABLE : for pessimistic locks

##  @CreationTimestamp and @UpdateTimestamp

## Query
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/7541213c-2ad1-42c2-9f33-1c7d5720d007)

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
## Mapping
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/d12c29a1-cf39-485d-be6c-d7807aa50745)

### One-to-One Mapping: 
  #### Unidirectional mapping : 
      - Source entity has a relationship field that refers to the target entity and the source entity's table contains the foreign key
      ![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/941ef4c3-d97d-4633-8fb6-c08129c957e7)

```java
      @OneToOne(cascade = CasdeType.ALL)
      @JoinColumn(name = "billing_address_id" , referencedColumnName = "id")
```
  #### Bidirectional Mapping:
      - Each entity has a relationship field that refers to each other and the target entity table contain the foreign key. The source entity must use the mappedBy attributr to define the bidirectional one-to-one mapping
```java
public class Order {
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)
    private Address billingAddress;
    }
    
    public class Address {
    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
    private Order order;
  }  
```
### One-to-Many Mapping

 - Child tables record reference the primary key or the parent table
   #### Unidirectional mapping : 
   ![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/1a3c3a97-cd20-4e34-b98b-05bc885e8ba6)

   - Parent entity will have OnetoMany relationship , Foreign key column in child table which referes to primary key of the parent table
   
   ```java
   public class Order {
    //Default fetch type for one to many is LAZY
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumnn(name = "order_id" , referenceColumnName = "id")
    private Set<OrderItem> orderItemSets = new HashSet<>();
    ```
#### Bidirectional mapping : 
   ![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/c7a128c2-d75c-43a4-b285-7d1c2ab0829e)
   - Parent entity will have OnetoMany and child entity will have ManyToOne relationship , Foreign key column in child table which referes to primary key of the parent table
```java
public class Order {
    //Default fetch type for one to many is LAZY
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    private Set<OrderItem> orderItemSets = new HashSet<>();
}

public class OrderItem {
    //Default fetch type of ManyToOne : EAGER
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
```
### Many-to-Many Mapping
  ![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/a25e3a51-b82c-486a-838c-ab04ce3adddd)
- It use a table to store association that join two entities.

 #### Unidirectional mapping : 
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/1338cc5a-9bff-4207-8613-5d9af8d5bfd4)
- Source entity has @ManyToMany annotation
```java
public class User {
 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"
            )
    )
    private Set<Role> roles = new HashSet<>();
    }
```
#### Bidirectional mapping : 
- Both entities have @ManyToMany annotation
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/8879d993-34d4-40de-b1e9-1b1f1d49e709)
```java
public class User {
 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"
            )
    )
    private Set<Role> roles = new HashSet<>();
    }
    
    public class Role {
  
    @ManyToMany(mappedBy = "roles" , cascade = {CascadeType.PERSIST, CascadeType.MERGE} , fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();

}
    
```

 
