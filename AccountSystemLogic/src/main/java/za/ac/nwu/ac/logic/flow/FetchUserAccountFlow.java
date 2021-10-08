package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.UserAccountDto;

public interface FetchUserAccountFlow {
    UserAccountDto getUserDetailsByMemberIDandAccountID(Long userID, Long accntTypeID);
}
