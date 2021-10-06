package za.ac.nwu.ac.domain.dto;

import za.ac.nwu.ac.domain.persistence.UserAccount;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction", description = "The DTO representing the AccountTransaction")
public class AccountTransactionDto implements Serializable {

    private static final long serialVersionUID = -4845756904783399418L;

    private Long transactionId;
    private String accountTypeMnemonic;
    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransactionDto() {
    }

    public AccountTransactionDto(Long transactionId, String accountTypeMnemonic, Long memberId, Long amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }


    @ApiModelProperty(
            position = 1,
            value = "AccountTransaction ID",
            name = "TransactionID",
            notes = "Name of the ID of the specific AccountTransaction",
            dataType = "java.lang.Long",
            example = "5",                              /*Any number as ID number*/
            allowEmptyValue = false,
            required = true
    )
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    @ApiModelProperty(
            position = 2,
            value = "AccountType Mnemonic",
            name = "Mnemonic",
            notes = "Uniquely identifies the account type",
            dataType = "java.lang.String",
            example = "MILES",
            required = true
    )
    public String getAccountTypeMnemonic() {
        return accountTypeMnemonic;
    }

    public void setAccountTypeMnemonic(String accountTypeMnemonic) {
        this.accountTypeMnemonic = accountTypeMnemonic;
    }

    @ApiModelProperty(
            position = 3,
            value = "Member ID",
            name = "MemberID",
            notes = "Name of the ID of the specific Member",
            dataType = "java.lang.Long",
            example = "6",                              /*Any number as ID number*/
            allowEmptyValue = false,
            required = true
    )
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @ApiModelProperty(
            position = 4,
            value = "AccountTransaction Amount",
            name = "TransactionAmount",
            notes = "The Transaction Amount",
            dataType = "java.lang.Integer",
            example = "100",                              /*Any number as ID number*/
            allowEmptyValue = false,
            required = true
    )
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @ApiModelProperty(
            position = 5,
            value = "AccountTransaction Transaction Date",
            name = "TransactionDate",
            notes = "The date the Transaction was made",
            dataType = "java.lang.String",
            example = "2021-01-01",
            allowEmptyValue = true
    )
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountTypeMnemonic, that.accountTypeMnemonic) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountTypeMnemonic, memberId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "transactionId=" + transactionId +
                ", accountTypeMnemonic='" + accountTypeMnemonic + '\'' +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }

    /*!!!!  NEED TO COMPLETE !!!!*/

}
