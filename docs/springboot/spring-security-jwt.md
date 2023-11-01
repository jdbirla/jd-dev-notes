# spring-security-jwt

## This is implemented based on spring boot 3.0.0 and Spring security 6
- <https://medium.com/@truongbui95/jwt-authentication-and-authorization-with-spring-boot-3-and-spring-security-6-2f90f9337421>
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/a5d3c9e4-665d-419a-8983-fcea6e90cf7c)
## Application Architecture
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/a42bf020-29d2-41e1-abcc-43e26d27d600)
- User makes a request to the service, seeking to create an account.
- A user submits a request to the service to authenticate their account.
- An authenticated user sends a request to access resources.
### Sign Up
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/371e68a7-3d45-45e8-9898-d633c04e209d)
- The Sign-up process is made very simple. One notable component is the JwtService, a custom service utilized for handling JWT operations. Further implementation details can be found in the coding section below.

   1. The process starts when a user submits a request to the service. A user object is then generated from the request data, with the password being encoded using the PasswordEncoder.
   2. The user object is stored in the database using the UserRepository, which leverages Spring Data JPA.
   3. The JwtService is invoked to generate a JWT for the User object.
   4. The JWT is encapsulated within a JSON response and subsequently returned to the user.

### Sign In
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/db988259-e7f0-42ef-86bc-a7826470130b)

   1. The process begins when a user sends a sign-in request to the Service. An Authentication object called UsernamePasswordAuthenticationToken is then generated, using the provided username and password.
   2. The AuthenticationManager is responsible for authenticating the Authentication object, handling all necessary tasks. If the username or password is incorrect, an exception is thrown, and a response with HTTP Status 403 is returned to the user.
   3. After successful authentication, an attempt is made to retrieve the user from the database. If the user does not exist in the database, a response with HTTP Status 403 is sent to the user. However, since we have already passed step 2 (authentication), this step 
       is not crucial, as the user should already be in the database.
   4. Once we have the user information, we call the JwtService to generate the JWT.
   5. The JWT is then encapsulated in a JSON response and returned to the user.
      
>Two new concepts are introduced in this process, and I’ll provide a brief explanation for each.
- 1. **UsernamePasswordAuthenticationToken**: A type of Authentication object which can be created from a username and password that are submitted.
- 2. **AuthenticationManager**: Processes authentication object and will do all authentication jobs for us.

### Resources Access
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/06a88be3-0480-4d10-a2fa-6398fa119d5d)
   1. The process starts when the user sends a request to the Service. The request is first intercepted by JwtAuthenticationFilter, which is a custom filter integrated into the SecurityFilterChain.
   2. As the API is secured, if the JWT is missing, a response with HTTP Status 403 is sent to the user.
   3. When an existing JWT is received, JwtService is called to extract the userEmail from the JWT. If the userEmail cannot be extracted, a response with HTTP Status 403 is sent to the user.
   4. If the userEmail can be extracted, it will be used to query the user’s authentication and authorization information via UserDetailsService.
   5. If the user’s authentication and authorization information does not exist in the database, a response with HTTP Status 403 is sent to the user.
   6. If the JWT is expired, a response with HTTP Status 403 is sent to the user.
   7. Upon successful authentication, the user’s details are encapsulated in a UsernamePasswordAuthenticationToken object and stored in the SecurityContextHolder.
   8. The Spring Security Authorization process is automatically invoked.
   9. The request is dispatched to the controller, and a successful JSON response is returned to the user.
       
>This process is a little more tricky, it involves some new concepts. Let’s dive into them in more detail:

- 1. **SecurityFilterChain**: a filter chain which is capable of being matched against an HttpServletRequest. in order to decide whether it applies to that request.
- 2. **SecurityContextHolder**: is where Spring Security stores the details of who is authenticated. Spring Security uses that information for authorization.
- 3. **UserDetailsService**: Service to fetch user-specific data.
- 4. **Authorization Architecture**

## Code Components
### Database configuration
- DB configuration in yml or properties files
### User Entity
- Customer or user
```java
package com.jd.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by jd birla on 20-05-2023 at 16:37
 */
@Entity
@Table(
    name = "customer",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "customer_email_unique",
            columnNames = "email"
        ),
        @UniqueConstraint(
            name = "unique_profile_image_id",
            columnNames = "profileImageId"
        )
    }
)
public class Customer implements UserDetails {

  @Id
  @SequenceGenerator(
      name = "customer_id_seq",
      sequenceName = "customer_id_seq",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "customer_id_seq"
  )
  private Integer id;
  @Column(
      nullable = false
  )
  private String name;
  @Column(
      nullable = false
  )
  private String email;
  @Column(
      nullable = false
  )
  private Integer age;

  @Column(
      nullable = false
  )
  @Enumerated(EnumType.STRING)
  private Gender gender;
  @Column(
      nullable = false
  )
  private String password;

  @Column(
      unique = true
  )
  private String profileImageId;

  public Customer() {
  }

  public Customer(Integer id, String name, String email, String password,
      Integer age, Gender gender) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.age = age;
    this.gender = gender;
  }

  public Customer(Integer id, String name, String email, String password,
      Integer age, Gender gender, String profileImageId) {
    this(id, name, email, password, age, gender);
    this.profileImageId = profileImageId;

  }

  public Customer(String name, String email, String password, Integer age, Gender gender) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.age = age;
    this.gender = gender;

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public String getProfileImageId() {
    return profileImageId;
  }

  public void setProfileImageId(String profileImageId) {
    this.profileImageId = profileImageId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Customer customer)) {
      return false;
    }

    if (getId() != null ? !getId().equals(customer.getId()) : customer.getId() != null) {
      return false;
    }
    if (getName() != null ? !getName().equals(customer.getName()) : customer.getName() != null) {
      return false;
    }
    if (getEmail() != null ? !getEmail().equals(customer.getEmail())
        : customer.getEmail() != null) {
      return false;
    }
    if (getAge() != null ? !getAge().equals(customer.getAge()) : customer.getAge() != null) {
      return false;
    }
    if (getGender() != customer.getGender()) {
      return false;
    }
    if (getPassword() != null ? !getPassword().equals(customer.getPassword())
        : customer.getPassword() != null) {
      return false;
    }
    return getProfileImageId() != null ? getProfileImageId().equals(customer.getProfileImageId())
        : customer.getProfileImageId() == null;
  }

  @Override
  public int hashCode() {
    int result = getId() != null ? getId().hashCode() : 0;
    result = 31 * result + (getName() != null ? getName().hashCode() : 0);
    result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
    result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
    result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
    result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
    result = 31 * result + (getProfileImageId() != null ? getProfileImageId().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", age=" + age +
        ", gender=" + gender +
        '}';
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority("ROLE_USER"));
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
```
### User Service
- UserDetailsService
```java
package com.jd.customer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by jd birla on 29-05-2023 at 13:08
 */
@Service
public class CustomerUserDetailService implements UserDetailsService {

  private final CustomerDao customerDao;

  public CustomerUserDetailService(@Qualifier("jpa") CustomerDao customerDao) {
    this.customerDao = customerDao;
  }


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return customerDao.selectUserByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found "));
  }
}

```

### Jwt Service
- JWTUtil
```java
package com.jd.jwt;

import static java.time.temporal.ChronoUnit.DAYS;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * Created by jd birla on 29-05-2023 at 09:48
 */
@Service
public class JWTUtil {

  private static final String SECRET_KEY =
      "foobar_123456789_foobar_123456789_foobar_123456789_foobar_123456789";


  public String issueToken(String subject) {
    return issueToken(subject, Map.of());
  }

  public String issueToken(String subject, String... scopes) {
    return issueToken(subject, Map.of("scopes", scopes));
  }

  public String issueToken(String subject, List<String> scopes) {
    return issueToken(subject, Map.of("scopes", scopes));
  }


  public String issueToken(
      String subject,
      Map<String, Object> claims) {
    String token = Jwts
        .builder()
        .setClaims(claims)
        .setSubject(subject)
        .setIssuer("https://amigoscode.com")
        .setIssuedAt(Date.from(Instant.now()))
        .setExpiration(
            Date.from(
                Instant.now().plus(15, DAYS)
            )
        )
        .signWith(getSigningKey(), SignatureAlgorithm.HS256)
        .compact();
    return token;
  }

  public String getSubject(String token) {
    return getClaims(token).getSubject();
  }

  private Claims getClaims(String token) {
    Claims claims = Jwts
        .parserBuilder()
        .setSigningKey(getSigningKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
    return claims;
  }

  private Key getSigningKey() {
    return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
  }

  public boolean isTokenValid(String jwt, String username) {
    String subject = getSubject(jwt);
    return subject.equals(username) && !isTokenExpired(jwt);
  }

  private boolean isTokenExpired(String jwt) {
    Date today = Date.from(Instant.now());
    return getClaims(jwt).getExpiration().before(today);
  }
}

```
### Authentication Service
- AuthenticationRequest
```java
package com.jd.auth;

/**
 * Created by jd birla on 30-05-2023 at 08:24
 */
public record AuthenticationRequest(String username, String password) {

}

```
- AuthenticationResponse
```java

package com.jd.auth;

import com.jd.customer.CustomerDTO;

/**
 * Created by jd birla on 30-05-2023 at 08:25
 */
public record AuthenticationResponse(String token, CustomerDTO customerDTO) {

}
```
- AuthenticationController
```java
package com.jd.auth;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jd birla on 30-05-2023 at 08:33
 */
@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  public AuthenticationController(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @PostMapping("login")
  public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
    AuthenticationResponse authenticationResponse = authenticationService.login(request);
    return ResponseEntity.ok()
        .header(HttpHeaders.AUTHORIZATION, authenticationResponse.token())
        .body(authenticationResponse);
  }

}


```
- AuthenticationService
```java
package com.jd.auth;

import com.jd.customer.Customer;
import com.jd.customer.CustomerDTO;
import com.jd.customer.CustomerDTOMapper;
import com.jd.jwt.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * Created by jd birla on 30-05-2023 at 08:26
 */
@Service
public class AuthenticationService {

  private final AuthenticationManager authenticationManager;
  private final CustomerDTOMapper customerDTOMapper;
  private final JWTUtil jwtUtil;

  public AuthenticationService(AuthenticationManager authenticationManager,
      CustomerDTOMapper customerDTOMapper, JWTUtil jwtUtil) {
    this.authenticationManager = authenticationManager;
    this.customerDTOMapper = customerDTOMapper;
    this.jwtUtil = jwtUtil;
  }

  public AuthenticationResponse login(AuthenticationRequest request) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.username(), request.password()));

    Customer principal = (Customer) authentication.getPrincipal();
    CustomerDTO customerDTO = customerDTOMapper.apply(principal);

    String jwtToken = jwtUtil.issueToken(customerDTO.username(), customerDTO.roles());
    return new AuthenticationResponse(jwtToken, customerDTO);
  }
}


```
- CustomerController
```java
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

  private final CustomerService customerService;
  private final JWTUtil jwtUtil;


  public CustomerController(CustomerService customerService, JWTUtil jwtUtil) {
    this.customerService = customerService;
    this.jwtUtil = jwtUtil;
  }
 @PostMapping
  public ResponseEntity<?> registerCustomer(
      @RequestBody CustomerRegistrationRequest request) {
    customerService.addCustomer(request);
    String jwtToken = jwtUtil.issueToken(request.email(), "ROLE_USER");
    return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwtToken).build();

  }
}
```
### Custom Filter
- JWTAuthenticationFilter
```java
package com.jd.jwt;

import com.jd.customer.CustomerUserDetailService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Created by jd birla on 29-05-2023 at 13:58
 */
@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {
  private final JWTUtil jwtUtil;
  private final UserDetailsService userDetailsService;

  public JWTAuthenticationFilter(JWTUtil jwtUtil,
      CustomerUserDetailService userDetailsService) {
    this.jwtUtil = jwtUtil;
    this.userDetailsService = userDetailsService;
  }

  @Override
  protected void doFilterInternal(@NonNull HttpServletRequest request,
      @NonNull HttpServletResponse response,
      @NonNull FilterChain filterChain)
      throws ServletException, IOException {

    String authHeader = request.getHeader("Authorization");

    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }

    String jwt = authHeader.substring(7);
    String subject = jwtUtil.getSubject(jwt);

    if (subject != null &&
        SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails userDetails = userDetailsService.loadUserByUsername(subject);
      if (jwtUtil.isTokenValid(jwt, userDetails.getUsername())) {
        UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities()
            );
        authenticationToken.setDetails(
            new WebAuthenticationDetailsSource().buildDetails(request)
        );
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
      }
    }
    filterChain.doFilter(request, response);

  }
}
```
### AuthenticationEntryPoint
```java
package com.jd.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

/**
 * Created by jd birla on 30-05-2023 at 07:08
 */
@Component
public class DelegatedAuthEntryPoint implements AuthenticationEntryPoint {

  private final HandlerExceptionResolver handlerExceptionResolver;

  public DelegatedAuthEntryPoint(
      @Qualifier("handlerExceptionResolver") HandlerExceptionResolver handlerExceptionResolver) {
    this.handlerExceptionResolver = handlerExceptionResolver;
  }

  @Override
  public void commence(HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException authException) throws IOException, ServletException {
    handlerExceptionResolver.resolveException(request, response, null, authException);
  }
}

```
### Web Security Setup
- SecurityConfig
```java
package com.jd.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by jd birla on 29-05-2023 at 13:20
 */
@Configuration
public class SecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(
      AuthenticationConfiguration configuration
  ) throws Exception {
    return configuration.getAuthenticationManager();
  }

  @Bean
  public AuthenticationProvider authenticationProvider(
      UserDetailsService userDetailsService,
      PasswordEncoder passwordEncoder
  ) {
    DaoAuthenticationProvider daoAuthenticationProvider =
        new DaoAuthenticationProvider();
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
    daoAuthenticationProvider.setUserDetailsService(userDetailsService);
    return daoAuthenticationProvider;
  }

}
```
- SecurityFilterChainConfig
```java
package com.jd.security;

import com.jd.jwt.JWTAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by jd birla on 29-05-2023 at 10:05
 */

@Configuration
@EnableWebSecurity
public class SecurityFilterChainConfig {

  private final AuthenticationProvider authenticationProvider;
  private final JWTAuthenticationFilter jwtAuthenticationFilter;
  private final AuthenticationEntryPoint authenticationEntryPoint;

  public SecurityFilterChainConfig(AuthenticationProvider authenticationProvider,
      JWTAuthenticationFilter jwtAuthenticationFilter,
      AuthenticationEntryPoint authenticationEntryPoint) {
    this.authenticationProvider = authenticationProvider;
    this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    this.authenticationEntryPoint = authenticationEntryPoint;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .cors(Customizer.withDefaults())
        .authorizeHttpRequests()
        .requestMatchers(HttpMethod.POST, "/api/v1/customers", "/api/v1/auth/login")
        .permitAll()
        .requestMatchers(HttpMethod.GET,"/ping")
        .permitAll()
        .requestMatchers(HttpMethod.GET,"/actuator/**")
        .permitAll()
        .requestMatchers(HttpMethod.GET,"/api/v1/customers/*/profile-image")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .exceptionHandling()
        .authenticationEntryPoint(authenticationEntryPoint);

    return http.build();
  }

}
```
- corsconfig
```java
package com.jd.security;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by jd birla on 27-05-2023 at 06:08
 */
@Configuration
@EnableWebMvc
public class CorsConfig {

  @Value("#{'${cors.allowed-origins}'.split(',')}")
  private List<String> allowedOrigins;

  @Value("#{'${cors.allowed-methods}'.split(',')}")
  private List<String> allowedMethods;

  @Value("#{'${cors.allowed-headers}'.split(',')}")
  private List<String> allowedHeaders;

  @Value("#{'${cors.exposed-headers}'.split(',')}")
  private List<String> expectedHeaders;

//  @Override
//  public void addCorsMappings(CorsRegistry registry) {
//    CorsRegistration corsRegistration = registry.addMapping("/api/**");
//    allowedOrigins.forEach(corsRegistration::allowedOrigins);
//    allowedMethods.forEach(corsRegistration::allowedMethods);
//
//  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(allowedOrigins);
    configuration.setAllowedMethods(allowedMethods);
    configuration.setAllowedHeaders(allowedHeaders);
    configuration.setExposedHeaders(expectedHeaders);
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/api/**", configuration);
    return source;
  }
}
```
