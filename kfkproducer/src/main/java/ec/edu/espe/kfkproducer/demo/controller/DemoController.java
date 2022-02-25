package ec.edu.espe.kfkproducer.demo.controller;

import ec.edu.espe.kfkproducer.demo.dto.TestRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@Data
@Slf4j
@RestController
@RequestMapping(value = "api/v1")
public class DemoController {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping(value = "/")
    public ResponseEntity test(@RequestBody TestRequest request){
        log.info(request.getMessage());
        kafkaTemplate.send("demo-events", request);
        return ResponseEntity.ok().build();
    }
}
