package za.ac.nwu.ac.web.sb.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;

import java.util.List;

@RestController
@RequestMapping("account-type")                                                         //There can only be one post, in this case the mapping is for account-type
public class AccountTypeController {

    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;

    @Autowired
    public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow, @Qualifier("createAccountTypeFlowName") CreateAccountTypeFlow createAccountTypeFlow)
    {
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.createAccountTypeFlow = createAccountTypeFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value="Gets all configured AccountTypes.",notes = "Returns list of AccountTypes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountTypes Returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Sorry, Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAll()               //Has no input parameters
    {
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);                           //Returns a list of all the accountTypes
    }

    @PostMapping("")                                                                    //Gets received from the RequestMapping above
    @ApiOperation(value = "Creates a new AccountType.", notes = "Creates a new AccountType in the DataBase.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "AccountType was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Sorry, Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> create(
            @ApiParam(value = "Request body to create new AcountType.", required = true)
            @RequestBody AccountTypeDto accountType)                                    //Need to request the body (input) to be displayed
    {
        AccountTypeDto accountTypeResponse = createAccountTypeFlow.create(accountType);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("{mnemonic}")                                                           //Making use of a path variable
    @ApiOperation(value = "Fetches the specified AccountType.", notes = "Fetches the new AccountType corresponding to the given mnemonic.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goal Found"),
            @ApiResponse(code = 400, message = "Sorry, Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource NOT FOUND", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> getAccountType(
            @ApiParam(value = "The mnemnonic that uniquely idendtifies the AccountType.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic)                            //Typically a mandatory PathVariable
    {
        AccountTypeDto accountType = fetchAccountTypeFlow.getAccountTypeByMnemonic(mnemonic);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountType);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

 /*   @DeleteMapping("{mnemonic}")
    @ApiOperation(value = "Deletes the specified AccountType.", notes = "Deletes the AccountType corresponding to the given mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountType deleted"),
            @ApiResponse(code = 400, message = "Sorry, Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "The Resource is NOT FOUND", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> deleteAccountType(
            @ApiParam(value = "The mnemnonic that uniquely idendtifies the AccountType.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic)
    {
        AccountTypeDto accountType = modifyAccountTypeFlow.deleteAcountType(mnemonic);      //Todo need to create modifyAccountTypeFlow
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountType);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }*/


}
