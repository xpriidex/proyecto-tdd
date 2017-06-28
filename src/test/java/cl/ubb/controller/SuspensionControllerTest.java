package cl.ubb.controller;

import cl.ubb.model.Suspension;
import cl.ubb.service.SuspensionService;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Felipe on 6/28/2017.
 */
public class SuspensionControllerTest {

    @Mock
    SuspensionService suspensionService;

    @InjectMocks
    SuspensionController suspensionController;
    private Suspension suspension1,suspension2;
    private List<Suspension> suspensions;
    @Before
    public void setUp() throws Exception {

        suspension1= new Suspension();
        suspension2= new Suspension();

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


}