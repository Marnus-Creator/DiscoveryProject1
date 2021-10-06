package za.ac.nwu.ac.domain.dto;

import za.ac.nwu.ac.domain.persistence.UserAccount;

import java.io.Serializable;
import java.time.LocalDate;

public class AccountTransactionDto implements Serializable {

    private static final long serialVersionUID = -4845756904783399418L;
    private Long transactionId;
    private String accountTypeMnemonic;
    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;


}
