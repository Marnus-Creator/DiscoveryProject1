package za.ac.nwu.ac.web.sb.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.ModifyAccountTypeFlow;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("account-type")                                                         //There can only be one post, in this case the mapping is for account-type
public class AccountTypeController {

    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;
    private final ModifyAccountTypeFlow modifyAccountTypeFlow;

    @Autowired
    public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow,
                                 @Qualifier("createAccountTypeFlowName") CreateAccountTypeFlow createAccountTypeFlow,
                                 ModifyAccountTypeFlow modifyAccountTypeFlow)
    {
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.createAccountTypeFlow = createAccountTypeFlow;
        this.modifyAccountTypeFlow = modifyAccountTypeFlow;
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
            @ApiParam(value = "Request body to create new AccountType.", required = true)
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
            @ApiResponse(code = 404, message = "Resource is NOT FOUND", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> getAccountType(
            @ApiParam(value = "The mnemonic that uniquely identifies the AccountType.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic)                            //Typically a mandatory, PathVariable is needed
    {
        AccountTypeDto accountType = fetchAccountTypeFlow.getAccountTypeByMnemonic(mnemonic);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountType);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("{mnemonic}")
    @ApiOperation(value = "Deletes the specified AccountType.", notes = "Deletes the AccountType corresponding to the given mnemonic.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountType deleted"),
            @ApiResponse(code = 400, message = "Sorry, Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "The Resource is NOT FOUND", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> deleteAccountType(
            @ApiParam(value = "The mnemnonic that uniquely identifies the AccountType.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic)
    {
        AccountTypeDto accountType = modifyAccountTypeFlow.deleteAcountType(mnemonic);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountType);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("{mnemonic}")
    @ApiOperation(value = "Updates the specified AccountType.", notes = "Updates the new AccountType corresponding to the given mnemonic.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountType Updated"),
            @ApiResponse(code = 400, message = "Sorry, Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource is NOT FOUND", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> updateAccountType(
            @ApiParam(value = "The mnemonic that uniquely identifies the AccountType.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic,                     //Typically a mandatory PathVariable is needed

            @ApiParam(value = "The new AccountTypeName that the specified AccountType should update with.",
                    name = "newAccountTypeName",
                    required = true)
            @RequestParam(value = "newAccountTypeName") final String newAccountTypeName,

            @ApiParam(value = "The optional new date with which to update the CreationDate in ISO date format (yyyy-MM-dd)")
            @RequestParam(value = "newCreationDate", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate newCreationDate)
    {
        //AccountTypeDto accountType = modifyAccountTypeFlow.updateAccountType(mnemonic,newAccountTypeName, newCreationDate);

        AccountTypeDto tempAccTpeDto= fetchAccountTypeFlow.getAccountTypeByMnemonic(mnemonic);
        if(null == newCreationDate)
        {
            newCreationDate = tempAccTpeDto.getCreationDate();              //Set the creation date to today's date if none is provided
        }
        AccountTypeDto accountType = new AccountTypeDto(mnemonic, newAccountTypeName, newCreationDate);
        AccountTypeDto accountTypeResponse = modifyAccountTypeFlow.updateAccountType(accountType);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountType);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


}
