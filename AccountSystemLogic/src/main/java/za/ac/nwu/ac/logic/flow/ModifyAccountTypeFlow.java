package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;

public interface ModifyAccountTypeFlow {
    AccountTypeDto deleteAcountType(String mnemonic);

    AccountTypeDto updateAccountType(AccountTypeDto accountType);
}
