package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    @Query(value="SELECT " +
            "ua " +
            "FROM " +
            "UserAccount ua " +
            "WHERE " +
            "ua.memberID = :member " +
            "AND ua.accountTypeID = : accountType")
    UserAccount getUserByMemberIDAndAccountTypeID(@Param("member") Long memberID, @Param("accountType")Long accountTypeID);

    @Modifying
    @Query(value = "UPDATE " +
            "UserAccount ua " +
            "SET ua.accountBalance = :accountBalance " +
            "WHERE ua.memberID = :memberID " +
            "AND ua.accountTypeID = :accountTypeID")
    void updateUserAccount(@Param("accountBalance") Integer newBal,@Param("memberID") Long memberId,@Param("accountTypeID") Long accountTypeId);
}
