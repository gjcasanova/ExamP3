package ec.edu.espe.kfkproducer.demo.config;

import ec.edu.espe.kfkproducer.demo.dto.Loan;
import ec.edu.espe.kfkproducer.demo.dto.TestRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class KafkaDemoListeners {
    @KafkaListener(topics = "demo-events", groupId = "spring")
    public void Listener(List<Loan> data){
        log.info("{}", data.size());
    }
}
