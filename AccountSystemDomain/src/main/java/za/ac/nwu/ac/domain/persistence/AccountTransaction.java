package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

//Fix Foreign key stuffies!!!!!!!!!!!!!!!!!!!

@Entity
@Table(name = "DEMO_ACCOUNT_TYPE", schema = "MARNUS")
public class AccountTransaction implements Serializable{

    private static final long serialVersionUID = 1199041377884282633L;

    @Id
    @SequenceGenerator(name = "VIT_RSA_GENERIC_SEQ", sequenceName = "MARNUS.VIT_RSA_GENERIC_SEQ", allocationSize = 1) //sequenceName
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")
    @Column(name = "TX_ID") //Primary key column
    private long transactionID;

    @Column(name = "ACCOUNT_TYPE_ID")
    private long accountTypeId;

    @Column(name = "MEMBER_ID")
    private long memberId;

    @Column(name = "AMOUNT")
    private long amount;

    @Column(name = "TX_DATE")
    private long transactionDate;

    public AccountTransaction(long transactionID, long accountTypeId, long memberId, long amount, long transactionDate) {
        this.transactionID = transactionID;
        this.accountTypeId = accountTypeId;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransaction() {
    }

    public long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(long transactionID) {
        this.transactionID = transactionID;
    }

    public long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(long transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return transactionID == that.transactionID && accountTypeId == that.accountTypeId && memberId == that.memberId && amount == that.amount && transactionDate == that.transactionDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, accountTypeId, memberId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionID=" + transactionID +
                ", accountTypeId=" + accountTypeId +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
