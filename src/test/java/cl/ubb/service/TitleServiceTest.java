package cl.ubb.service;

import cl.ubb.model.Subject;
import cl.ubb.model.Title;
import org.junit.Before;

/**
 * Created by Felipe on 5/29/2017.
 */
public class TitleServiceTest {
    private Subject subject1,subject2;
    private Title title1, title2, title3;
    @Before
    public void setUp() throws Exception {
        subject1 = new Subject();
        subject2 = new Subject();
        
        title1 = new Title();
        title2 = new Title();
    
        subject1.setIdentifier("1001");
        subject1.setName("Robin Hood");
        subject2.setIdentifier("2001");
        subject2.setName("Nutricion");
        
        title1.setIdentifier("1001");
        // TODO: 5/29/2017 aca quedamos 
        
    }
    
    

}