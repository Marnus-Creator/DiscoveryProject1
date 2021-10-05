package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.ModifyAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class ModifyAccountTypeFlowImpl implements ModifyAccountTypeFlow {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModifyAccountTypeFlowImpl.class);


    private final AccountTypeTranslator accountTypeTranslator;

    public ModifyAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto deleteAccountType(String mnemonic) {
        LOGGER.info("AccountType to be deleted, use {}", mnemonic);

        AccountTypeDto result =accountTypeTranslator.deleteAcountType(mnemonic);
        LOGGER.info("This Account Type was deleted, used {}", result);
        return result;
    }

    @Override
    public AccountTypeDto updateAccountType(AccountTypeDto accountType) {

        LOGGER.info("AccountType to Update, use input object {}", accountType);

        AccountTypeDto result =accountTypeTranslator.updateAccountType(accountType);
        LOGGER.info("AccountType was updated, used output object {}", result);
        return result;
    }

    /*@Override
    public AccountTypeDto updateAccountType(String mnemonic, String newAccountTypeName, LocalDate newCreationDate) {

        LOGGER.info("AccountType to Update, use input object {}", accountType);

        AccountTypeDto result =accountTypeTranslator.updateAccountType(accountType);
        LOGGER.info("AccountType was updated, used output object {}", result);
        return result;
    }*/

}
