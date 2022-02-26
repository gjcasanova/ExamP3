package ec.edu.espe.kfkproducer.demo.utils;

import ec.edu.espe.kfkproducer.demo.dto.Loan;

import java.util.*;

public class LoanGenerator {

    private Random random;

    public LoanGenerator(){
        random = new Random();
    }

    public String generateId(Integer id){
        return String.format("%07d", id);
    }

    public Long generateFeeValue(){
        Long minBoundary = 25l, maxBoundary = 5000l;
        return minBoundary + random.nextLong(maxBoundary - minBoundary);
    }

    public Date generatePaymentDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, random.nextInt(365 * 5) * -1);
        return calendar.getTime();
    }

    public Integer generateFeeNumber(){
        return 1 + random.nextInt(12 * 10 -1);
    }

    public List<Loan> generate(Integer numberOfRecords){
        List<Loan> result = new ArrayList<Loan>();

        for (Integer i=0; i<numberOfRecords; i++){
            result.add(Loan.builder()
                    .id(generateId(i))
                    .feeValue(generateFeeValue())
                    .paymentDate(generatePaymentDate())
                    .feeNumber(generateFeeNumber())
                    .build());

        }
        return result;
    }
}
