package ec.edu.espe.kfkproducer.demo.dto;

import ec.edu.espe.kfkproducer.demo.model.LoanModel;
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

    public LoanModel parseToModel(){
        return LoanModel.builder()
                .loanCode(id)
                .feeNumber(feeNumber)
                .feeValue(feeValue)
                .paymentDate(paymentDate)
                .build();
    }
}
