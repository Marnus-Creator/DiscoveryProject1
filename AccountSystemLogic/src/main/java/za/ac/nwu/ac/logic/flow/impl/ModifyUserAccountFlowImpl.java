package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.ac.nwu.ac.domain.dto.UserAccountDto;
import za.ac.nwu.ac.logic.flow.ModifyUserAccountFlow;
import za.ac.nwu.ac.translator.UserAccountTranslator;

import javax.transaction.Transactional;

public class ModifyUserAccountFlowImpl implements ModifyUserAccountFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModifyUserAccountFlowImpl.class);
    private final UserAccountTranslator userAccountTranslator;

    public ModifyUserAccountFlowImpl(UserAccountTranslator userAccountTranslator) {
        this.userAccountTranslator = userAccountTranslator;
    }


    @Transactional
    @Override
    public UserAccountDto subtractCurrency(Integer subtractVal, Long memberId, Long accountTypeId)
    {
        if(subtractVal >= 0)
        {
            subtractVal = (-1 * subtractVal);
        }
        LOGGER.info("The UserAccount te Update has input values: " +
                "\nSubtractValue = {}" +
                "\nMemberID = {}" +
                "\nAccountTypeID = {}",subtractVal, memberId, accountTypeId);

        Integer oldBal =0;
        Integer newBal =0;

        oldBal =Integer.parseInt(String.valueOf(userAccountTranslator.getUserByMemberIDAndAccountTypeID(memberId, accountTypeId).getAccountBalance()));

        if((subtractVal + oldBal) >= 0){
            LOGGER.info("Transaction is valid");
            newBal = oldBal + subtractVal;
            UserAccountDto result = userAccountTranslator.updateUserAccount(newBal, memberId, accountTypeId);
            LOGGER.info("UserAccount was updated and has return object {}", result);
            return result;
        }else{
            LOGGER.warn("Transaction is not valid - Cannot subtract more tha you own!");
            throw new RuntimeException("Unable to update the database");
        }
    }

    @Override
    public UserAccountDto addCurrency(Integer subtractVal, Long memberId, Long accountTypeId) {
        return null;
    }
}
