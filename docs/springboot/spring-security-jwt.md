# spring-security-jwt
# This is implemented based on spring boot 3.0.0 and Spring security 6
- https://medium.com/@truongbui95/jwt-authentication-and-authorization-with-spring-boot-3-and-spring-security-6-2f90f9337421
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
   1. The AuthenticationManager is responsible for authenticating the Authentication object, handling all necessary tasks. If the username or password is incorrect, an exception is thrown, and a response with HTTP Status 403 is returned to the user.
   1. After successful authentication, an attempt is made to retrieve the user from the database. If the user does not exist in the database, a response with HTTP Status 403 is sent to the user. However, since we have already passed step 2 (authentication), this step is not crucial, as the user should already be in the database.
   1. Once we have the user information, we call the JwtService to generate the JWT.
   1. The JWT is then encapsulated in a JSON response and returned to the user.
>Two new concepts are introduced in this process, and I’ll provide a brief explanation for each.
>1. **UsernamePasswordAuthenticationToken**: A type of Authentication object which can be created from a username and password that are submitted.
>2. **AuthenticationManager**: Processes authentication object and will do all authentication jobs for us.

### Resources Access
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/06a88be3-0480-4d10-a2fa-6398fa119d5d)
   1. The process starts when the user sends a request to the Service. The request is first intercepted by JwtAuthenticationFilter, which is a custom filter integrated into the SecurityFilterChain.
   1. As the API is secured, if the JWT is missing, a response with HTTP Status 403 is sent to the user.
   1. When an existing JWT is received, JwtService is called to extract the userEmail from the JWT. If the userEmail cannot be extracted, a response with HTTP Status 403 is sent to the user.
   1. If the userEmail can be extracted, it will be used to query the user’s authentication and authorization information via UserDetailsService.
   1. If the user’s authentication and authorization information does not exist in the database, a response with HTTP Status 403 is sent to the user.
   1. If the JWT is expired, a response with HTTP Status 403 is sent to the user.
   1. Upon successful authentication, the user’s details are encapsulated in a UsernamePasswordAuthenticationToken object and stored in the SecurityContextHolder.
   1. The Spring Security Authorization process is automatically invoked.
   1. The request is dispatched to the controller, and a successful JSON response is returned to the user.
>This process is a little more tricky, it involves some new concepts. Let’s dive into them in more detail:
>1. **SecurityFilterChain**: a filter chain which is capable of being matched against an HttpServletRequest. in order to decide whether it applies to that request.
>2. **SecurityContextHolder**: is where Spring Security stores the details of who is authenticated. Spring Security uses that information for authorization.
>3. **UserDetailsService**: Service to fetch user-specific data.
>4. **Authorization Architecture**
   
