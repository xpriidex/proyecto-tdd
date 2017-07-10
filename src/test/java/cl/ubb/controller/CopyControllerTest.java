package cl.ubb.controller;

import cl.ubb.dao.CopyDao;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.Copy;
import cl.ubb.service.CopyService;
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
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

/**
 * Created by Felipe Cifuentes on 10-07-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class CopyControllerTest {
    private Copy copy1, copy2;
    private List <Copy> copies;

    @Mock
    CopyService copyService;
    @InjectMocks
    CopyController copyController;

    @Before
    public void setUp() throws Exception {

        copy1 = new Copy();
        copy2 = new Copy();


        copy1.setIdentifier("11");
        copy1.setAcquisitionDate("09-03-2000");
        copy1.setIdTitle("2550021");

        copy2.setIdentifier("55");
        copy2.setIdentifier("22-04-2002");
        copy2.setAcquisitionDate("1892347");

        copies = new LinkedList<>();

        copies.add(copy1);
        copies.add(copy2);

        RestAssuredMockMvc.standaloneSetup(copyController);
    }

    @Test
    public void testGetCopyById() throws ReadErrorException {
        when(copyService.get("1")).thenReturn(copy1);
        given().
                contentType(JSON).
                when().
                get("/copy/{id}", "1").
                then().
                assertThat().
                body("identifier", equalTo(copy1.getIdentifier())).
                statusCode(SC_OK);
    }
    @Test
    public void testGetCopyByIdNotExist() throws ReadErrorException {
        doThrow(new ReadErrorException("")).when(copyService).get(anyString());
        given().
                contentType(JSON).
                when().
                get("/copy/{id}", 1).
                then().
                statusCode(SC_NOT_FOUND);
    }

    @Test
    public void testCopyGetAll() throws EmptyListException {
        when(copyService.getAll()).thenReturn(copies);
        given().
                when().
                get("/copy/list").
                then().
                assertThat().
                body("identifier[0]", equalTo(copy1.getIdentifier())).
                statusCode(SC_OK);
    }
    @Test
    public void testGetAllCopiesWhenEmptyListException() throws EmptyListException {
        doThrow(new EmptyListException("")).when(copyService).getAll();
        given().
                contentType(JSON).
                when().
                get("/copy/list").
                then().
                statusCode(SC_NOT_FOUND);
    }
    @Test
    public void testCreateCopy() throws CreateException {
        given().
                contentType(JSON).
                body(copy1).
                when().
                post("/copy/create").
                then().
                assertThat().
                statusCode(SC_CREATED);

        Mockito.verify(copyService).create(copy1);
    }

    @Test
    public void testFailCreateCopy() throws CreateException {
        doThrow(new CreateException("")).when(copyService).create(copy1);
        given().
                contentType(JSON).
                body(copy1).
                when().
                post("/copy/create").
                then().
                statusCode(SC_CONFLICT);
    }


}