package cl.ubb.controller;

import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.BorrowerCategory;
import cl.ubb.service.BorrowerCategoryService;
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
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

/**
 * Created by Felipe Cifuentes on 05-07-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class BorrowerCategoryControllerTest {
    private BorrowerCategory borrowerCategory1, borrowerCategory2;
    private List<BorrowerCategory> borrowerCategories;

    @Mock
    private BorrowerCategoryService borrowerCategoryService;

    @InjectMocks
    private BorrowerCategoryController borrowerCategoryController;

    @Before
    public void setUp()throws Exception{
        borrowerCategory1 = new BorrowerCategory();
        borrowerCategory2 = new BorrowerCategory();

        borrowerCategory1.setIdentifier("111");
        borrowerCategory1.setName("category1");
        borrowerCategory1.setMaxNumberOfLoans(1);

        borrowerCategory2.setIdentifier("222");
        borrowerCategory2.setName("category2");
        borrowerCategory2.setMaxNumberOfLoans(2);

        borrowerCategories = new LinkedList<>();

        borrowerCategories.add(borrowerCategory1);
        borrowerCategories.add(borrowerCategory2);

        RestAssuredMockMvc.standaloneSetup(borrowerCategoryController);

    }

    @Test
    public void testGetBorrowerCategoryById() throws ReadErrorException {
        when(borrowerCategoryService.get("111")).thenReturn(borrowerCategory1);
        given().
                contentType(JSON).
                when().
                get("/borrowerCategory/{id}", 111).
                then().
                assertThat().
                body("identifier", equalTo(borrowerCategory1.getIdentifier())).
                statusCode(SC_OK);

        Mockito.verify(borrowerCategoryService).get("111");

    }

    @Test
    public void testGetBorrowerCategoryByIdNotExist() throws ReadErrorException {
        doThrow(new ReadErrorException("")).when(borrowerCategoryService).get(anyString());
        given().
                contentType(JSON).
                when().
                get("/borrowerCategory/{id}", 1).
                then().
                statusCode(SC_NOT_FOUND);
    }

    @Test
    public void testBorrowerGetAll() throws EmptyListException {
        when(borrowerCategoryService.getAll()).thenReturn(borrowerCategories);
        given().
                when().
                get("/borrowerCategory/list").
                then().
                assertThat().
                body("identifier[0]", equalTo(borrowerCategory1.getIdentifier())).
                statusCode(SC_OK);
    }

    @Test
    public void testGetAllBorrowerCategoryWhenEmptyListException() throws EmptyListException {
        doThrow(new EmptyListException("")).when(borrowerCategoryService).getAll();
        given().
                contentType(JSON).
                when().
                get("/borrowerCategory/list").
                then().
                statusCode(SC_NOT_FOUND);
    }

    @Test
    public void testCreateBorrowerCategory() throws CreateException {
        given().
                contentType(JSON).
                body(borrowerCategory1).
                when().
                post("/borrowerCategory/create").
                then().
                assertThat().
                statusCode(SC_CREATED);

        Mockito.verify(borrowerCategoryService).create(borrowerCategory1);
    }

    @Test
    public void testCreateBorrowerCategoryWhenAlreadyExist() throws CreateException {
        doThrow(new CreateException("")).when(borrowerCategoryService).create(borrowerCategory1);
        given().
                contentType(JSON).
                body(borrowerCategory1).
                when().
                post("/borrowerCategory/create").
                then().
                statusCode(SC_CONFLICT);
    }
}