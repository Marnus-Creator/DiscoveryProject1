package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.UserAccountDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.FetchUserAccountFlow;
import za.ac.nwu.ac.logic.flow.ModifyUserAccountFlow;

@RestController
@RequestMapping("user-account")
public class UserAccountController {
    private final Logger LOGGER = LoggerFactory.getLogger(UserAccountController.class);

    private final ModifyUserAccountFlow modifyUserAccountFlow;
    private final FetchUserAccountFlow fetchUserAccountFlow;

    @Autowired
    public UserAccountController(ModifyUserAccountFlow modifyUserAccountFlow, FetchUserAccountFlow fetchUserAccountFlow) {
        this.modifyUserAccountFlow = modifyUserAccountFlow;
        this.fetchUserAccountFlow = fetchUserAccountFlow;
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
            @RequestParam("accountTypeID") final Long accountTypeID)
    {
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

    @PutMapping("add/{add}")
    @ApiOperation(value = "Add value from the UserAccount",
            notes="")
    @ApiResponses(value=
            {
            @ApiResponse(code=201, message = "Account Type Successfully Updated", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<UserAccountDto>>addUserAccount(
            @ApiParam(value="Transaction Value",
                    name="add",
                    example = "600",
                    required = true)
            @PathVariable("add") final String addValue,

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
            intToPass = Integer.parseInt(addValue);
        }catch (NumberFormatException e){
            LOGGER.error("Add Value parse operation failed", e);
        }
        LOGGER.info("Value of AddValue {}", addValue);
        LOGGER.info("Value of MemberID {}", memberID);
        LOGGER.info("Value of AccountTypeID {}", accountTypeID);

        UserAccountDto userAccount = modifyUserAccountFlow.addCurrency(intToPass, memberID, accountTypeID);
        LOGGER.info("Update operation completed successfully");
        GeneralResponse<UserAccountDto> response = new GeneralResponse<>(true, userAccount);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{memberID}/{accountTypeID}")                                                           //Making use of a path variable
   @ApiOperation(value="Fetches UserAccount details for specified MemberID and AccountTypeID",
           notes = "Fetches a UserAccount for specified MemberID and AccountTypeID")
   @ApiResponses(value = {
           @ApiResponse(code = 200, message = "AccountTypes Returned", response = GeneralResponse.class),
           @ApiResponse(code = 400, message = "Sorry, Bad request", response = GeneralResponse.class),
           @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
           @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
   })
   public ResponseEntity<GeneralResponse<UserAccountDto>> getUserDetailsByMemberIDandAccountID(
           @ApiParam(value = "The MemberID, uniquely identifies the specific UserAccount.",
                   name = "memberID",
                   example = "1000000001",
                   required = true)
           @PathVariable("memberID")final String memberID,

           @ApiParam(value = "The AccountTypeID, uniquely identifies the specific AccountType.",
                   name = "accountTypeID",
                   example = "100000000000008",
                   required = true)
           @PathVariable("accountTypeID") final String accountTypeID){

       Long userToPass = Long.valueOf(0);
       Long accTypeToPass = Long.valueOf(0);

       try
       {
           userToPass = Long.parseLong(memberID);
           accTypeToPass = Long.parseLong(accountTypeID);
       }
       catch(NumberFormatException e)
       {
           LOGGER.error("Parses Failed", e);
       }

       LOGGER.info("Trying to find UserAccount with properties: " +
               "\nAccountTypeID = {}" +
               "\nMemberID = {}",accountTypeID,memberID);
       UserAccountDto userAccount =fetchUserAccountFlow.getUserDetailsByMemberIDandAccountID(userToPass , accTypeToPass);
       LOGGER.info("User Account with specified properties found.");
       GeneralResponse<UserAccountDto> response = new GeneralResponse<>(true, userAccount);
       return new ResponseEntity<>(response, HttpStatus.OK);
   }


}
