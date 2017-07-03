package cl.ubb.controller;

import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.Title;
import cl.ubb.service.TitleService;
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

import java.util.LinkedList;
import java.util.List;

import static com.jayway.restassured.http.ContentType.JSON;
import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;

/**
 * Created by Felipe Cifuentes on 03-07-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class TitleControllerTest {
    private Title title1, title2;
    private List<Title> titles;

     @Mock
    TitleService titleService;
     @InjectMocks
    TitleController titleController;

     @Before
    public void setUp() throws Exception{
         title1 = new Title();
         title2 = new Title();

         title1.setIdentifier("11");
         title1.setName("Nombre1");
         title1.setYear("2016");
         title1.setFormat("PDF");
         title1.setReplacementCost("1000");

         title2.setIdentifier("22");
         title2.setName("Nombre2");
         title2.setYear("2017");
         title2.setFormat("PDF");
         title2.setReplacementCost("20000");

         titles = new LinkedList<>();

         titles.add(title1);
         titles.add(title2);

         RestAssuredMockMvc.standaloneSetup(titleController);
     }
    @Test
    public void testGetTitleById() throws ReadErrorException {
         when(titleService.get(anyString())).thenReturn(title1);
        given().
                when().
                get("/title/{id}",1).
                then().
                assertThat().
                body("identifier",equalTo(title1.getIdentifier())).
                statusCode(SC_OK);
    }
    @Test
    public void testGetTitleByIdNotExist() throws ReadErrorException {
        doThrow(new ReadErrorException("")).when(titleService).get(anyString());
        given().
                contentType(JSON).
                when().
                get("/title/{id}",1).
                then().
                statusCode(SC_NOT_FOUND);
    }
    @Test
    public void testTitleGetAll() throws EmptyListException {
        when(titleService.getAll()).thenReturn(titles);
        given().
                when().
                get("/title/list").
                then().
                assertThat().
                body("identifier[0]",equalTo(title1.getIdentifier())).
                statusCode(SC_OK);
    }
    @Test
    public void testGetAllTitlesWhenEmptyListException() throws EmptyListException {
        doThrow(new EmptyListException("")).when(titleService).getAll();
        given().
                contentType(JSON).
                when().
                get("/title/list").
                then().
                statusCode(SC_NOT_FOUND);
    }
    @Test
    public void testCreateTitle() throws CreateException {
         given().
                 contentType(JSON).
                 body(title1).
                 when().
                 post("title/create").
                 then().
                 assertThat().
                 statusCode(SC_CREATED);

         Mockito.verify(titleService).create(title1);
    }

}