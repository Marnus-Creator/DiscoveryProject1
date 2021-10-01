package za.ac.nwu.ac.domain.persistence;


//import jdk.vm.ci.meta.Local;

//This class is only used to carry data (does not actually do anything other than that )

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "DEMO_ACCOUNT_TYPE", schema = "MARNUS")     //Table name & Username (Schema might not be needed)
public class AccountType implements Serializable {

    private static final long serialVersionUID = 3866606557126890054L;

    //Columns in Table follow:
    //This Column is a primary column and the keys are generated with this sequence Generator

    private long accountTypeID;
    private String mnemonic;
    private String accountTypeName;
    //These Date conventions are for services (can remove it here):
    // @JsonSerialize(using = LocalDateSerializer.class)
    //@JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate creationDate; //use this date not something like utilDate

    //@Column(name="ACCOUNT_TRANSACTIONS")
    private Set<AccountTransaction> accountTransactions;

    public AccountType() {
    }

    //Use right-click > generate to generate public classes for each column (Revise DB entities vid at 12:30)
    public AccountType(long accountTypeID, String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.accountTypeID = accountTypeID;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    public AccountType(String mnemonic, String accountTypeName, LocalDate creationDate)
    {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }



    @Id
    @SequenceGenerator(name = "VIT_RSA_GENERIC_SEQ", sequenceName = "MARNUS.VIT_RSA_GENERIC_SEQ", allocationSize = 1)       //SequenceName =?
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")
    @Column(name = "ACCOUNT_TYPE_ID") //Primary key column
    public long getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(long accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    @Column(name = "MNEMONIC") //mnemonic column
    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String  mnemonic) {
        this.mnemonic = mnemonic;
    }

    @Column(name = "ACCOUNT_TYPE_NAME") //accountTypeName column
    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @Column(name = "CREATION_DATE")
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions()
    {
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return accountTypeID == that.accountTypeID && mnemonic == that.mnemonic && accountTypeName == that.accountTypeName && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeID, mnemonic, accountTypeName, creationDate);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeID=" + accountTypeID +
                ", mnemonic=" + mnemonic +
                ", accountTypeName=" + accountTypeName +
                ", creationDate=" + creationDate +
                '}';
    }
}
