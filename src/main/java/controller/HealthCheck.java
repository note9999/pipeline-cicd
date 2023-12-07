package controller;


import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HealthCheck {

    private static final String HEALTH_ENDPOINT_URL = "http://localhost:8080/actuator/health"; // Actuator health 엔드포인트 URL

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        // Actuator의 health 엔드포인트를 호출하여 상태를 가져옴
        Health health = restTemplate.getForObject(HEALTH_ENDPOINT_URL, Health.class);

        if (health != null) {
            Status status = health.getStatus();
            System.out.println("Health Status: " + status.getCode()); // 상태 코드 출력
            System.out.println("Health Details: " + health.getDetails()); // 상세 정보 출력
        } else {
            System.out.println("Health check failed!");
        }
    }
}
