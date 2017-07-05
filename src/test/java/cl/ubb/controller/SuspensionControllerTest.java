package cl.ubb.controller;

import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.Suspension;
import cl.ubb.service.SuspensionService;
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
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

/**
 * Created by Felipe on 6/28/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class SuspensionControllerTest {
    private Suspension suspension1, suspension2;
    private List<Suspension> suspensions;

    @Mock
    SuspensionService suspensionService;

    @InjectMocks
    SuspensionController suspensionController;

    @Before
    public void setUp() throws Exception {

        suspension1 = new Suspension();
        suspension2 = new Suspension();

        suspension1.setIdentifier("1");
        suspension1.setDescription("algo");
        suspension1.setNumberOfUnitOfTime("1");
        suspension1.setStarDate("20-05-2017");

        suspension2.setIdentifier("2");
        suspension2.setDescription("algo2");
        suspension2.setNumberOfUnitOfTime("2");
        suspension2.setStarDate("30-05-2017");

        suspensions = new LinkedList<>();

        suspensions.add(suspension1);
        suspensions.add(suspension2);

        RestAssuredMockMvc.standaloneSetup(suspensionController);

    }

    @Test
    public void testGetSuspensionById() throws ReadErrorException {
        when(suspensionService.get(anyString())).thenReturn(suspension1);
        given().
                when().
                get("/suspension/{id}", 1).
                then().
                assertThat().
                body("identifier", equalTo(suspension1.getIdentifier())).
                statusCode(SC_OK);
    }

    @Test
    public void testGetSuspensionByIdNotExist() throws ReadErrorException {
        doThrow(new ReadErrorException("")).when(suspensionService).get(anyString());
        given().
                contentType(JSON).
                when().
                get("/suspension/{id}", 1).
                then().
                statusCode(SC_NOT_FOUND);
    }

    @Test
    public void testSuspensionGetAll() throws EmptyListException {
        when(suspensionService.getAll()).thenReturn(suspensions);
        given().
                when().
                get("/suspension/list").
                then().
                assertThat().
                body("identifier[0]", equalTo(suspension1.getIdentifier())).
                statusCode(SC_OK);
    }

    @Test
    public void testGetAllSuspensionWhenEmptyListException() throws EmptyListException {
        doThrow(new EmptyListException("")).when(suspensionService).getAll();
        given().
                contentType(JSON).
                when().
                get("/suspension/list").
                then().
                statusCode(SC_NOT_FOUND);
    }

    @Test
    public void testCreateSuspension() throws CreateException {
        given().
                contentType(JSON).
                body(suspension1).
                when().
                post("/suspension/create").
                then().
                assertThat().
                statusCode(SC_CREATED);

        Mockito.verify(suspensionService).create(suspension1);
    }

    @Test
    public void testCreateSuspensionWhenAlreadyExist() throws CreateException {
        doThrow(new CreateException("")).when(suspensionService).create(suspension1);
        given().
                contentType(JSON).
                body(suspension1).
                when().
                post("/suspension/create").
                then().
                statusCode(SC_CONFLICT);
    }

    @Test
    public void testFailCreateSuspension() throws CreateException {
        doThrow(new CreateException("")).when(suspensionService).create(suspension1);
        given().
                contentType(JSON).
                body(suspension1).
                when().
                post("/suspension/create").
                then().
                statusCode(SC_CONFLICT);
    }

}