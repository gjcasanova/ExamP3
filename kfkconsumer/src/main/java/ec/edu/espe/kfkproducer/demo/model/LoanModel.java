package ec.edu.espe.kfkproducer.demo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(value = "loan")
@Builder
@Data
public class LoanModel {
    @Id
    private String id;

    private String loanCode;
    private Long feeValue;
    private Date paymentDate;
    private Integer feeNumber;
}
