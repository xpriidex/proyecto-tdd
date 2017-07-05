package cl.ubb.controller;

import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.Subject;
import cl.ubb.service.SubjectService;
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
 * Created by Felipe Cifuentes on 12-06-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class SubjectControllerTest {

    private List<Subject> subjects;

    private Subject subject1,subject2,subject3,subject4,subject5;

    @Mock
    private SubjectService subjectService;

    @InjectMocks
    private SubjectController subjectController;

    @Before
    public void setUp() throws Exception {
        subject1 = new Subject();
        subject2 = new Subject();
        subject3 = new Subject();
        subject4 = new Subject();
        subject5 = new Subject();

        subjects = new LinkedList<>();

        subject1.setIdentifier("1001");
        subject1.setName("Robin Hood");
        subject2.setIdentifier("2001");
        subject2.setName("Nutrición");
        subject3.setIdentifier("1003");
        subject3.setName("Rimas y Leyendas");
        subject4.setIdentifier("101");
        subject4.setName("Literatura Del Siglo XIX");
        subject5.setIdentifier("202");
        subject5.setName("Ingenieria De Software");

        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);
        subjects.add(subject4);
        subjects.add(subject5);

        RestAssuredMockMvc.standaloneSetup(subjectController);

    }


    @Test
    public void testGetSubjectById() throws ReadErrorException {
        when(subjectService.get(anyString())).thenReturn(subject1);
        given().
        when().
                get("/subject/{id}",1).
        then().
                assertThat().
                body("identifier",equalTo("1001")).
                statusCode(SC_OK);
    }
    @Test
    public void testGetSubjectByIdNotExist() throws ReadErrorException {
        doThrow(new ReadErrorException("")).when(subjectService).get(anyString());
        given().
                contentType(JSON).
                when().
                get("/subject/{id}",1).
                then().
                statusCode(SC_NOT_FOUND);
    }

    @Test
    public void testGetAll() throws EmptyListException {
         when(subjectService.getAll()).thenReturn((LinkedList<Subject>) subjects);
         given().
                 when().
                 get("/subject/list").
                 then().
                 assertThat().
                 body("identifier[0]",equalTo("1001")).
                 statusCode(SC_OK);
    }

    @Test
    public void testGetAllSubjectWhenEmptyListException() throws EmptyListException {
        doThrow(new EmptyListException("")).when(subjectService).getAll();
        given().
                contentType(JSON).
                when().
                get("/subject").
                then().
                statusCode(SC_NOT_FOUND);
    }


    @Test
    public void testCreateSubject() throws CreateException {
        given().
                contentType(JSON).
                body(subject1).
                when().
                post("/subject/create").
                then().
                assertThat().
                body("identifier",equalTo(subject1.getIdentifier())).
                statusCode(SC_CREATED);

        Mockito.verify(subjectService).create(subject1);
    }

    @Test
    public void testFailCreateSubject() throws CreateException {
        doThrow(new CreateException("")).when(subjectService).create(subject1);
        given().
                contentType(JSON).
                body(subject1).
                when().
                post("/subject/create").
                then().
                statusCode(SC_CONFLICT);
    }




}