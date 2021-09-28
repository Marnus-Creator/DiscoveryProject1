package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTypeFlowImplTest {

    @Mock                                           //Say that all are Mocks
    private AccountTypeTranslator translator;

    @InjectMocks                                    //Injects all Mocks
    private CreateAccountTypeFlowImpl flow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test                                                                            //Method for what exactly you want to test (Go create own test)
    public void create() {
        when(translator.create(any(AccountTypeDto.class))).thenReturn(null);         //When we go call create in the translator, for anything of this type (AccountTypeDto) then return null
        //when(translator.create(any(AccountTypeDto.class))).then(returnsFirstArg());    //Return the first Argument
        AccountTypeDto result = flow.create(new AccountTypeDto());
        assertNull(result);
        //assertEquals(LocalDate.now(), result.getCreationDate());                      //Check if it was created today
        verify(translator, times(1)).create(any(AccountTypeDto.class));
    }
}