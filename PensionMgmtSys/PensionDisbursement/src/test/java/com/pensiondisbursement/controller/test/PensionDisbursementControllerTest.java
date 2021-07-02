package com.pensiondisbursement.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

 

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.pensionmanagement.pensiondisbursement.clients.PensionerDetailClient;
import com.pensionmanagement.pensiondisbursement.controller.PensionDisbursementController;
import com.pensionmanagement.common.exception.PensionerDetailsException;
import com.pensionmanagement.common.exception.TokenException;
import com.pensionmanagement.pensiondisbursement.model.ProcessPensionInput;
import com.pensionmanagement.pensiondisbursement.model.ProcessPensionResponse;
import com.pensionmanagement.pensiondisbursement.service.PensionDisbursementServiceImpl;

 

@ExtendWith(MockitoExtension.class)
@ContextConfiguration
class PensionDisbursementControllerTest {

 

    @InjectMocks
    private PensionDisbursementController pensionDisbursementController;
    @Mock
    private PensionDisbursementServiceImpl pensionDisbursementService;
    @Mock
    private PensionerDetailClient pensionerDetailClient;
    

    @Test
    public void shouldGetPensionDisbursementSuccess() throws  TokenException, PensionerDetailsException {
        String token = "dummyToken";
        ProcessPensionResponse processPensionResponse=new ProcessPensionResponse(10);
        ProcessPensionInput ppi = new ProcessPensionInput(123456789012L, 21950.0, 550.0);
        Mockito.when(pensionDisbursementService.checkBankServiceChargeAndPension(token, ppi)).thenReturn(processPensionResponse);
        assertEquals(pensionDisbursementController.getPensionDisbursement(token, ppi), processPensionResponse);
    
    }
    
 
    @Test
    public void shouldGetPensionDisbursementUnkownError() throws  TokenException, PensionerDetailsException {
        String token = "dummyToken";
        ProcessPensionResponse processPensionResponse=new ProcessPensionResponse(21);

 

        ProcessPensionInput ppi3 = new ProcessPensionInput(123456789012L, 21950.0, 500.0);
        Mockito.when(pensionDisbursementService.checkBankServiceChargeAndPension(token, ppi3)).thenReturn(processPensionResponse);
        assertEquals(pensionDisbursementController.getPensionDisbursement(token, ppi3), processPensionResponse);
    }
}