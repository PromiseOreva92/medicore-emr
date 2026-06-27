package com.app.medicore.controller;


import com.app.medicore.messaging.producer.TestProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor

public class TestController {

    private final TestProducer testProducer;
    @GetMapping("/api/test")
    public String test(){
      return "Authenticated Successs";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminOnly() {
        return "Admin Access";
    }

    @GetMapping("/doctor")
    @PreAuthorize("hasRole('DOCTOR')")
    public String doctorOnly() {
        return "Doctor Access";
    }


    @GetMapping("/rabbit")
    public String testRabbit() {

        testProducer.send(
                "RabbitMQ is working!"
        );

        return "Message Sent";
    }

}
