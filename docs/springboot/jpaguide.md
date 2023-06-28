# JPA Guide
- <https://medium.com/@saurabh.kundu/hibernate-a-guide-to-essential-annotations-5588d459b6f>
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

### One-to-One Mapping
#### Unidirectional mapping
- Source entity has a relationship field that refers to the target entity and the source entity's table contains the foreign key
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/941ef4c3-d97d-4633-8fb6-c08129c957e7)

```java
public class Order {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id" , referencedColumnName = "id")
    private Address billingAddress;
    }
```
#### Bidirectional Mapping
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
## JPA Inheritance
### Mapped Super Class
- Base entity example <https://medium.com/codex/base-entity-and-audit-entity-with-jpa-fe413ad18bda>
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/b4833640-a5c0-4bcb-8d2b-3898d388aac2)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/e6d13ebf-b93e-4dd4-ad18-611e960a2495)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/ebd9b96c-0519-49e4-9da9-39aaa52833eb)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/e63a22b0-3487-439a-bbad-2251b6c3d4a5)

- It will create tables for each sublcass with parent fields
  
```java
 @MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
//---
 @Entity
public class OrderHeader extends BaseEntity {

    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
 ```
### Single Table
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/30680a4f-5100-41aa-a08d-08e08e21713f)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/79375321-d64e-4a21-870e-75cf4ea53cef)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/f37b3198-0631-42dd-a85f-c29a6b50da13)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/8590e2a1-d033-43ed-8d08-28ae2a363734)

- It will create single table for all subclasses it will include all fields from parent and all child classes and it will have a discriminator column for identification of rows for child
```java
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicle_type")
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

@Entity
@DiscriminatorValue("car")
public class Car extends Vehicle{

    private String trimLevel;

    public String getTrimLevel() {
        return trimLevel;
    }

    public void setTrimLevel(String trimLevel) {
        this.trimLevel = trimLevel;
    }
}
@Entity
@DiscriminatorValue("truck")
public class Truck extends Vehicle{

    private Integer payload;

    public Integer getPayload() {
        return payload;
    }

    public void setPayload(Integer payload) {
        this.payload = payload;
    }
}

```
### Joined Table
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/093e1ba8-ce54-4905-aaf4-e1695dd6b289)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/c3e6dc30-afc6-45a7-970a-4bca8ad3d85a)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/2780ac1f-2299-40a9-a378-ef223d276aee)
- Each entity has its own table with shared attribute from parent will have foreign key to parent tables
```java
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
@Entity
public class Piano extends Instrument {

    private Integer numberOfKeys;

    public Integer getNumberOfKeys() {
        return numberOfKeys;
    }

    public void setNumberOfKeys(Integer numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }
}
@Entity
public class ElectricGuitar extends Guitar{

    private Integer numberOfPickups;

    public Integer getNumberOfPickups() {
        return numberOfPickups;
    }

    public void setNumberOfPickups(Integer numberOfPickups) {
        this.numberOfPickups = numberOfPickups;
    }
}
@Entity
public class Guitar extends Instrument {

    private Integer numberOfStrings;

    public Integer getNumberOfStrings() {
        return numberOfStrings;
    }

    public void setNumberOfStrings(Integer numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }
}
```
### Tables per class
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/8f661394-2d79-4578-b9b4-3943068ff2c7)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/6962e270-b737-49ab-94e4-44e8c0a8e738)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/3d17d511-3757-4e30-a4d4-c6246c665c1e)
```java
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Mammal {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private Integer bodyTemp;

    private String species;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBodyTemp() {
        return bodyTemp;
    }

    public void setBodyTemp(Integer bodyTemp) {
        this.bodyTemp = bodyTemp;
    }

    public String getSpecies() {
        return species;
    }s

    public void setSpecies(String species) {
        this.species = species;
    }
}
@Entity
public class Dog extends Mammal {

    private String breed;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}

@Entity
public class Dolphin extends Mammal {

    private Boolean hasSpots;

    public Boolean getHasSpots() {
        return hasSpots;
    }

    public void setHasSpots(Boolean hasSpots) {
        this.hasSpots = hasSpots;
    }
}
```
- Each entity has its own table and There is no explicit foreign key relationship between the tables representing subclasses and the superclass.


