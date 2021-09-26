package za.ac.nwu.ac.logic.flow.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
/*import java.time.LocalDate;
import java.util.ArrayList;*/
import java.util.List;

@Transactional
@Component
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator)
    {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes()
    {
//        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
//        accountTypeDtos.add(new AccountTypeDto("MILES", "Miles", LocalDate.now()));       //How to add new AccountTypeDto manually
//        return accountTypeDtos;
        return accountTypeTranslator.getAllAccountTypes();
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic)
    {
        return accountTypeTranslator.getAccountTypeByMnemonic(mnemonic);
    }

    public boolean methodToTest()                                                           //Method for Unit Testing;  Make sure Test directory "java" is marked as 'source root' (must be green)
    {
        return true;
    }


}
