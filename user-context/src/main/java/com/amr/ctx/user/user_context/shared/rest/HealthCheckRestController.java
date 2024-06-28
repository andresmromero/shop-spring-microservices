package com.amr.ctx.user.user_context.shared.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/users")
public class HealthCheckRestController {

    @GetMapping("/health-check/bounded-context")
    public ResponseEntity<HashMap<String, String>> healthCheckBoundedContext() {

        HashMap<String, String> status = new HashMap<>();
        status.put("bounded-context", "user-context");
        status.put("status", "ok");
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}
