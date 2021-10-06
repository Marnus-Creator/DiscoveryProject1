package za.ac.nwu.ac.translator.impl;

import za.ac.nwu.ac.domain.dto.UserAccountDto;
import za.ac.nwu.ac.domain.persistence.UserAccount;
import za.ac.nwu.ac.repo.persistence.UserAccountRepository;
import za.ac.nwu.ac.translator.UserAccountTranslator;

import java.util.logging.Logger;

public class UserAccountTranslatorImpl implements UserAccountTranslator {
    private final UserAccountRepository userAccountRepository;

    public UserAccountTranslatorImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserAccountDto getUserByMemberIDAndAccountTypeID(Long memberId, Long accountTypeId) {
        try{
            UserAccount userAccount = userAccountRepository.getUserByMemberIDAndAccountTypeID(memberId, accountTypeId);
            return  new UserAccountDto(userAccount);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public UserAccountDto updateUserAccount(Integer newBal, Long memberId, Long accountTypeId) {
        try{
            UserAccount userAccount = new UserAccount(accountTypeId,  newBal, memberId );
            userAccountRepository.updateUserAccount(newBal, memberId, accountTypeId);
            return new UserAccountDto(userAccount);
        }catch(Exception e){
            throw new RuntimeException("Unable to update DB", e);
        }
    }
}
