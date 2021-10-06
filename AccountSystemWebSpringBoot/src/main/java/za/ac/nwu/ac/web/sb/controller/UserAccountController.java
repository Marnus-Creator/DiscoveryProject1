package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.UserAccountDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.ModifyUserAccountFlow;

@RestController
@RequestMapping("user-account")
public class UserAccountController {
    private final Logger LOGGER = LoggerFactory.getLogger(UserAccountController.class);

    private final ModifyUserAccountFlow modifyUserAccountFlow;

    @Autowired
    public UserAccountController(ModifyUserAccountFlow modifyUserAccountFlow) {
        this.modifyUserAccountFlow = modifyUserAccountFlow;
    }

    @PutMapping("subtract/{subtract}")
    @ApiOperation(value = "Subtract value from the UserAccount",
    notes="")
    @ApiResponses(value={
            @ApiResponse(code=201, message = "Account Type Successfully Updated", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<UserAccountDto>>subtractUserAccount(
            @ApiParam(value="Transaction Value",
                    name="subtract",
                    example = "600",
                    required = true)
            @PathVariable("subtract") final String subtractValue,

            @ApiParam(value = "The MemberID that uniquely identifies the UserAccountOwner.",
                    name = "memberID",
                    example = "1000000001",
                    required = true)
            @RequestParam("memberID") final Long memberID,

            @ApiParam(value = "The AccountTypeID that uniquely identifies the AccountType.",
                    name="accountTypeID",
                    example = "100000000000008",
                    required = true)
            @RequestParam("accountTypeID") final Long accountTypeID
    ){
        Integer intToPass =0;
        try{
            intToPass = Integer.parseInt(subtractValue);
        }catch (NumberFormatException e){
            LOGGER.error("Subtract Value parse operation failed", e);
        }
        LOGGER.info("Value of SubtractValue {}", subtractValue);
        LOGGER.info("Value of MemberID {}", memberID);
        LOGGER.info("Value of AccountTypeID {}", accountTypeID);

        UserAccountDto userAccount = modifyUserAccountFlow.subtractCurrency(intToPass, memberID, accountTypeID);
        LOGGER.info("Update operation completed successfully");
        GeneralResponse<UserAccountDto> response = new GeneralResponse<>(true, userAccount);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
