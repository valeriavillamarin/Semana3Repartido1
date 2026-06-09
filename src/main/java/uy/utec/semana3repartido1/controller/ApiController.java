package uy.utec.semana3repartido1.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/public/hello")
    public ResponseEntity<String> publicHello() {
        return ResponseEntity.ok("Hola mundo público");
    }

    @GetMapping("/admin/data")
    public ResponseEntity<String> adminData() {
        return ResponseEntity.ok("Dato secreto para ADMIN");
    }
}
