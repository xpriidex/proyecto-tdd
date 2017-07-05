package cl.ubb.controller;

import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.Borrower;
import cl.ubb.model.BorrowerCategory;
import cl.ubb.model.Suspension;
import cl.ubb.service.BorrowerService;
import cl.ubb.service.exceptions.EmptyListException;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;

import static com.jayway.restassured.http.ContentType.JSON;
import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

/**
 * Created by Felipe on 6/19/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class BorrowerControllerTest {
    private LinkedList<Borrower> borrowers ;
    private Borrower borrower1,borrower2,borrower3;
    private Suspension suspension1,suspension2;
    private BorrowerCategory borrowerCategory;

    @Mock
    private BorrowerService borrowerService;

    @InjectMocks
    private BorrowerController borrowerController;


    @Before
    public void setUp() throws Exception {
        borrowerCategory = new BorrowerCategory();
        borrowerCategory.setIdentifier("1");
        borrowerCategory.setMaxNumberOfLoans(2);
        borrowerCategory.setName("postgrado");

        borrower1 = new Borrower();
        borrower1.setRut("1111111-1");
        borrower1.setName("Andres Perez");
        borrower1.setBorrowerCategory(borrowerCategory);
        borrower1.setCellPhone("911");
        borrower1.setEmail("algo@algo.com");


        borrower2 = new Borrower();
        borrower2.setRut("2222222-2");
        borrower2.setName("Cristian Galvez");

        borrower3 = new Borrower();
        borrower3.setRut("3333333-3");
        borrower3.setName("Carlos Casales");

        borrowers = new LinkedList<>();
        borrowers.add(borrower1);
        borrowers.add(borrower2);
        borrowers.add(borrower3);

        suspension1 = new Suspension();
        suspension1.setIdentifier("1");
        suspension1.setUnitOfTime("Days");
        suspension1.setNumberOfUnitOfTime("15");
        suspension1.setStarDate("21-03-2017");

        suspension2 = new Suspension();

        suspension2.setIdentifier("2");
        suspension2.setUnitOfTime("Days");
        suspension2.setNumberOfUnitOfTime("15");
        suspension2.setStarDate("15-05-2017");

        RestAssuredMockMvc.standaloneSetup(borrowerController);
    }

    @Test
    public void testGetBorrowerById()throws ReadErrorException{
        when(borrowerService.get(anyString())).thenReturn(borrower2);
        given().
                when().
                get("/borrower/{id}",borrower2.getRut()).
                then().
                assertThat().
                body("rut",equalTo(borrower2.getRut())).
                statusCode(SC_OK);
    }
    @Test
    public void testGetBorrowerByIdNotExist() throws ReadErrorException {
        doThrow(new ReadErrorException("")).when(borrowerService).get(anyString());
        given().
                contentType(JSON).
                when().
                get("/borrower/{id}",1).
                then().
                statusCode(SC_NOT_FOUND);
    }

    @Test
    public void testGetAllBorrower() throws EmptyListException {
        when(borrowerService.getAll()).thenReturn(borrowers);
        given().
                when().
                get("/borrower/").
                then().
                assertThat().
                body("rut[0]",equalTo(borrower1.getRut())).
                statusCode(SC_OK);
    }

    @Test
    public void testGetAllBorrowerWhenEmptyListException() throws EmptyListException {
        doThrow(new EmptyListException("")).when(borrowerService).getAll();
        given().
                contentType(JSON).
                when().
                get("/borrower/").
                then().
                statusCode(SC_NOT_FOUND);
    }
    @Test
    public void testCreateBorrower(){
        given().
                contentType(JSON).
                body(borrower1).
                when().
                post("/borrower/").
                then().
                assertThat().
                body("rut",equalTo(borrower1.getRut())).
                statusCode(SC_CREATED);
    }

    // TODO: 6/28/2017 falta probar test desfavorable 

}