package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@ApiModel(value = "UserAccount", description = "The DTO representing the UserAccount")
public class UserAccountDto implements Serializable {

    private static final long serialVersionUID = 5001513593529715826L;

    private Long userAccountId;
    private Long accountTypeId;
    private Long accountBalance;
    private Long memberId;

    public UserAccountDto() {
    }

    public UserAccountDto(Long userAccountId, Long accountTypeId, Long accountBalance, Long memberId) {
        this.userAccountId = userAccountId;
        this.accountTypeId = accountTypeId;
        this.accountBalance = accountBalance;
        this.memberId = memberId;
    }

    @ApiModelProperty(
            position = 1,
            value = "User Account ID",
            name = "UserAccountId",
            notes = "Name of the ID of the specific UserAccountId",
            dataType = "java.lang.Long",
            example = "7",                              /*Any number as ID number*/
            allowEmptyValue = false,
            required = true
    )
    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    @ApiModelProperty(
            position = 2,
            value = "Account Type ID",
            name = "AccountTypeId",
            notes = "Name of the ID of the specific AccountTypeId",
            dataType = "java.lang.Long",
            example = "8",                              /*Any number as ID number*/
            allowEmptyValue = false,
            required = true
    )
    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @ApiModelProperty(
            position = 3,
            value = "Account Type ID",
            name = "AccountTypeId",
            notes = "Name of the ID of the specific AccountTypeId",
            dataType = "java.lang.Long",
            example = "8",                              /*Any number as ID number*/
            allowEmptyValue = false,
            required = true
    )
    public Long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }

    @ApiModelProperty(
            position = 4,
            value = "Member ID",
            name = "MemberId",
            notes = "Name of the ID of the specific MemberId",
            dataType = "java.lang.Long",
            example = "9",                              /*Any number as ID number*/
            allowEmptyValue = false,
            required = true
    )
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
        UserAccountDto that = (UserAccountDto) o;
        return Objects.equals(userAccountId, that.userAccountId) && Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(accountBalance, that.accountBalance) && Objects.equals(memberId, that.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userAccountId, accountTypeId, accountBalance, memberId);
    }

    @Override
    public String toString() {
        return "UserAccountDto{" +
                "userAccountId=" + userAccountId +
                ", accountTypeId=" + accountTypeId +
                ", accountBalance=" + accountBalance +
                ", memberId=" + memberId +
                '}';
    }
}
