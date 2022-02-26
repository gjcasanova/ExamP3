package ec.edu.espe.kfkproducer.demo.controller;

import ec.edu.espe.kfkproducer.demo.dto.GeneratorRequest;
import ec.edu.espe.kfkproducer.demo.dto.Loan;
import ec.edu.espe.kfkproducer.demo.dto.TestRequest;
import ec.edu.espe.kfkproducer.demo.utils.LoanGenerator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@Slf4j
@RestController
@RequestMapping(value = "api/v1/loansGenerator")
public class DemoController {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping(value = "/")
    public ResponseEntity test(@RequestBody GeneratorRequest request){
        LoanGenerator loanGenerator = new LoanGenerator();
        List<Loan> loans = loanGenerator.generate(request.getNumberOfRecords());

        kafkaTemplate.send("demo-events", loans);
        return ResponseEntity.ok().build();
    }
}
