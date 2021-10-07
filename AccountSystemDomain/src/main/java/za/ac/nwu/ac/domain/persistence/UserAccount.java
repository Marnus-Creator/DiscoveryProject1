package za.ac.nwu.ac.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "USER_ACCOUNT", schema = "MARNUS")     //Table name & Username (Schema might not be needed)
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 1721935955949522116L;

    private Long userAccountId;
    private Long accountTypeId;
    private Integer accountBalance;
    private Long memberId;

    public UserAccount() {
    }

    public UserAccount(Long userAccountId, Long accountTypeId, Integer accountBalance, Long memberId, LocalDate creationDate) {
        this.userAccountId = userAccountId;
        this.accountTypeId = accountTypeId;
        this.accountBalance = accountBalance;
        this.memberId = memberId;
        }

    public UserAccount(Long accountTypeId, Integer accountBalance, Long memberId, LocalDate creationDate) {
        this.accountTypeId = accountTypeId;
        this.accountBalance = accountBalance;
        this.memberId = memberId;
        }

    public UserAccount(Long userAccountId, Integer accountBalance, Long memberId) {
        this.userAccountId = userAccountId;
        this.accountBalance = accountBalance;
        this.memberId = memberId;
    }

    @Id
    @SequenceGenerator(name = "USER_ACCOUNT_ID_SEQ", sequenceName = "MARNUS.USER_ACCOUNT_ID_SEQ", allocationSize = 1)       //SequenceName =?
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ACCOUNT_ID_SEQ")
    @Column(name = "USER_ACCOUNT_ID") //Primary key column
    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }
    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }
@Column(name = "ACCOUNT_BALANCE")
    public Integer getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Integer accountBalance) {
        this.accountBalance = accountBalance;
    }
@Column(name = "MEMBER_ID")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(userAccountId, that.userAccountId) && Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(accountBalance, that.accountBalance) && Objects.equals(memberId, that.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userAccountId, accountTypeId, accountBalance, memberId);
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userAccountId=" + userAccountId +
                ", accountTypeId=" + accountTypeId +
                ", accountBalance=" + accountBalance +
                ", memberId=" + memberId +
                '}';
    }
}
