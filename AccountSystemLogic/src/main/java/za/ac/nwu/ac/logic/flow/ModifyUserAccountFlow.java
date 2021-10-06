package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.UserAccountDto;

import javax.transaction.Transactional;

public interface ModifyUserAccountFlow {

    @Transactional
    UserAccountDto subtractCurrency(Integer subtractVal, Long memberId, Long accountTypeId);

    @Transactional
    UserAccountDto addCurrency(Integer subtractVal, Long memberId, Long accountTypeId);



}
