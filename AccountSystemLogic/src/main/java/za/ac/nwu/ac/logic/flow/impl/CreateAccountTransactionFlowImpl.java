package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;
import za.ac.nwu.ac.translator.UserAccountTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTransactionFlowImpl.class);       //how to add LOGGING for a class

    private final AccountTransactionTranslator accountTransactionTranslator;
    private final UserAccountTranslator userAccountTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;


    public CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator,
                                            UserAccountTranslator userAccountTranslator,
                                            FetchAccountTypeFlow fetchAccountTypeFlow)
    {
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.userAccountTranslator = userAccountTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
    }

    /*@Override
    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto)
    {
        LOGGER.info("The input object was {}", accountTransactionDto);

        accountTransactionDto.setTransactionId(null);       //Empty it, in case it has input

        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountTransactionDto.getAccountTypeMnemonic());
        LOGGER.info("Got AccountType for {} and the AccountTypeID is {}", accountTransactionDto.getAccountTypeMnemonic(),
                accountType.getAccountTypeID());
        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType);

        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);       //Might need import for save

        if (null != accountTransactionDto.getDetails())         //Need to create specific method for my use case
        {
            *//*!!!!!!!!!!!   Need  Stuff   !!!!!!!!!!!!!!*//*
        }

        AccountTransactionDto results = new AccountTransactionDto(createdAccountTransaction);
        LOGGER.info("The return object is {}", results);
        return results;
    }*/
}
