package controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HealthCheckController {

    @Value("${test.test-value}")
    private String valueTest;

    @GetMapping("/health/check")
    public ResponseEntity<String> healthCheck() {

        String msg = "This api works well!" + valueTest;

        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "application/json; charset=UTF-8");

        return new ResponseEntity<>(msg,header, HttpStatus.OK);
    }

}