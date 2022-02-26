package ec.edu.espe.kfkproducer.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Loan {
    private String id;
    private Long feeValue;
    private Date paymentDate;
    private Integer feeNumber;
}
