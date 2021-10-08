package za.ac.nwu.ac.logic.flow.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.UserAccountDto;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.FetchUserAccountFlow;
import za.ac.nwu.ac.translator.UserAccountTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
public class FetchUserAccountFlowImpl implements FetchUserAccountFlow {
    private static final Logger LOGGER = LoggerFactory.getLogger(FetchUserAccountFlowImpl.class);
    private final UserAccountTranslator userAccountTranslator;

    public FetchUserAccountFlowImpl(UserAccountTranslator userAccountTranslator)
    {
        this.userAccountTranslator = userAccountTranslator;
    }

    @Override
    public UserAccountDto getUserByMemberIDandAccountID(Long userAccountID, Long accountTypeID)
    {
        UserAccountDto result = userAccountTranslator.getUserByMemberIDAndAccountTypeID(userAccountID, accountTypeID);
        LOGGER.info("The UserAccountDto is {}", result);
        return result;
    }
}
