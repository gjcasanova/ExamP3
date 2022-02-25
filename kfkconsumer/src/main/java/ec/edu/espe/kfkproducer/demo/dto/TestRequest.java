package ec.edu.espe.kfkproducer.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class TestRequest implements Serializable {
    private String message;
}
