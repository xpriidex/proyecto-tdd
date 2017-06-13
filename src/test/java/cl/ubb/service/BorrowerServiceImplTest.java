package cl.ubb.service;

import cl.ubb.dao.BorrowerDao;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.model.Borrower;
import cl.ubb.model.Suspension;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Felipe Cifuentes on 24-05-2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class BorrowerServiceImplTest {
    private LinkedList<Borrower> resp;
    private LinkedList<Borrower> borrowers ;
    private Borrower borrower1,borrower2,borrower3;
    private Suspension suspension1,suspension2;

    @Mock
    private BorrowerDao borrowerDao;
    @Mock
    private SuspensionService suspensionService;
    @Mock
    private Calendar calendar;

    @InjectMocks
    private BorrowerService borrowerService;

    @Before
    public void setUp() throws Exception {

        borrower1 = new Borrower("2.222.222-2","ass","998","aasss@a");
        borrower2 = new Borrower("3.333.333-3","asd","999","aawws@a");
        borrower3 = new Borrower("31","add","991","sas@a");

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


    }

    @Test
    public void whenExistThreeBorrowesGetAllReturnThreeElementsInAList(){

        when(borrowerDao.getAll()).thenReturn(borrowers);
        resp=(LinkedList<Borrower>)borrowerService.getAll();
        assertEquals(3,resp.size());
    }

    @Test
    public void WhenNotBorrowerExistGetAllShoultReturnEmptyList(){
        LinkedList<Borrower> result;
        LinkedList<Borrower> borrowers = new LinkedList<>();
        when(borrowerDao.getAll()).thenReturn(borrowers);
        result=(LinkedList<Borrower>)borrowerService.getAll();
        assertEquals(0,result.size());

    }

    @Test
    public void whenVerifyCanBarrowerByRutReturnTrueBecauseNotHaveSuspension(){
        Boolean resp;
        resp = borrowerService.canBorrow(borrower1.getRut(),"17-03-2017");
        assertEquals(true,resp);
    }

    @Test
    public void whenVerifyCanBarrowerByRutReturnFalseBecauseHaveSuspension(){
        calendar.set(2017,03,17);
        LinkedList <Suspension> suspensions = new LinkedList<>();
        suspensions.add(suspension1);
        when(suspensionService.getAllSuspensionByRut(borrower1.getRut())).thenReturn(suspensions);
        Boolean resp;

        resp = borrowerService.canBorrow(borrower1.getRut(),"17-03-2017");

        assertEquals(false,resp);
    }
    @Test
    public void whenVerifyCanBarrowerByRutReturnTrueBecauseNotHaveAListSuspension(){
        LinkedList <Suspension> suspensions = new LinkedList<>();
        when(suspensionService.getAllSuspensionByRut(borrower2.getRut())).thenReturn(suspensions);
        Boolean resp;

        resp = borrowerService.canBorrow(borrower2.getRut(),"17-03-2017");

        assertEquals(true,resp);
    }

    @Test
    public void whenVerifyCanBarrowerDateIsTheSameDayThatTheTermOfTheSuspensionThenReturnsFalse(){
        calendar.set(2017,04,05);

        LinkedList <Suspension> suspensions = new LinkedList<>();
        suspensions.add(suspension1);
        when(suspensionService.getAllSuspensionByRut(borrower2.getRut())).thenReturn(suspensions);
        Boolean resp;

        resp = borrowerService.canBorrow(borrower2.getRut(),"05-04-2017");

        assertEquals(false,resp);
    }
    @Test
    public void VerifyCurrentDateOutsidePenaltyPeriodReturnsTrue(){
        LinkedList <Suspension> suspensions = new LinkedList<>();
        suspensions.add(suspension1);
        when(suspensionService.getAllSuspensionByRut(borrower2.getRut())).thenReturn(suspensions);
        Boolean resp;
        resp = borrowerService.canBorrow(borrower2.getRut(),suspension1.getStarDate());

        assertEquals(true,resp);

    }

    @Test
    public void whenVerifyCurrentDateWithinPenaltyPeriodReturnsFalse(){
        calendar.set(2017,04,1);
        LinkedList <Suspension> suspensions = new LinkedList<>();
        suspensions.add(suspension2);
        when(suspensionService.getAllSuspensionByRut(borrower2.getRut())).thenReturn(suspensions);
        Boolean resp;
        resp = borrowerService.canBorrow(borrower2.getRut(),"21-03-2017");

        assertEquals(false,resp);

    }

    @Test
    public void checkCreateNewBorrower() throws Exception {
        borrowerService.create(borrower1);
        verify(borrowerDao).create(borrower1);
    }

    @Test(expected = CreateException.class)
    public void checkCreateNewBorrowerWhenAlreadyExists() throws Exception {
        when(borrowerDao.exist(borrower1.getRut())).thenReturn(true);
        borrowerService.create(borrower1);
    }

}