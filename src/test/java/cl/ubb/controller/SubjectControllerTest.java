package cl.ubb.controller;

import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.Subject;
import cl.ubb.service.SubjectService;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;


/**
 * Created by Felipe Cifuentes on 12-06-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class SubjectControllerTest {

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

        RestAssuredMockMvc.standaloneSetup(subjectController);
    }


    @Test
    public void testGetSubjectById() throws ReadErrorException {
        when(subjectService.get("1")).thenReturn(subject1);
        given().
        when().
                get("/subject/{id}",1).
        then().
                assertThat().
                body("identifier",equalTo("1001")).
                statusCode(SC_OK);
    }




}