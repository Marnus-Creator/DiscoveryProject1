package za.ac.nwu.ac.translator.impl;
//TODO: Remember to mark Updates, deletes and modifies with @Transaction

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountTypeTranslatorImpl.class);
    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Transactional
    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try {
            for (AccountType accountType: accountTypeRepository.findAll()) { // for all Accounts in the Repository
                accountTypeDtos.add(new AccountTypeDto(accountType));
            }
        } catch (Exception e) {
            // TODO: Log
            throw new RuntimeException("Sorry, Unable to read from the database",e);
        }
        return accountTypeDtos;
    }

    @Transactional
    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto) {
        try {
            AccountType accountType = accountTypeRepository.save(accountTypeDto.getAccountType());
            return new AccountTypeDto(accountType);
        } catch (Exception e) {
            throw new RuntimeException("Sorry, Unable to save to the database",e);
        }
    }


    @Override
    public AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic) {
        try {
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonicNativeQuery(mnemonic);
            return new AccountTypeDto(accountType);
        } catch (Exception e) {
            throw new RuntimeException("Sorry, Unable to read from the database",e);
        }
    }
    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic) {
        try {
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            return new AccountTypeDto(accountType);
        } catch (Exception e) {
            throw new RuntimeException("Sorry, Unable to read from the database",e);
        }
    }
    @Override
    public AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic) {
        try {
            AccountType accountType = accountTypeRepository.getAccountTypeDtoByMnemonic(mnemonic);
            return new AccountTypeDto(accountType);
        } catch (Exception e) {
            throw new RuntimeException("Sorry, Unable to read from the database",e);
        }
    }

    @Override
    @Transactional
    public AccountTypeDto deleteAcountType(String mnemonic) {
        try{
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            accountTypeRepository.deleteAcountType(mnemonic);
            return new AccountTypeDto(accountType);        }catch (Exception e){
            throw new RuntimeException("Unable to read from DB ", e);
        }
    }

    @Override
    @Transactional
    public AccountTypeDto updateAccountType(AccountTypeDto accountType) {
        try{
            accountTypeRepository.updateAccountType(accountType.getMnemonic(), accountType.getAccountTypeName(),
                    accountType.getCreationDate());
            return accountType;
        }catch (Exception e){
            throw new RuntimeException( "Unable to update DB ", e);
        }
    }

}
