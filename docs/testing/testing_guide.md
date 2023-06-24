# Testing Guide
- Sping-boot-starter-test
   - spring specific
   - Junit , Mockito , hamcrest, AssertJ, JSONassert and JsonPath
   - Hamcrest : called matcher it working with Junit and assertj unit testing framwork
                 it has is() method of the matchers class `assertThat(Actual, is(EXPECTED))`
   - JsonPath lib : jsonpath is used to test JSON response from service , root member object in is always refer to as '$'
   - @WebMvcTest vs @SpringBootTest : @WebMvcTest is for unit testing its load only spefic controller 
   -  @SpringBootTest  is for integration testing this will create context and loads full application context
- Siva_lab_testing_repo  https://github.com/sivaprasadreddy/java-testing-made-easy
### [1.Unit Testing](#unit-testing)
- [Repository-Layer (@DataJpaTest)](#repository-layer)
- [Mockito](#mockito)
- [Service-Layer](#service-layer)
- [Controller-Layer(@WebMvcTest)](#controller-layer)
    - @MockBean : The @MockBean annotation tells spring to create instance of EmployeeService and add it to the application context so that it's injected into employeeController.
### [2.Integration Testing](#integration-testing)

### [3.Test Container](#test-container)
 - Problem with integration test in local : we need to install other tools like mysql, rabbit mq for external serices
 - TestContainer is java lobrary that supports JUnit Test Testcontainers is a Java library that provides support for launching ephemeral containers as part of a JUnit test. The containers can be used to run tests against a database or other service, to provide a clean and isolated environment for each test. This helps to prevent tests from interfering with each other, and also makes it easier to test against different versions or configurations of a service.

- Testcontainers provides a high-level API that makes it easy to launch containers and interact with them from your tests, as well as providing support for popular container images, such as those for databases like MySQL or PostgreSQL. This can greatly simplify the process of setting up a test environment, and reduce the amount of code that needs to be written to support tests.

### [4.All_Assertions](#all-asserstions)


### [5.Old Test sheet](#old-test-sheet)







## Unit Testing
- Don't use `@SpringBootTest` during unit test
- As its load all the beans which are not required for unit testing
- It will configured all using autoconfigurtion like flyway migration

### Repository-Layer
- it loads only repository layer not the service and controlller
- it will autocinfigure in-memory data for testing
- by default test annotated with @DataJpaTest is transacational and will rollback et end
```java
package com.jd.springboot.repository;

import com.jd.springboot.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

/**
 * Created by jd birla on 23-11-2022 at 10:37
 */
@DataJpaTest
public class EmployeeRepositoryTests {
    @Autowired
    private EmployeeRepository employeeRepository;
    private Employee employee;
    private Employee employee1;

    @BeforeEach
    private void setup() {
        //Given
        employee = Employee.builder().firstName("Jitendra").lastName("Birla").email("jitendra.birla@gmail.com").build();
        employee1 = Employee.builder().firstName("Jitu").lastName("Birla").email("jitendra@gmail.com").build();
        employeeRepository.save(employee);
        employeeRepository.save(employee1);
    }

    @Test
    @DisplayName("Testing employee object insertion")
    public void givenEmployeeObject_whenSave_thenReturnEmployee() {

        //Given
//        Employee employee =  Employee.builder().firstName("Jitendra").lastName("Birla").email("jitendra.birla@gmail.com").build();

        //When
//        employeeRepository.save(employee);

        //Then
        Assertions.assertThat(employee).isNotNull();
        Assertions.assertThat(employee.getId()).isNotNull();
        Assertions.assertThat(employee.getId()).isGreaterThan(0);

    }

    @Test
    @DisplayName("Testing all employees suing find all")
    public void givenAllEmployees_whenFetching_thenReturingAllEmployeeList() {
        //given
//             Employee employee =  Employee.builder().firstName("Jitendra").lastName("Birla").email("jitendra.birla@gmail.com").build();
//             Employee employee1 =  Employee.builder().firstName("Jitu").lastName("Birla").email("jitendra@gmail.com").build();
//             employeeRepository.save(employee);
//             employeeRepository.save(employee1);
        //When
        List<Employee> empList = employeeRepository.findAll();

        //Then
        Assertions.assertThat(empList).isNotEmpty();
        Assertions.assertThat(empList).isNotNull();
        Assertions.assertThat(empList).size().isEqualTo(2);

    }

    @Test
    @DisplayName("Testing an employee using employee id")
    public void givenEmployeeId_whenFetching_thenReturingAnEmployee() {
        //given
//        Employee employee =  Employee.builder().firstName("Jitendra").lastName("Birla").email("jitendra.birla@gmail.com").build();
//        Employee employee1 =  Employee.builder().firstName("Jitu").lastName("Birla").email("jitendra@gmail.com").build();
//        employeeRepository.save(employee);
//        employeeRepository.save(employee1);
        //When
        Employee emp = employeeRepository.findById(employee.getId()).get();

        //Then
        Assertions.assertThat(emp).isNotNull();

    }

    @Test
    @DisplayName("Test employee fetch using index on first name and last name")
    public void givenEmployeeFistLastName_whenFetching_thenReturingAnEmployee() {
        //given
//        Employee employee =  Employee.builder().firstName("Jitendra").lastName("Birla").email("jitendra.birla@gmail.com").build();
//        Employee employee1 =  Employee.builder().firstName("Jitu").lastName("Birla").email("jitendra@gmail.com").build();
//        employeeRepository.save(employee);
//        employeeRepository.save(employee1);
        //When
        Employee emp = employeeRepository.findByFirstLastName("Jitendra", "Birla");
        //Then
        Assertions.assertThat(emp).isNotNull();
        Assertions.assertThat(emp).isEqualTo(employee);

    }

    @Test
    @DisplayName("Test employee fetch using named params on first name and last name")
    public void givenEmployeeFistLastName_whenFetching_thenReturingAnEmployeebyNamedParams() {
        //given
//        Employee employee =  Employee.builder().firstName("Jitendra").lastName("Birla").email("jitendra.birla@gmail.com").build();
//        Employee employee1 =  Employee.builder().firstName("Jitu").lastName("Birla").email("jitendra@gmail.com").build();
//        employeeRepository.save(employee);
//        employeeRepository.save(employee1);
        //When
        Employee emp = employeeRepository.findByNamedParams("Jitendra", "Birla");

        //Then
        Assertions.assertThat(emp).isNotNull();
        Assertions.assertThat(emp).isEqualTo(employee);

    }

    @Test
    @DisplayName("Test employee fetch using Native sql query by index on first name and last name")
    public void givenEmployeeFistLastName_whenFetching_thenReturingAnEmployeebyNativeSQl() {
        //given
//        Employee employee =  Employee.builder().firstName("Jitendra").lastName("Birla").email("jitendra.birla@gmail.com").build();
//        Employee employee1 =  Employee.builder().firstName("Jitu").lastName("Birla").email("jitendra@gmail.com").build();
//        employeeRepository.save(employee);
//        employeeRepository.save(employee1);
        //When
        Employee emp = employeeRepository.findByNativeSql("Jitendra", "Birla");

        //Then
        Assertions.assertThat(emp).isNotNull();
        Assertions.assertThat(emp).isEqualTo(employee);

    }

    @Test
    @DisplayName("Test employee fetch using Native sql query by named paramson first name and last name")
    public void givenEmployeeFistLastName_whenFetching_thenReturingAnEmployeebyNativeSQlbyNamedParams() {
        //given
//        Employee employee =  Employee.builder().firstName("Jitendra").lastName("Birla").email("jitendra.birla@gmail.com").build();
//        Employee employee1 =  Employee.builder().firstName("Jitu").lastName("Birla").email("jitendra@gmail.com").build();
//        employeeRepository.save(employee);
//        employeeRepository.save(employee1);
        //When
        Employee emp = employeeRepository.findByNativeSqlNamedParams("Jitendra", "Birla");

        //Then
        Assertions.assertThat(emp).isNotNull();
        Assertions.assertThat(emp).isEqualTo(employee);

    }

    @Test
    @DisplayName("Test find all employees")
    public void givenEmployeeList_whenFindAll_thenReturingEmployeeList() {
        //given
//        Employee employee =  Employee.builder().firstName("Jitendra").lastName("Birla").email("jitendra.birla@gmail.com").build();
//        Employee employee1 =  Employee.builder().firstName("Jitu").lastName("Birla").email("jitendra@gmail.com").build();
//        employeeRepository.save(employee);
//        employeeRepository.save(employee1);
        //When
        Employee emp = employeeRepository.findByNativeSql("Jitendra", "Birla");

        //Then
        Assertions.assertThat(emp).isNotNull();
        Assertions.assertThat(emp).isEqualTo(employee);

    }

}

```
### Amigoscode- repository Layer
- AbstractTestcontainers
```java
package com.jd;

import com.github.javafaker.Faker;
import org.flywaydb.core.Flyway;
import javax.sql.DataSource;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
/**
 * Created by jd birla on 21-05-2023 at 16:18
 */
@Testcontainers
public abstract class AbstractTestcontainers {

    @BeforeAll
    static void beforeAll() {
        Flyway flyway = Flyway
            .configure()
            .dataSource(
                postgreSQLContainer.getJdbcUrl(),
                postgreSQLContainer.getUsername(),
                postgreSQLContainer.getPassword()
            ).load();
        flyway.migrate();
    }

    @Container
    protected static final PostgreSQLContainer<?> postgreSQLContainer =
        new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("amigoscode-dao-unit-test")
            .withUsername("amigoscode")
            .withPassword("password");

    @DynamicPropertySource
    private static void registerDataSourceProperties(
        DynamicPropertyRegistry registry) {
        registry.add(
            "spring.datasource.url",
            postgreSQLContainer::getJdbcUrl
        );
        registry.add(
            "spring.datasource.username",
            postgreSQLContainer::getUsername
        );
        registry.add(
            "spring.datasource.password",
            postgreSQLContainer::getPassword
        );
    }

    private static DataSource getDataSource() {
        return DataSourceBuilder.create()
            .driverClassName(postgreSQLContainer.getDriverClassName())
            .url(postgreSQLContainer.getJdbcUrl())
            .username(postgreSQLContainer.getUsername())
            .password(postgreSQLContainer.getPassword())
            .build();
    }

    protected static JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    protected static final Faker FAKER = new Faker();

}
```
- TestcontainersTest
```java
package com.jd;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
/**
 * Created by jd birla on 21-05-2023 at 16:20
 */
public class TestcontainersTest extends AbstractTestcontainers {

    @Test
    void canStartPostgresDB() {
        assertThat(postgreSQLContainer.isRunning()).isTrue();
        assertThat(postgreSQLContainer.isCreated()).isTrue();
    }

}
```
- CustomerJDBCDataAccessServiceTest
```java
package com.jd.customer;

import static org.assertj.core.api.Assertions.assertThat;

import com.jd.AbstractTestcontainers;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by jd birla on 22-05-2023 at 06:19
 */
class CustomerJDBCDataAccessServiceTest extends AbstractTestcontainers {

  private CustomerJDBCDataAccessService underTest;
  private final CustomerRowMapper customerRowMapper = new CustomerRowMapper();

  @BeforeEach
  void setUp() {
    underTest = new CustomerJDBCDataAccessService(getJdbcTemplate(), customerRowMapper);
  }

  @Test
  void selectAllCustomers() {
    // Given
    Customer customer = new Customer(FAKER.name().fullName(),
        FAKER.internet().safeEmailAddress() + "_" + UUID.randomUUID(), "password", 20,Gender.MALE );
    underTest.insertCustomer(customer);

    // When
    List<Customer> actual = underTest.selectAllCustomers();

    // Then
    assertThat(actual).isNotEmpty();
  }

  @Test
  void selectCustomerById() {
    // Given
    String email = FAKER.internet().safeEmailAddress() + "_" + UUID.randomUUID();
    Customer customer = new Customer(FAKER.name().fullName(), email, "password", 20,Gender.MALE );
    underTest.insertCustomer(customer);

    Integer custId = underTest.selectAllCustomers().stream()
        .filter(c -> c.getEmail().equalsIgnoreCase(email)).map(Customer::getId).findFirst()
        .orElseThrow();

    // When
    Optional<Customer> actual = underTest.selectCustomerById(custId);

    // Then
    assertThat(actual).isPresent().hasValueSatisfying(c -> {
      assertThat(c.getId()).isEqualTo(custId);
      assertThat(c.getName()).isEqualTo(customer.getName());
      assertThat(c.getEmail()).isEqualTo(customer.getEmail());
      assertThat(c.getAge()).isEqualTo(customer.getAge());
    });

  }

  @Test
  void willReturnEmptyWhenSelectCustomerById() {
    // Given
    int id = 0;

    // When
    var actual = underTest.selectCustomerById(id);

    // Then
    assertThat(actual).isEmpty();
  }

  @Test
  void existsPersonWithEmail() {
    // Given
    String email = FAKER.internet().safeEmailAddress() + "_" + UUID.randomUUID();
    Customer customer = new Customer(FAKER.name().fullName(), email, "password", 20,Gender.MALE );

    underTest.insertCustomer(customer);

    // When
    boolean actual = underTest.existsCustomerWithEmail(email);

    // Then
    assertThat(actual).isTrue();
  }

  @Test
  void existsPersonWithEmailReturnsFalseWhenDoesNotExists() {
    // Given
    String email = FAKER.internet().safeEmailAddress() + "-" + UUID.randomUUID();

    // When
    boolean actual = underTest.existsCustomerWithEmail(email);

    // Then
    assertThat(actual).isFalse();
  }

  @Test
  void existsCustomerWithId() {
    // Given
    String email = FAKER.internet().safeEmailAddress() + "_" + UUID.randomUUID();
    Customer customer = new Customer(FAKER.name().fullName(), email, "password", 20,Gender.MALE );

    underTest.insertCustomer(customer);

    int id = underTest.selectAllCustomers()
        .stream()
        .filter(c -> c.getEmail().equals(email))
        .map(Customer::getId)
        .findFirst()
        .orElseThrow();

    // When
    var actual = underTest.existsCustomerWithId(id);

    // Then
    assertThat(actual).isTrue();
  }

  @Test
  void existsPersonWithIdWillReturnFalseWhenIdNotPresent() {
    // Given
    int id = -1;

    // When
    var actual = underTest.existsCustomerWithId(id);

    // Then
    assertThat(actual).isFalse();
  }

  @Test
  void deleteCustomerById() {
    // Given
    String email = FAKER.internet().safeEmailAddress() + "_" + UUID.randomUUID();
    Customer customer = new Customer(FAKER.name().fullName(), email, "password", 20,Gender.MALE );

    underTest.insertCustomer(customer);

    int id = underTest.selectAllCustomers()
        .stream()
        .filter(c -> c.getEmail().equals(email))
        .map(Customer::getId)
        .findFirst()
        .orElseThrow();

    // When
    underTest.deleteCustomerById(id);

    // Then
    Optional<Customer> actual = underTest.selectCustomerById(id);
    assertThat(actual).isNotPresent();
  }

  @Test
  void updateCustomerName() {
    // Given
    String email = FAKER.internet().safeEmailAddress() + "_" + UUID.randomUUID();
    Customer customer = new Customer(FAKER.name().fullName(), email, "password", 20,Gender.MALE );

    underTest.insertCustomer(customer);

    int id = underTest.selectAllCustomers()
        .stream()
        .filter(c -> c.getEmail().equals(email))
        .map(Customer::getId)
        .findFirst()
        .orElseThrow();

    var newName = "foo";

    // When age is name
    Customer update = new Customer();
    update.setId(id);
    update.setName(newName);

    underTest.updateCustomer(update);

    // Then
    Optional<Customer> actual = underTest.selectCustomerById(id);

    assertThat(actual).isPresent().hasValueSatisfying(c -> {
      assertThat(c.getId()).isEqualTo(id);
      assertThat(c.getName()).isEqualTo(newName); // change
      assertThat(c.getEmail()).isEqualTo(customer.getEmail());
      assertThat(c.getAge()).isEqualTo(customer.getAge());
    });
  }

  @Test
  void updateCustomerEmail() {
    // Given
    String email = FAKER.internet().safeEmailAddress() + "_" + UUID.randomUUID();
    Customer customer = new Customer(FAKER.name().fullName(), email, "password", 20,Gender.MALE );

    underTest.insertCustomer(customer);

    int id = underTest.selectAllCustomers()
        .stream()
        .filter(c -> c.getEmail().equals(email))
        .map(Customer::getId)
        .findFirst()
        .orElseThrow();

    var newEmail = FAKER.internet().safeEmailAddress() + "-" + UUID.randomUUID();;

    // When email is changed
    Customer update = new Customer();
    update.setId(id);
    update.setEmail(newEmail);

    underTest.updateCustomer(update);

    // Then
    Optional<Customer> actual = underTest.selectCustomerById(id);

    assertThat(actual).isPresent().hasValueSatisfying(c -> {
      assertThat(c.getId()).isEqualTo(id);
      assertThat(c.getEmail()).isEqualTo(newEmail); // change
      assertThat(c.getName()).isEqualTo(customer.getName());
      assertThat(c.getAge()).isEqualTo(customer.getAge());
    });
  }

  @Test
  void updateCustomerAge() {
    // Given
    String email = FAKER.internet().safeEmailAddress() + "_" + UUID.randomUUID();
    Customer customer = new Customer(FAKER.name().fullName(), email, "password", 20,Gender.MALE );

    underTest.insertCustomer(customer);

    int id = underTest.selectAllCustomers()
        .stream()
        .filter(c -> c.getEmail().equals(email))
        .map(Customer::getId)
        .findFirst()
        .orElseThrow();

    var newAge = 100;

    // When age is changed
    Customer update = new Customer();
    update.setId(id);
    update.setAge(newAge);

    underTest.updateCustomer(update);

    // Then
    Optional<Customer> actual = underTest.selectCustomerById(id);

    assertThat(actual).isPresent().hasValueSatisfying(c -> {
      assertThat(c.getId()).isEqualTo(id);
      assertThat(c.getAge()).isEqualTo(newAge); // change
      assertThat(c.getName()).isEqualTo(customer.getName());
      assertThat(c.getEmail()).isEqualTo(customer.getEmail());
    });
  }

  @Test
  void willUpdateAllPropertiesCustomer() {
    // Given
    String email = FAKER.internet().safeEmailAddress() + "_" + UUID.randomUUID();
    Customer customer = new Customer(FAKER.name().fullName(), email, "password", 20,Gender.MALE );

    underTest.insertCustomer(customer);

    Customer customer1 = underTest.selectAllCustomers()
        .stream()
        .filter(c -> c.getEmail().equals(email))
        .findFirst()
        .orElseThrow();

    int id = underTest.selectAllCustomers()
        .stream()
        .filter(c -> c.getEmail().equals(email))
        .map(Customer::getId)
        .findFirst()
        .orElseThrow();

    // When update with new name, age and email
    Customer update = new Customer();
    update.setId(id);
    update.setName("foo");
    String newEmail = UUID.randomUUID().toString();
    update.setEmail(newEmail);
    update.setAge(22);
    update.setGender(Gender.MALE);

    underTest.updateCustomer(update);

    // Then
    Optional<Customer> actual = underTest.selectCustomerById(id);

    assertThat(actual).isPresent().hasValueSatisfying(updated -> {
      assertThat(updated.getId()).isEqualTo(id);
      assertThat(updated.getName()).isEqualTo("foo");
      assertThat(updated.getEmail()).isEqualTo(newEmail);
      assertThat(updated.getAge()).isEqualTo(22);
      assertThat(updated.getGender()).isEqualTo(Gender.MALE);
    });
  }

  @Test
  void willNotUpdateWhenNothingToUpdate() {
    // Given
    String email = FAKER.internet().safeEmailAddress() + "_" + UUID.randomUUID();
    Customer customer = new Customer(FAKER.name().fullName(), email, "password", 20,Gender.MALE );

    underTest.insertCustomer(customer);

    int id = underTest.selectAllCustomers()
        .stream()
        .filter(c -> c.getEmail().equals(email))
        .map(Customer::getId)
        .findFirst()
        .orElseThrow();

    // When update without no changes
    Customer update = new Customer();
    update.setId(id);

    underTest.updateCustomer(update);

    // Then
    Optional<Customer> actual = underTest.selectCustomerById(id);

    assertThat(actual).isPresent().hasValueSatisfying(c -> {
      assertThat(c.getId()).isEqualTo(id);
      assertThat(c.getAge()).isEqualTo(customer.getAge());
      assertThat(c.getName()).isEqualTo(customer.getName());
      assertThat(c.getEmail()).isEqualTo(customer.getEmail());
    });
  }

  @Test
  void canUpdateProfileImageId() {
    // Given
    String email = FAKER.internet().safeEmailAddress() + "-" + UUID.randomUUID();
    Customer customer = new Customer(
        FAKER.name().fullName(),
        email,
        "password", 20,
        Gender.MALE);

    underTest.insertCustomer(customer);

    int id = underTest.selectAllCustomers()
        .stream()
        .filter(c -> c.getEmail().equals(email))
        .map(Customer::getId)
        .findFirst()
        .orElseThrow();

    // When
    underTest.updateCustomerProfileImageId("2222", id);

    // Then
    Optional<Customer> customerOptional = underTest.selectCustomerById(id);
    assertThat(customerOptional)
        .isPresent()
        .hasValueSatisfying(
            c -> assertThat(c.getProfileImageId()).isEqualTo("2222")
        );
  }


}
```
- CustomerRepositoryTest
```java
package com.jd.customer;

import static org.assertj.core.api.Assertions.assertThat;

import com.jd.AbstractTestcontainers;
import com.jd.TestConfig;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({TestConfig.class})
class CustomerRepositoryTest extends AbstractTestcontainers {

  @Autowired
  private CustomerRepository underTest;

  @Autowired
  private ApplicationContext applicationContext;

  @BeforeEach
  void setUp() {
    underTest.deleteAll();
    System.out.println(applicationContext.getBeanDefinitionCount());
  }

  @Test
  void existsCustomerByEmail() {
    // Given
    String email = FAKER.internet().safeEmailAddress() + "-" + UUID.randomUUID();
    Customer customer = new Customer(
        FAKER.name().fullName(),
        email,
        "password",
        20,
        Gender.MALE);

    underTest.save(customer);

    // When
    var actual = underTest.existsCustomerByEmail(email);

    // Then
    assertThat(actual).isTrue();
  }

  @Test
  void existsCustomerByEmailFailsWhenEmailNotPresent() {
    // Given
    String email = FAKER.internet().safeEmailAddress() + "-" + UUID.randomUUID();

    // When
    var actual = underTest.existsCustomerByEmail(email);

    // Then
    assertThat(actual).isFalse();
  }

  @Test
  void existsCustomerById() {
    // Given
    String email = FAKER.internet().safeEmailAddress() + "-" + UUID.randomUUID();
    Customer customer = new Customer(
        FAKER.name().fullName(),
        email,
        "password", 20,
        Gender.MALE);

    underTest.save(customer);

    int id = underTest.findAll()
        .stream()
        .filter(c -> c.getEmail().equals(email))
        .map(Customer::getId)
        .findFirst()
        .orElseThrow();

    // When
    var actual = underTest.existsCustomerById(id);

    // Then
    assertThat(actual).isTrue();
  }

  @Test
  void existsCustomerByIdFailsWhenIdNotPresent() {
    // Given
    int id = -1;

    // When
    var actual = underTest.existsCustomerById(id);

    // Then
    assertThat(actual).isFalse();
  }

  @Test
  void canUpdateProfileImageId() {
    // Given
    String email = "email";

    Customer customer = new Customer(
        FAKER.name().fullName(),
        email,
        "password", 20,
        Gender.MALE);

    underTest.save(customer);

    int id = underTest.findAll()
        .stream()
        .filter(c -> c.getEmail().equals(email))
        .map(Customer::getId)
        .findFirst()
        .orElseThrow();

    // When
    underTest.updateProfileImageId("2222", id);

    // Then
    Optional<Customer> customerOptional = underTest.findById(id);
    assertThat(customerOptional)
        .isPresent()
        .hasValueSatisfying(
            c -> assertThat(c.getProfileImageId()).isEqualTo("2222")
        );
  }

}
```
---
## Mockito
 - We need to mock repository layer using Mockito
 - mock()/@Mock : We can mock an class or interface
 - @InjectMocks :  When we want to inject a mocker object into another mocked object , we can use @InjectMocks annoation.
                   @InejctMock created the mock object of the class and injects the mocks that are marked with the annotation @Mock
- Using mock() methos
```java
public class TodoBusinessImpl {
    private TodoService todoService;
    TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }
    public List<String> retrieveTodosRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<String>();
        List<String> allTodos = todoService.retrieveTodos(user);
        for (String todo : allTodos) {
            if (todo.contains("Spring")) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
}

public class TodoBusinessImplMockitoTest {
    @Test
    public void usingMockito() {
        TodoService todoService = mock(TodoService.class);
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Ranga");
        assertEquals(2, todos.size());
    }
}

```
		   
- Unsing @Mock Annotation
```java
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {

    @Mock
    EmployeeRepository employeeRepository;
    @InjectMocks
    EmployeeServiceImpl employeeService;
```
-- BDDMockito Style 
```java
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {
    @Mock
    EmployeeRepository employeeRepository;
    @InjectMocks
    EmployeeServiceImpl employeeService;
    private Employee e;
    private Employee employee1;
    @BeforeEach
    public void setup() {
        // employeeRepository = Mockito.mock(EmployeeRepository.class);
        //employeeService = new EmployeeServiceImpl(employeeRepository);
        e = Employee.builder().id(1L).firstName("Jitu").lastName("Birla").email("jdbirla@gmail.com").build();
        employee1 = Employee.builder().id(2L).firstName("Jitu").lastName("Birla").email("jitendra@gmail.com").build();

    }

    @Test
    @DisplayName("Test save employee using serviceimpl")
    public void givenEmployee_whenSaveEmployee_thenEmployeeObject() {
        //given
        BDDMockito.given(employeeRepository.findByEmail(e.getEmail())).willReturn(Optional.empty());
        BDDMockito.given(employeeService.saveEmployee(e)).willReturn(e);

        //When
        Employee savedEmp = employeeService.saveEmployee(e);
        System.out.println(savedEmp.toString());
        //Then
        Assertions.assertThat(savedEmp).isNotNull();
    }
}

```
- Unit Testing for DAO layer where CustomerRepository will be mocked
- CustomerJPADataAccessServiceTest
```java
package com.jd.customer;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by jd birla on 22-05-2023 at 09:08
 */
class CustomerJPADataAccessServiceTest {

  private CustomerJPADataAccessService underTest;
  private AutoCloseable autoCloseable;
  @Mock
  private CustomerRepository customerRepository;

  @BeforeEach
  void setUp() {
    autoCloseable = MockitoAnnotations.openMocks(this);
    underTest = new CustomerJPADataAccessService(customerRepository);
  }

  @AfterEach
  void tearDown() throws Exception {
    autoCloseable.close();
  }

  @Test
  void selectAllCustomers() {
    // When
    underTest.selectAllCustomers();

    // Then
    verify(customerRepository).findAll();
  }

  @Test
  void selectCustomerById() {
    // Given
    int id = 1;

    // When
    underTest.selectCustomerById(id);

    // Then
    verify(customerRepository).findById(id);
  }

  @Test
  void insertCustomer() {
    // Given
    Customer customer = new Customer(1, "Ali", "ali@gmail.com", "password", 2, Gender.MALE);

    // When
    underTest.insertCustomer(customer);

    // Then
    verify(customerRepository).save(customer);
  }

  @Test
  void existsCustomerWithEmail() {
    // Given
    String email = "foo@gmail.com";

    // When
    underTest.existsCustomerWithEmail(email);

    // Then
    verify(customerRepository).existsCustomerByEmail(email);
  }

  @Test
  void existsCustomerById() {
    // Given
    int id = 1;

    // When
    underTest.existsCustomerWithId(id);

    // Then
    verify(customerRepository).existsCustomerById(id);
  }

  @Test
  void deleteCustomerById() {
    // Given
    int id = 1;

    // When
    underTest.deleteCustomerById(id);

    // Then
    verify(customerRepository).deleteById(id);
  }

  @Test
  void updateCustomer() {
    // Given
    Customer customer = new Customer(1, "Ali", "ali@gmail.com", "password", 2,Gender.MALE);

    // When
    underTest.updateCustomer(customer);

    // Then
    verify(customerRepository).save(customer);
  }
  @Test
  void canUpdateProfileImageId() {
    // Given
    String profileImageId = "abebddf4-d52c-40f0-a74f-d2b1ecbd72a7";
    Integer customerId = 118;

    // When
    underTest.updateCustomerProfileImageId(profileImageId, customerId);

    // Then
    verify(customerRepository).updateProfileImageId(profileImageId, customerId);
  }
}
```
---
### Service Layer

```java
package com.jd.springboot.service;

import com.jd.springboot.exception.ResurceNotFound;
import com.jd.springboot.model.Employee;
import com.jd.springboot.repository.EmployeeRepository;
import com.jd.springboot.services.EmployeeService;
import com.jd.springboot.services.Impl.EmployeeServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;


/**
 * Created by jd birla on 24-11-2022 at 08:35
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {

    @Mock
    EmployeeRepository employeeRepository;
    @InjectMocks
    EmployeeServiceImpl employeeService;
    private Employee e;
    private Employee employee1;

    @BeforeEach
    public void setup() {
        // employeeRepository = Mockito.mock(EmployeeRepository.class);
        //employeeService = new EmployeeServiceImpl(employeeRepository);
        e = Employee.builder().id(1L).firstName("Jitu").lastName("Birla").email("jdbirla@gmail.com").build();
        employee1 = Employee.builder().id(2L).firstName("Jitu").lastName("Birla").email("jitendra@gmail.com").build();

    }

    @Test
    @DisplayName("Test save employee using serviceimpl")
    public void givenEmployee_whenSaveEmployee_thenEmployeeObject() {
        //given
        BDDMockito.given(employeeRepository.findByEmail(e.getEmail())).willReturn(Optional.empty());
        BDDMockito.given(employeeService.saveEmployee(e)).willReturn(e);

        //When
        Employee savedEmp = employeeService.saveEmployee(e);
        System.out.println(savedEmp.toString());
        //Then
        Assertions.assertThat(savedEmp).isNotNull();
    }

    @Test
    @DisplayName("Test by given existing email and returning resurce not found exception")
    public void givenExistingEmail_whenSaveEmployee_thenThrowRSNF() {
        //given
        BDDMockito.given(employeeRepository.findByEmail(e.getEmail())).willReturn(Optional.of(e));
        //BDDMockito.given(employeeService.saveEmployee(e)).willReturn(e);

        //When

        org.junit.jupiter.api.Assertions.assertThrows(ResurceNotFound.class, () -> {
            employeeService.saveEmployee(e);
        });

        //Then
        BDDMockito.verify(employeeRepository, Mockito.never()).save(any(Employee.class));

    }

    @Test
    @DisplayName("Test find all employees")
    public void givenEmployeeList_whenFindAll_thenReturningEmployeeList() {
        //given
        BDDMockito.given(employeeRepository.findAll()).willReturn(List.of(e, employee1));


        //When
        List<Employee> empList = employeeService.findAll();
        //Then
        Assertions.assertThat(empList).isNotNull();
        Assertions.assertThat(empList).size().isEqualTo(2);
    }


    @Test
    @DisplayName("Test update employee ")
    public void givenEmployee_whenUpdateEmployee_thenReturningEmployee() {
        //given
        BDDMockito.given(employeeRepository.save(e)).willReturn(e);
        e.setFirstName("shivam");
        e.setLastName("karode");
        //When
        Employee employee = employeeService.updateEmployee(e);
        //Then
        Assertions.assertThat(employee).isNotNull();
        Assertions.assertThat(employee.getFirstName()).isEqualTo("shivam");

    }

    @Test
    @DisplayName("Test delete employee ")
    public void givenEmployeeId_whenDeleteEmployee_thenReturningNOting() {
        long employeeid = 1L;
        //given
        BDDMockito.willDoNothing().given(employeeRepository).deleteById(employeeid);

        //When
         employeeService.deleteEmployee(employeeid);
        //Then
      BDDMockito.verify(employeeRepository,Mockito.times(1)).deleteById(employeeid);

    }

}

```
- Amigoscode 
- CustomerServiceTest
```java
package com.jd.customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

import com.jd.exception.DuplicateResourceException;
import com.jd.exception.RequestValidationException;
import com.jd.exception.ResourceNotFoundException;
import com.jd.s3.S3Buckets;
import com.jd.s3.S3Service;
import java.io.IOException;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by jd birla on 22-05-2023 at 13:24
 */
@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

  @Mock
  private CustomerDao customerDao;
  private CustomerService underTest;

  @Mock
  private PasswordEncoder passwordEncoder;
  @Mock
  private S3Service s3Service;
  @Mock
  private S3Buckets s3Buckets;

  private final CustomerDTOMapper customerDTOMapper = new CustomerDTOMapper();

  @BeforeEach
  void setUp() {
    underTest = new CustomerService(customerDao, passwordEncoder, customerDTOMapper, s3Service,
        s3Buckets);
  }

  @Test
  void getAllCustomers() {
    // When
    underTest.getAllCustomers();

    // Then
    verify(customerDao).selectAllCustomers();
  }

  @Test
  void canGetCustomer() {
    // Given
    int id = 10;
    Customer customer = new Customer(id, "Alex", "alex@gmail.com", "password", 19,Gender.MALE);
    when(customerDao.selectCustomerById(id)).thenReturn(Optional.of(customer));

    CustomerDTO expected = customerDTOMapper.apply(customer);

    // When
    CustomerDTO actual = underTest.getCustomer(id);

    // Then
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void willThrowWhenGetCustomerReturnEmptyOptional() {
    // Given
    int id = 10;

    when(customerDao.selectCustomerById(id)).thenReturn(Optional.empty());

    // When
    // Then
    assertThatThrownBy(() -> underTest.getCustomer(id)).isInstanceOf(
            ResourceNotFoundException.class)
        .hasMessage("customer with id [%s] not found".formatted(id));
  }

  @Test
  void addCustomer() {
    // Given
    String email = "alex@gmail.com";

    when(customerDao.existsCustomerWithEmail(email)).thenReturn(false);

    CustomerRegistrationRequest request = new CustomerRegistrationRequest("Alex", email, "password",
        19,Gender.MALE);

    String passwordHash = "$saf56wdssdasd";

    when(passwordEncoder.encode(request.password())).thenReturn(passwordHash);
    // When
    underTest.addCustomer(request);

    // Then
    ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);

    verify(customerDao).insertCustomer(customerArgumentCaptor.capture());

    Customer capturedCustomer = customerArgumentCaptor.getValue();

    assertThat(capturedCustomer.getId()).isNull();
    assertThat(capturedCustomer.getName()).isEqualTo(request.name());
    assertThat(capturedCustomer.getEmail()).isEqualTo(request.email());
    assertThat(capturedCustomer.getAge()).isEqualTo(request.age());
    assertThat(capturedCustomer.getPassword()).isEqualTo(passwordHash);

  }

  @Test
  void willThrowWhenEmailExistsWhileAddingACustomer() {
    // Given
    String email = "alex@gmail.com";

    when(customerDao.existsCustomerWithEmail(email)).thenReturn(true);

    CustomerRegistrationRequest request = new CustomerRegistrationRequest("Alex", email, "password",
        19,Gender.MALE);

    // When
    assertThatThrownBy(() -> underTest.addCustomer(request)).isInstanceOf(
        DuplicateResourceException.class).hasMessage("email already taken");

    // Then
    verify(customerDao, never()).insertCustomer(any());
  }

  @Test
  void deleteCustomerById() {
    // Given
    int id = 10;

    when(customerDao.existsCustomerWithId(id)).thenReturn(true);

    // When
    underTest.deleteCustomerById(id);

    // Then
    verify(customerDao).deleteCustomerById(id);
  }

  @Test
  void willThrowDeleteCustomerByIdNotExists() {
    // Given
    int id = 10;

    when(customerDao.existsCustomerWithId(id)).thenReturn(false);

    // When
    assertThatThrownBy(() -> underTest.deleteCustomerById(id)).isInstanceOf(
            ResourceNotFoundException.class)
        .hasMessage("customer with id [%s] not found".formatted(id));

    // Then
    verify(customerDao, never()).deleteCustomerById(id);
  }

  @Test
  void canUpdateAllCustomersProperties() {
    // Given
    int id = 10;
    Customer customer = new Customer(id, "Alex", "alex@gmail.com", "password", 19, Gender.MALE);
    when(customerDao.selectCustomerById(id)).thenReturn(Optional.of(customer));

    String newEmail = "alexandro@amigoscode.com";

    CustomerUpdateRequest updateRequest = new CustomerUpdateRequest("Alexandro", newEmail, 23,Gender.MALE);

    when(customerDao.existsCustomerWithEmail(newEmail)).thenReturn(false);

    // When
    underTest.updateCustomer(id, updateRequest);

    // Then
    ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);

    verify(customerDao).updateCustomer(customerArgumentCaptor.capture());
    Customer capturedCustomer = customerArgumentCaptor.getValue();

    assertThat(capturedCustomer.getName()).isEqualTo(updateRequest.name());
    assertThat(capturedCustomer.getEmail()).isEqualTo(updateRequest.email());
    assertThat(capturedCustomer.getAge()).isEqualTo(updateRequest.age());
  }

  @Test
  void canUpdateOnlyCustomerName() {
    // Given
    int id = 10;
    Customer customer = new Customer(id, "Alex", "alex@gmail.com", "password", 19,Gender.MALE);
    when(customerDao.selectCustomerById(id)).thenReturn(Optional.of(customer));

    CustomerUpdateRequest updateRequest = new CustomerUpdateRequest("Alexandro", null, null,null);

    // When
    underTest.updateCustomer(id, updateRequest);

    // Then
    ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);

    verify(customerDao).updateCustomer(customerArgumentCaptor.capture());
    Customer capturedCustomer = customerArgumentCaptor.getValue();

    assertThat(capturedCustomer.getName()).isEqualTo(updateRequest.name());
    assertThat(capturedCustomer.getAge()).isEqualTo(customer.getAge());
    assertThat(capturedCustomer.getEmail()).isEqualTo(customer.getEmail());
  }

  @Test
  void canUpdateOnlyCustomerEmail() {
    // Given
    int id = 10;
    Customer customer = new Customer(id, "Alex", "alex@gmail.com", "password", 19,Gender.MALE);
    when(customerDao.selectCustomerById(id)).thenReturn(Optional.of(customer));

    String newEmail = "alexandro@amigoscode.com";

    CustomerUpdateRequest updateRequest = new CustomerUpdateRequest(null, newEmail, null,null);

    when(customerDao.existsCustomerWithEmail(newEmail)).thenReturn(false);

    // When
    underTest.updateCustomer(id, updateRequest);

    // Then
    ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);

    verify(customerDao).updateCustomer(customerArgumentCaptor.capture());
    Customer capturedCustomer = customerArgumentCaptor.getValue();

    assertThat(capturedCustomer.getName()).isEqualTo(customer.getName());
    assertThat(capturedCustomer.getAge()).isEqualTo(customer.getAge());
    assertThat(capturedCustomer.getEmail()).isEqualTo(newEmail);
  }

  @Test
  void canUpdateOnlyCustomerAge() {
    // Given
    int id = 10;
    Customer customer = new Customer(id, "Alex", "alex@gmail.com", "password", 19, Gender.MALE);
    when(customerDao.selectCustomerById(id)).thenReturn(Optional.of(customer));

    CustomerUpdateRequest updateRequest = new CustomerUpdateRequest(null, null, 22,null);

    // When
    underTest.updateCustomer(id, updateRequest);

    // Then
    ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);

    verify(customerDao).updateCustomer(customerArgumentCaptor.capture());
    Customer capturedCustomer = customerArgumentCaptor.getValue();

    assertThat(capturedCustomer.getName()).isEqualTo(customer.getName());
    assertThat(capturedCustomer.getAge()).isEqualTo(updateRequest.age());
    assertThat(capturedCustomer.getEmail()).isEqualTo(customer.getEmail());
  }

  @Test
  void willThrowWhenTryingToUpdateCustomerEmailWhenAlreadyTaken() {
    // Given
    int id = 10;
    Customer customer = new Customer(id, "Alex", "alex@gmail.com", "password", 19, Gender.MALE);
    when(customerDao.selectCustomerById(id)).thenReturn(Optional.of(customer));

    String newEmail = "alexandro@amigoscode.com";

    CustomerUpdateRequest updateRequest = new CustomerUpdateRequest(null, newEmail, null,null);

    when(customerDao.existsCustomerWithEmail(newEmail)).thenReturn(true);

    // When
    assertThatThrownBy(() -> underTest.updateCustomer(id, updateRequest)).isInstanceOf(
        DuplicateResourceException.class).hasMessage("email already taken");

    // Then
    verify(customerDao, never()).updateCustomer(any());
  }

  @Test
  void willThrowWhenCustomerUpdateHasNoChanges() {
    // Given
    int id = 10;
    Customer customer = new Customer(id, "Alex", "alex@gmail.com", "password", 19, Gender.MALE);
    when(customerDao.selectCustomerById(id)).thenReturn(Optional.of(customer));

    CustomerUpdateRequest updateRequest = new CustomerUpdateRequest(customer.getName(),
        customer.getEmail(), customer.getAge(),customer.getGender());

    // When
    assertThatThrownBy(() -> underTest.updateCustomer(id, updateRequest)).isInstanceOf(
        RequestValidationException.class).hasMessage("no data changes found");

    // Then
    verify(customerDao, never()).updateCustomer(any());
  }

  @Test
  void canUploadProfileImage() {
    // Given
    int customerId = 10;

    when(customerDao.existsCustomerWithId(customerId)).thenReturn(true);

    byte[] bytes = "Hello World".getBytes();

    MultipartFile multipartFile = new MockMultipartFile("file", bytes);

    String bucket = "customer-bucket";
    when(s3Buckets.getCustomer()).thenReturn(bucket);

    // When
    underTest.uploadCustmerProfileImage(customerId, multipartFile);

    // Then
    ArgumentCaptor<String> profileImageIdArgumentCaptor = ArgumentCaptor.forClass(String.class);

    verify(customerDao).updateCustomerProfileImageId(profileImageIdArgumentCaptor.capture(), eq(customerId));

    verify(s3Service).putObject(bucket, "profile-images/%s/%s".formatted(customerId, profileImageIdArgumentCaptor.getValue()), bytes);
  }

  @Test
  void cannotUploadProfileImageWhenCustomerDoesNotExists() {
    // Given
    int customerId = 10;

    when(customerDao.existsCustomerWithId(customerId)).thenReturn(false);

    // When
    assertThatThrownBy(() -> underTest.uploadCustmerProfileImage(
        customerId, mock(MultipartFile.class))
    )
        .isInstanceOf(ResourceNotFoundException.class)
        .hasMessage("customer with id [" + customerId + "] not found");

    // Then
    verify(customerDao).existsCustomerWithId(customerId);
    verifyNoMoreInteractions(customerDao);
    verifyNoInteractions(s3Buckets);
    verifyNoInteractions(s3Service);
  }

  @Test
  void cannotUploadProfileImageWhenExceptionIsThrown() throws IOException {
    // Given
    int customerId = 10;

    when(customerDao.existsCustomerWithId(customerId)).thenReturn(true);

    MultipartFile multipartFile = mock(MultipartFile.class);
    when(multipartFile.getBytes()).thenThrow(IOException.class);

    String bucket = "customer-bucket";
    when(s3Buckets.getCustomer()).thenReturn(bucket);

    // When
    assertThatThrownBy(() -> {
      underTest.uploadCustmerProfileImage(customerId, multipartFile);
    }).isInstanceOf(RuntimeException.class)
        .hasMessage("failed to upload profile image")
        .hasRootCauseInstanceOf(IOException.class);

    // Then
    verify(customerDao, never()).updateCustomerProfileImageId(any(), any());
  }

  @Test
  void canDownloadProfileImage() {
    // Given
    int customerId = 10;
    String profileImageId = "2222";
    Customer customer = new Customer(
        customerId,
        "Alex",
        "alex@gmail.com",
        "password",
        19,
        Gender.MALE,
        profileImageId
    );
    when(customerDao.selectCustomerById(customerId)).thenReturn(Optional.of(customer));

    String bucket = "customer-bucket";
    when(s3Buckets.getCustomer()).thenReturn(bucket);

    byte[] expectedImage = "image".getBytes();

    when(s3Service.getObject(
        bucket,
        "profile-images/%s/%s".formatted(customerId, profileImageId))
    ).thenReturn(expectedImage);

    // When
    byte[] actualImage = underTest.getCustmerProfileImage(customerId);

    // Then
    assertThat(actualImage).isEqualTo(expectedImage);
  }

  @Test
  void cannotDownloadWhenNoProfileImageId() {
    // Given
    int customerId = 10;
    Customer customer = new Customer(
        customerId,
        "Alex",
        "alex@gmail.com",
        "password",
        19,
        Gender.MALE
    );

    when(customerDao.selectCustomerById(customerId)).thenReturn(Optional.of(customer));

    // When
    // Then
    assertThatThrownBy(() -> underTest.getCustmerProfileImage(customerId))
        .isInstanceOf(ResourceNotFoundException.class)
        .hasMessage("customer with id [%s] profile image not found".formatted(customerId));

    verifyNoInteractions(s3Buckets);
    verifyNoInteractions(s3Service);
  }

  @Test
  void cannotDownloadProfileImageWhenCustomerDoesNotExists() {
    // Given
    int customerId = 10;

    when(customerDao.selectCustomerById(customerId)).thenReturn(Optional.empty());

    // When
    // Then
    assertThatThrownBy(() -> underTest.getCustmerProfileImage(customerId))
        .isInstanceOf(ResourceNotFoundException.class)
        .hasMessage("customer with id [%s] not found".formatted(customerId));

    verifyNoInteractions(s3Buckets);
    verifyNoInteractions(s3Service);
  }
}
```
---
### Controller-Layer
- @WebMvcTest : It won't load service and repository , it just load specific controller and its dependency 
- We need to mock service layer

```java

package com.jd.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jd.springboot.model.Employee;
import com.jd.springboot.services.EmployeeService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by jd birla on 25-11-2022 at 06:50
 */
@WebMvcTest
public class EmployeeControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;


    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenEmployee_whenCreateEmployee_thenReturnEmployee() throws Exception {
        //given
        Employee employee = Employee.builder().firstName("Jitu").lastName("Birla").email("jitu@gmail.com").build();

        BDDMockito.given(employeeService.saveEmployee(ArgumentMatchers.any(Employee.class))).willAnswer((invocation -> invocation.getArgument(0)));

        //When
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/api/employees").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(employee)));

        //Then
        response.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isCreated()).andExpect(MockMvcResultMatchers.jsonPath("$.firstName", CoreMatchers.is(employee.getFirstName()))).andExpect(MockMvcResultMatchers.jsonPath("$.lastName", CoreMatchers.is(employee.getLastName()))).andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(employee.getEmail())));

    }

    @Test
    public void givenListOfEmployee_whenFindAllEmployees_thenReturnEmployeeList() throws Exception {
        //given
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(Employee.builder().firstName("Jitu").lastName("Birla").email("jitu@gmail.com").build());
        employeeList.add(Employee.builder().firstName("Jitu1").lastName("Birla1").email("jitu1@gmail.com").build());

        BDDMockito.given(employeeService.findAll()).willReturn(employeeList);

        //When
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/employees"));

        //Then
        response.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(employeeList.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName", CoreMatchers.is("Jitu")));


    }

    //Positive scenario
    @Test
    public void givenEmployeeId_whenFindById_thenReturnEmployee() throws Exception {
        //given
        long empid = 1L;
        Employee employee = Employee.builder().id(1L).firstName("Jitu").lastName("Birla").email("jitu@gmail.com").build();

        BDDMockito.given(employeeService.getEmployeeById(empid)).willReturn(Optional.of(employee));

        //When
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/employees/{id}", empid));

        //Then
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", CoreMatchers.is(employee.getFirstName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", CoreMatchers.is(employee.getLastName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(employee.getEmail())));


    }

    //Negative scenario
    @Test
    public void givenEmployeeId_whenFindById_thenReturnNotFound() throws Exception {
        //given
        long empid = 1L;
        Employee employee = Employee.builder().id(1L).firstName("Jitu").lastName("Birla").email("jitu@gmail.com").build();

        BDDMockito.given(employeeService.getEmployeeById(empid)).willReturn(Optional.empty());

        //When
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/employees/{id}", empid));

        //Then
        response.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isNotFound());

    }

    //Positive scenario
    @Test
    public void givenEmployeeIdAndEmployee_whenUpdate_thenReturnUpdatedEmployee() throws Exception {
        //given
        long empid = 1L;
        Employee savedEmployee = Employee.builder().id(1L).firstName("Jitu").lastName("Birla").email("jitu@gmail.com").build();
        Employee updatedEmployee = Employee.builder().id(1L).firstName("Jitu1").lastName("Birla1").email("jitu1@gmail.com").build();

        BDDMockito.given(employeeService.getEmployeeById(empid)).willReturn(Optional.of(savedEmployee));
        BDDMockito.given(employeeService.updateEmployee(ArgumentMatchers.any(Employee.class))).willAnswer((invocation -> invocation.getArgument(0)));

        //When
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.put("/api/employees/{id}", empid)
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(updatedEmployee)));


        //Then
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", CoreMatchers.is(updatedEmployee.getFirstName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", CoreMatchers.is(updatedEmployee.getLastName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(updatedEmployee.getEmail())));

    }

    //Ngative scenario
    @Test
    public void givenEmployeeIdAndEmployee_whenUpdate_thenReturnNotFound() throws Exception {
        //given
        long empid = 1L;
        Employee savedEmployee = Employee.builder().id(1L).firstName("Jitu").lastName("Birla").email("jitu@gmail.com").build();
        Employee updatedEmployee = Employee.builder().id(1L).firstName("Jitu1").lastName("Birla1").email("jitu1@gmail.com").build();

        BDDMockito.given(employeeService.getEmployeeById(empid)).willReturn(Optional.empty());
        BDDMockito.given(employeeService.updateEmployee(ArgumentMatchers.any(Employee.class))).willAnswer((invocation -> invocation.getArgument(0)));

        //When
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.put("/api/employees/{id}", empid)
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(updatedEmployee)));


        //Then
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());


    }


    @Test
    public void givenEmployeeId_whenDeleteEmployee_thenReturn200() throws Exception {
        //given
        long empid = 1L;
        Employee employee = Employee.builder().id(1L).firstName("Jitu").lastName("Birla").email("jitu@gmail.com").build();

        BDDMockito.willDoNothing().given(employeeService).deleteEmployee(empid);

        //When
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.delete("/api/employees/{id}", empid));

        //Then
        response.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());

    }

}

```
---

## Integration Testing
   - @springBootTest : It start the embedded server, creates a web env and then enables @test methods to do integration testing.
   ![image](https://user-images.githubusercontent.com/69948118/217783311-60461844-7400-455a-8dd0-13b1fbebcca7.png)
   
```java

package com.jd.springboot.intergration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jd.springboot.model.Employee;
import com.jd.springboot.repository.EmployeeRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by jd birla on 26-11-2022 at 08:31
 */
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerITests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        employeeRepository.deleteAll();
    }

    @Test
    public void givenEmployee_whenCreateEmployee_thenReturnEmployee() throws Exception {
        //given
        Employee employee = Employee.builder().firstName("Jitu").lastName("Birla").email("jitu@gmail.com").build();

        //When
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(employee)));

        //Then
        response.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", CoreMatchers.is(employee.getFirstName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", CoreMatchers.is(employee.getLastName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(employee.getEmail())));

    }

    @Test
    public void givenListOfEmployee_whenFindAllEmployees_thenReturnEmployeeList() throws Exception {
        //given
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(Employee.builder().firstName("Jitu").lastName("Birla").email("jitu@gmail.com").build());
        employeeList.add(Employee.builder().firstName("Jitu1").lastName("Birla1").email("jitu1@gmail.com").build());

        employeeRepository.saveAll(employeeList);
        //When
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/employees"));

        //Then
        response.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(employeeList.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName", CoreMatchers.is("Jitu")));


    }

    //Positive scenario
    @Test
    public void givenEmployeeId_whenFindById_thenReturnEmployee() throws Exception {
        //given
        Employee employee = Employee.builder().firstName("Jitu").lastName("Birla").email("jitu@gmail.com").build();

        employeeRepository.save(employee);

        //When
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/employees/{id}", employee.getId()));

        //Then
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", CoreMatchers.is(employee.getFirstName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", CoreMatchers.is(employee.getLastName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(employee.getEmail())));


    }

    //Negative scenario
    @Test
    public void givenEmployeeId_whenFindById_thenReturnNotFound() throws Exception {
        //given
        long empid = 1L;
        Employee employee = Employee.builder().firstName("Jitu").lastName("Birla").email("jitu@gmail.com").build();
        employeeRepository.save(employee);

        //When
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/employees/{id}", empid));

        //Then
        response.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isNotFound());

    }

    //Positive scenario
    @Test
    public void givenEmployeeIdAndEmployee_whenUpdate_thenReturnUpdatedEmployee() throws Exception {
        //given

        Employee savedEmployee = Employee.builder().firstName("Jitu").lastName("Birla").email("jitu@gmail.com").build();
        Employee updatedEmployee = Employee.builder().firstName("Jitu1").lastName("Birla1").email("jitu1@gmail.com").build();
        employeeRepository.save(savedEmployee);

        //When
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.put("/api/employees/{id}", savedEmployee.getId())
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(updatedEmployee)));


        //Then
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", CoreMatchers.is(updatedEmployee.getFirstName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", CoreMatchers.is(updatedEmployee.getLastName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(updatedEmployee.getEmail())));

    }

    //Ngative scenario
    @Test
    public void givenEmployeeIdAndEmployee_whenUpdate_thenReturnNotFound() throws Exception {
        //given
        long empid = 1L;
        Employee savedEmployee = Employee.builder().firstName("Jitu").lastName("Birla").email("jitu@gmail.com").build();
        Employee updatedEmployee = Employee.builder().firstName("Jitu1").lastName("Birla1").email("jitu1@gmail.com").build();

        employeeRepository.save(savedEmployee);

        //When
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.put("/api/employees/{id}", empid)
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(updatedEmployee)));


        //Then
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());


    }


    @Test
    public void givenEmployeeId_whenDeleteEmployee_thenReturn200() throws Exception {
        //given

        Employee employee = Employee.builder().firstName("Jitu").lastName("Birla").email("jitu@gmail.com").build();

        employeeRepository.save(employee);

        //When
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.delete("/api/employees/{id}", employee.getId()));

        //Then
        response.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());

    }


}
```
---
## Test Container
- https://www.testcontainers.org/
- add maven depnedency 
```xml
<dependency>
			<groupId>org.testcontainers</groupId>
			<artifactId>testcontainers</artifactId>
			<version>1.17.6</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.testcontainers</groupId>
			<artifactId>junit-jupiter</artifactId>
			<version>1.17.6</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.testcontainers</groupId>
			<artifactId>mysql</artifactId>
			<version>1.17.6</version>
			<scope>test</scope>
		</dependency>
```
- Default mysql container properties
```
#DB username  -> test
#DB pass  ->test
#DB dbname  -> test
#DB url    -> jdbc:mysql://localhost:9332/test
```
- Singleton container
```jav
package com.jd.springboot.intergration;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

/**
 * Created by jd birla on 27-11-2022 at 06:56
 */
public abstract class AbstractionBaseTest {

    static final MySQLContainer MY_SQL_CONTAINER;
    static {
        MY_SQL_CONTAINER = new MySQLContainer("mysql:latest").withDatabaseName("empdb").withUsername("empuser").withPassword("emppass");
        MY_SQL_CONTAINER.start();
    }

//this one for add daynamic properties into application context from container
    @DynamicPropertySource
    public static void dynamicPropertySource(DynamicPropertyRegistry dynamicPropertyRegistry)
    {
        dynamicPropertyRegistry.add("spring.datasource.url",MY_SQL_CONTAINER::getJdbcUrl);
        dynamicPropertyRegistry.add("spring.datasource.username",MY_SQL_CONTAINER::getUsername);
        dynamicPropertyRegistry.add("spring.datasource.password",MY_SQL_CONTAINER::getPassword);

    }
}

```
- we need to just exten singleton abract class other test method coded will be same like integration test
```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EmployeeControllerITTestContainer extends AbstractionBaseTest{

```
- for Repository integration test we can also use testcontainer 
```java
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryITTestContainer extends AbstractionBaseTest {
```
---
## all asserstions
```java
Assertions.assertThat(employee).isNotNull();
Assertions.assertThat(employee.getId()).isNotNull();
Assertions.assertThat(employee.getId()).isGreaterThan(0);
Assertions.assertThat(empList).isNotEmpty();
Assertions.assertThat(empList).isNotNull();
Assertions.assertThat(empList).size().isEqualTo(2);
Assertions.assertThat(emp).isNotNull();
Assertions.assertThat(emp).isEqualTo(employee);
----
org.junit.jupiter.api.Assertions.assertThrows(ResurceNotFound.class, () -> {
            employeeService.saveEmployee(e);
        });
 //Then
 BDDMockito.verify(employeeRepository, Mockito.never()).save(any(Employee.class));
----
    long employeeid = 1L;
        //given
        BDDMockito.willDoNothing().given(employeeRepository).deleteById(employeeid);

        //When
         employeeService.deleteEmployee(employeeid);
        //Then
      BDDMockito.verify(employeeRepository,Mockito.times(1)).deleteById(employeeid);
---
```

---

# Old Test sheet
##  Junit vs Mockito vs Spring Junit vs Spring Mockito vs Spring Boot junit and Spring Boot Mockito
|#  |Junit|Mockito |Spring Junit|Spring Mockito|Spring Boot junit|Spring Boot Mockito |
|--- |---|--- |---|---|---|--- |
|dependency|Not Required  |junit and mockito-all    |spring-test and mockito-core			|spring-test and mockito-core           |spring-boot-starter	     |spring-boot-starter				  |
|code|```@Test 	public void test() { 		boolean condn = true; 		assertEquals(true, condn); 		assertTrue(condn); 		// assertFalse(condn); 	}```  |```@Test 	public void usingMockito() { 		TodoService todoService = mock(TodoService.class); 		List<String> allTodos = Arrays.asList("Learn Spring MVC", 				"Learn Spring", "Learn to Dance"); 		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos); 		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService); 		List<String> todos = todoBusinessImpl 				.retrieveTodosRelatedToSpring("Ranga"); 		assertEquals(2, todos.size()); 	}```     |```@RunWith(SpringRunner.class)/@RunWith(SpringJUnit4ClassRunner.class) public class SpringIn5StepsBasicApplicationTests {  	@Test 	public void contextLoads() { 	}  }  @RunWith(SpringRunner.class) @ContextConfiguration(classes = SpringIn5StepsBasicApplication.class) public class BinarySearchTest {  	// Get this bean from the context 	@Autowired 	BinarySearchImpl binarySearch; ```			|```@RunWith(MockitoJUnitRunner.class) public class SomeCdiBusinessTest {  	// Inject Mock 	@InjectMocks 	SomeCdiBusiness business;  	// Create Mock 	@Mock 	SomeCdiDao daoMock;  	@Test 	public void testBasicScenario() { 		Mockito.when(daoMock.getData()).thenReturn(new int[] { 2, 4 }); 		assertEquals(4, business.findGreatest()); 	}	```          |```@Test```			     |```@RunWith(SpringRunner.class) @SpringBootTest public class MockitoDemoApplicationTests {  	@Test 	public void contextLoads() { 	}  } @RunWith(MockitoJUnitRunner.class) public class SomeBusinessMockAnnotationsTest {  	@Mock 	DataService dataServiceMock;  	@InjectMocks 	SomeBusinessImpl businessImpl;  	@Test 	public void testFindTheGreatestFromAllData() { 		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 24, 15, 3 }); 		assertEquals(24, businessImpl.findTheGreatestFromAllData()); 	}```				  |

# Junit 
src  : - https://courses.in28minutes.com/courses/enrolled/257253

### First 5 Steps in JUnit

- Git Repository - https://github.com/in28minutes/getting-started-in-5-steps


### Step 1 : What is JUnit and Unit Testing?
 - What is JUnit?
 - What is Unit Testing?
 - Advantages of Unit Testing

### Step 2 : First JUnit Project and Green Bar
 - What is JUnit?
 - First Project with JUnit
 - First JUnit Class
 - No Failure is Success
 - MyMath class with sum method

### Step 3 : First Code and First Unit Test
 - Unit test for the sum method

### Step 4 : Other assert methods
 - assertTrue and assertFalse methods

### Step 5 : Important annotations
  - @Before @After annotations
  - @BeforeClass @AfterClass annotations

### Complete Code Example


### /src/com/in28minutes/junit/MyMath.java

```java
package com.in28minutes.junit;
public class MyMath {
	int sum(int[] numbers) {
		int sum = 0;
		for (int i : numbers) {
			sum += i;
		}
		return sum;
	}
}
```
---

### /test/com/in28minutes/junit/AssertTest.java

```java
package com.in28minutes.junit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
public class AssertTest {
	@Test
	public void test() {
		boolean condn = true;
		assertEquals(true, condn);
		assertTrue(condn);
		// assertFalse(condn);
	}
}
```
---

### /test/com/in28minutes/junit/MyMathTest.java

```java
package com.in28minutes.junit;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class MyMathTest {
	MyMath myMath = new MyMath();
	@Before
	public void before() {
		System.out.println("Before");
	}
	@After
	public void after() {
		System.out.println("After");
	}
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}
	// MyMath.sum
	// 1,2,3 => 6
	@Test
	public void sum_with3numbers() {
		System.out.println("Test1");
		assertEquals(6, myMath.sum(new int[] { 1, 2, 3 }));
	}
	@Test
	public void sum_with1number() {
		System.out.println("Test2");
		assertEquals(3, myMath.sum(new int[] { 3 }));
	}
}
```
---

# Mockito 
src  : - https://www.youtube.com/watch?v=d2KwvXQgQx4
- Git Repository - https://github.com/in28minutes/MockitoTutorialForBeginners
- JD/MockitoTutorialForBeginners-master

### Step 1 : What You Will Learn during this Step:
- Set up an Eclipse Project.
- Set up JUnit and Mockito frameworks.
- First Green Bar

### pom.xml
```
<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.mockito</groupId>
			<artifactId>mockito-all</artifactId>
			<version>1.10.19</version>
			<scope>test</scope>
		</dependency>
		
```
---
### Step 2 : What You Will Learn during this Step:

- Start Creating an example to start understanding why we need mocks.
- We want to interact with a Todo Management application.
- We want to provide a filtering around Spring related Todo's

### /src/main/java/com/in28minutes/business/TodoBusinessImpl.java
```
package com.in28minutes.business;
import java.util.ArrayList;
import java.util.List;
import com.in28minutes.data.api.TodoService;
public class TodoBusinessImpl {
	private TodoService todoService;
	TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}
	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
}
```

### /src/main/java/com/in28minutes/data/api/TodoService.java
```
package com.in28minutes.data.api;
import java.util.List;
// External Service - Lets say this comes from WunderList
public interface TodoService {
	public List<String> retrieveTodos(String user);
}
```
---

## Step : 03 What You Will Learn during this Step
- What is a stub?
- Create an unit test using Stub?
- Disadvantages of Stubs

---
##  Step : 04 What You Will Learn during this Step:
- Your first Mockito code! Hurrah!!!
- Lets use Mockito to mock TodoService
- Visit Mockito Official Documentation - [Mockito Documentation] (http://site.mockito.org/mockito/docs/current/org/mockito/Mockito.html)


### Useful Snippets and References
Easier Static Imports
```
Window > Preferences > Java > Editor > Content Assist > Favorites
org.junit.Assert
org.mockito.BDDMockito
org.mockito.Mockito
org.hamcrest.Matchers
org.hamcrest.CoreMatchers
```

### /src/test/java/com/in28minutes/mockito/FirstMockitoTest.java
```
package com.in28minutes.mockito;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
public class FirstMockitoTest {
	@Test
	public void test() {
		assertTrue(true);
	}
}
```

### /src/test/java/com/in28minutes/business/TodoBusinessImplMockitoTest.java
```
package com.in28minutes.business;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import com.in28minutes.data.api.TodoService;
public class TodoBusinessImplMockitoTest {
	@Test
	public void usingMockito() {
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(2, todos.size());
	}
}
```
---
### Step 05 : What You Will Learn during this Step:
- A few mockito examples mocking List class
- Multiple return values
- Introduction to Argument Matchers
- stub method
- Throwing exceptions


---
# Spring Unit Testing and Mockito

## Spring Unit Testing : with JUnit And Mockito

- src : https://www.udemy.com/course/spring-tutorial-for-beginners/learn/lecture/7725784#overview
- git: jd/SpringJunitMockito

https://github.com/in28minutes/spring-master-class/tree/master/01-spring-in-depth
Step 27 - Spring Unit Testing with a Java Context
Step 28 - Spring Unit Testing with an XML Context
Step 29 - Spring Unit Testing with Mockito



### Pom.xml
```
	<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
		</dependency>

		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-api</artifactId>
		</dependency>

		<dependency>
			<groupId>ch.qos.logback</groupId>
			<artifactId>logback-classic</artifactId>
		</dependency>

		<dependency>
			<groupId>javax.inject</groupId>
			<artifactId>javax.inject</artifactId>
			<version>1</version>
		</dependency>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.mockito</groupId>
			<artifactId>mockito-core</artifactId>
			<scope>test</scope>
		</dependency>

```

### Spring Junit
```
package com.in28minutes.spring.basics.springin5steps.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.spring.basics.springin5steps.SpringIn5StepsBasicApplication;

//Load the context
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringIn5StepsBasicApplication.class)
public class BinarySearchTest {

	// Get this bean from the context
	@Autowired
	BinarySearchImpl binarySearch;

	@Test
	public void testBasicScenario() {
		
		// call method on binarySearch
		int actualResult = binarySearch.binarySearch(new int[] {}, 5);

		// check if the value is correct
		assertEquals(3, actualResult);

	}

}

```
### Spring Mockito

```
package com.in28minutes.spring.basics.springin5steps.cdi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeCdiBusinessTest {

	// Inject Mock
	@InjectMocks
	SomeCdiBusiness business;

	// Create Mock
	@Mock
	SomeCdiDao daoMock;

	@Test
	public void testBasicScenario() {
		Mockito.when(daoMock.getData()).thenReturn(new int[] { 2, 4 });
		assertEquals(4, business.findGreatest());
	}

	@Test
	public void testBasicScenario_NoElements() {
		Mockito.when(daoMock.getData()).thenReturn(new int[] { });
		assertEquals(Integer.MIN_VALUE, business.findGreatest());
	}

	@Test
	public void testBasicScenario_EqualElements() {
		Mockito.when(daoMock.getData()).thenReturn(new int[] { 2,2});
		assertEquals(2, business.findGreatest());
	}

}

```



### Another example
```
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.in28minutes.example.layering.business.api.TodoBusinessService;
import com.in28minutes.example.layering.model.api.client.Todo;

@Configuration
@ComponentScan(basePackages = {
		"com.in28minutes.example.layering.business.impl",
		"com.in28minutes.example.layering.data.stub" })
class SpringTestContext {
}

// 1. We need to test using Spring
// 2. How do we tell Spring to use specific Configuration
// 3. How do autowire the TodoBusinessService
// 4. How do we auto wire TodoDataServiceStub
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(classes = SpringTestContext.class)
public class TodoBusinessServiceJavaStubTest {

	@Autowired
	TodoBusinessService businessService;

	@Test
	public void testGetTodosAboutSpring() {
		List<Todo> todos = businessService
				.retrieveTodosRelatedToSpring("Ranga");
		System.out.println(todos);
		assertEquals(2, todos.size());
	}
}
```

```
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.stub;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.in28minutes.example.layering.business.impl.TodoBusinessServiceImpl;
import com.in28minutes.example.layering.data.api.TodoDataService;
import com.in28minutes.example.layering.model.api.client.Todo;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessServiceMockitoTest {

	@Mock
	private TodoDataService todoDs;

	@InjectMocks
	private TodoBusinessServiceImpl todoBs;

	@Before
	public void initializeMockito() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRetrieveTodosRelatedToSpring() {

		List<Todo> todos = Arrays.asList(new Todo(
				"Mockito - Complete Spring Tutorial", new Date(), false),
				new Todo("Mockito - Complete Spring MVC Tutorial", new Date(),
						false), new Todo("Mockito - Complete All Tutorials",
								new Date(), false));

		stub(todoDs.retrieveTodos(anyString())).toReturn(todos);

		List<Todo> filteredTodos = todoBs
				.retrieveTodosRelatedToSpring("dummyUser");

		assertEquals(2, filteredTodos.size());
	}
}
```


---

# Spring boot Unit Testing and Mockito

https://github.com/in28minutes/SpringBootForBeginners

Step 24: Writing Unit Tests with Spring Boot and Mockito
Step 25: Writing Unit test for createTodo

src : - https://courses.in28minutes.com/courses/enrolled/257149

## First 5 Steps in Mockito

Mockito is the most famous mocking framework in Java.

- Git Repository - https://github.com/in28minutes/getting-started-in-5-steps
- Pre-requisites 
    - Java & Eclipse - https://www.youtube.com/playlist?list=PLBBog2r6uMCSmMVTW_QmDLyASBvovyAO3
    - JUnit - https://courses.in28minutes.com/p/junit-tutorial-for-beginners
- Easier Static Imports
  - Window > Preferences > Java > Editor > Content Assist > Favorites
    - org.junit.Assert
    - org.mockito.BDDMockito
    - org.mockito.Mockito
    - org.hamcrest.Matchers
    - org.hamcrest.CoreMatchers
- More information 
   - Visit Mockito Official Documentation - [Mockito Documentation] (http://site.mockito.org/mockito/docs/current/org/mockito/Mockito.html)

- Step 1 : Setting up an example using http://start.spring.io.
- Step 2 : Using a Stubs - Disadvantages
- Step 3 : Your first mock. 
- Step 4 : Using Mockito Annotations - @Mock, @InjectMocks, @RunWith(MockitoJUnitRunner.class)
- Step 5 : Mocking List interface
- Next Steps

## Complete Code Example


### /pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.in28minutes.mockito</groupId>
	<artifactId>mockito-demo</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>mockito-demo</name>
	<description>Demo project for Spring Boot</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.0.BUILD-SNAPSHOT</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

	<repositories>
		<repository>
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</repository>
		<repository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</repository>
	</repositories>

	<pluginRepositories>
		<pluginRepository>
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</pluginRepository>
		<pluginRepository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</pluginRepository>
	</pluginRepositories>


</project>
```
---

### /src/main/java/com/in28minutes/mockito/mockitodemo/DataService.java

```java
package com.in28minutes.mockito.mockitodemo;
public interface DataService {
	int[] retrieveAllData();
}
```
---

### /src/main/java/com/in28minutes/mockito/mockitodemo/MockitoDemoApplication.java

```java
package com.in28minutes.mockito.mockitodemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class MockitoDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(MockitoDemoApplication.class, args);
	}
}
```
---

### /src/main/java/com/in28minutes/mockito/mockitodemo/SomeBusinessImpl.java

```java
package com.in28minutes.mockito.mockitodemo;
public class SomeBusinessImpl {
	private DataService dataService;
	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}
	int findTheGreatestFromAllData() {
		int[] data = dataService.retrieveAllData();
		int greatest = Integer.MIN_VALUE;
		for (int value : data) {
			if (value > greatest) {
				greatest = value;
			}
		}
		return greatest;
	}
}
```
---

### /src/main/resources/application.properties

```properties
```
---

### /src/test/java/com/in28minutes/mockito/mockitodemo/ListTest.java

```java
package com.in28minutes.mockito.mockitodemo;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
public class ListTest {
	@Test
	public void testSize() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(10);
		assertEquals(10, listMock.size());
		assertEquals(10, listMock.size());
	}
	@Test
	public void testSize_multipleReturns() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(10).thenReturn(20);
		assertEquals(10, listMock.size());
		assertEquals(20, listMock.size());
		assertEquals(20, listMock.size());
	}
	@Test
	public void testGet_SpecificParameter() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("SomeString");
		assertEquals("SomeString", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}
	@Test
	public void testGet_GenericParameter() {
		List listMock = mock(List.class);
		when(listMock.get(Mockito.anyInt())).thenReturn("SomeString");
		assertEquals("SomeString", listMock.get(0));
		assertEquals("SomeString", listMock.get(1));
	}
}
```
---

### /src/test/java/com/in28minutes/mockito/mockitodemo/MockitoDemoApplicationTests.java

```java
package com.in28minutes.mockito.mockitodemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MockitoDemoApplicationTests {
	@Test
	public void contextLoads() {
	}
}
```
---

### /src/test/java/com/in28minutes/mockito/mockitodemo/SomeBusinessMockAnnotationsTest.java

```java
package com.in28minutes.mockito.mockitodemo;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockAnnotationsTest {
	@Mock
	DataService dataServiceMock;
	@InjectMocks
	SomeBusinessImpl businessImpl;
	@Test
	public void testFindTheGreatestFromAllData() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 24, 15, 3 });
		assertEquals(24, businessImpl.findTheGreatestFromAllData());
	}
	@Test
	public void testFindTheGreatestFromAllData_ForOneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 15 });
		assertEquals(15, businessImpl.findTheGreatestFromAllData());
	}
	@Test
	public void testFindTheGreatestFromAllData_NoValues() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
	}
}
```
---

### /src/test/java/com/in28minutes/mockito/mockitodemo/SomeBusinessMockTest.java

```java
package com.in28minutes.mockito.mockitodemo;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;
public class SomeBusinessMockTest {
	@Test
	public void testFindTheGreatestFromAllData() {
		DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 24, 15, 3 });
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(24, result);
	}
	@Test
	public void testFindTheGreatestFromAllData_ForOneValue() {
		DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 15 });
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(15, result);
	}
}
```
---

### /src/test/java/com/in28minutes/mockito/mockitodemo/SomeBusinessStubTest.java

```java
package com.in28minutes.mockito.mockitodemo;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class SomeBusinessStubTest {
	@Test
	public void testFindTheGreatestFromAllData() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(new DataServiceStub());
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(24, result);
	}
}
class DataServiceStub implements DataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] { 24, 6, 15 };
	}
}
```
---
