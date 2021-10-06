package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.UserAccountDto;

public interface UserAccountTranslator {
    UserAccountDto getUserByMemberIDAndAccountTypeID(Long memberId, Long accountTypeId);

    UserAccountDto updateUserAccount(Integer newBal, Long memberId, Long accountTypeId);
}
