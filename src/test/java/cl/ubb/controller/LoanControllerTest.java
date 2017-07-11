package cl.ubb.controller;

import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.Loan;
import cl.ubb.service.LoanService;
import cl.ubb.service.exceptions.EmptyListException;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static com.jayway.restassured.http.ContentType.JSON;
import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static javax.servlet.http.HttpServletResponse.SC_CONFLICT;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

/**
 * Created by Felipe Cifuentes on 10-07-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoanControllerTest {
    private Loan loan1, loan2;
    private List <Loan> loans;

    @Mock
    private LoanService loanService;

    @InjectMocks
    private LoanController loanController;

    @Before
    public void setUp()throws Exception{
        loan1 = new Loan();
        loan2 = new Loan();

        loan1.setIdentifier("1");
        loan1.setRutBorrower("18431717-6");
        loan1.setStartDate("10-06-2017");
        loan1.setReturnDate("20-06-2017");
        loan1.setEndDate("19-06-2017");

        loan2.setIdentifier("2");
        loan2.setRutBorrower("18430030-3");
        loan2.setStartDate("15-06-2017");
        loan2.setReturnDate("30-06-2017");
        loan2.setEndDate("16-06-2017");

        loans = new LinkedList<>();

        loans.add(loan1);
        loans.add(loan2);

        RestAssuredMockMvc.standaloneSetup(loanController);
    }


    @Test
    public void testGetLoanById() throws ReadErrorException {
        when(loanService.get(anyString())).thenReturn(loan1);
        given().
                when().
                get("/loan/{id}", 1).
                then().
                assertThat().
                body("identifier", equalTo(loan1.getIdentifier())).
                statusCode(SC_OK);
    }
    @Test
    public void testGetLoanByIdNotExist() throws ReadErrorException {
        doThrow(new ReadErrorException("")).when(loanService).get(anyString());
        given().
                contentType(JSON).
                when().
                get("/loan/{id}", 1).
                then().
                statusCode(SC_NOT_FOUND);
    }

    @Test
    public void testGetAllLoansWhenEmptyListException() throws EmptyListException {
        doThrow(new EmptyListException("")).when(loanService).getAll();
        given().
                contentType(JSON).
                when().
                get("/loan/list").
                then().
                statusCode(SC_NOT_FOUND);
    }

    @Test
    public void testCreateLoan() throws CreateException {
        given().
                contentType(JSON).
                body(loan1).
                when().
                post("/loan/create").
                then().
                assertThat().
                statusCode(SC_CREATED);

        Mockito.verify(loanService).create(loan1);
    }

    @Test
    public void testFailCreateLoan() throws CreateException {
        doThrow(new CreateException("")).when(loanService).create(loan1);
        given().
                contentType(JSON).
                body(loan1).
                when().
                post("/loan/create").
                then().
                statusCode(SC_CONFLICT);
    }


}