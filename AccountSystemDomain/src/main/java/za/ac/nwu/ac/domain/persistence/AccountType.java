package za.ac.nwu.ac.domain.persistence;


import jdk.vm.ci.meta.Local;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "DEMO_ACCOUNT_TYPE", schema = "VITRSA_SANDBOX")     //Table name & Username (Schema migh not be needed)


public class AccountType implements Serializable {
    @Id
    @SequenceGenerator(name = "VIT_RSA_GENERIC_SEQ", sequenceName = "VITRSA_SANDBOX.VIT_RSA_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")

    //Columns in Table follow:
    @Column(name = "ACCOUNT_TYPE_ID") //Primary key column
    private long accountTypeID;

    @Column(name = "MNEMONIC") //mnemonic column
    private long mnemonic;

    @Column(name = "ACCOUNT_TYPE_NAME") //accountTypeName column
    private long accountTypeName;

    // @JsonSerialize(using = LocalDateSerialiser.class)
    //@JsonDeserialize(using = LocalDateDeserializer.class)
    @Column(name = "CREATION_DATE")
    private LocalDate creationDate;

}
