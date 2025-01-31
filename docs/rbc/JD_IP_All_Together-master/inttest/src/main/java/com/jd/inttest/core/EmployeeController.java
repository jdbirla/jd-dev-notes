package com.jd.inttest.core;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping
    public ResponseEntity<Employee> getEmployeeId(@RequestParam int employeeId)
    {
        Employee e  = new Employee();
        e.setId(null);
        e.setDept("abc");
       return ResponseEntity.ok().body(e);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee)
    { //e
        //save into db
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
