package cl.ubb.service;

import cl.ubb.dao.BorrowerDao;
import cl.ubb.model.Borrower;
import cl.ubb.model.Suspension;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Felipe Cifuentes on 24-05-2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class BorrowerServiceImplTest {
    private LinkedList<Borrower> resp;
    private LinkedList<Borrower> borrowers ;
    private Borrower borrower1,borrower2,borrower3;
    private Suspension suspension1;

    @Mock
    private BorrowerDao borrowerDao;
    @Mock
    private SuspensionService suspensionService;

    @InjectMocks
    private BorrowerService borrowerService;

    @Before
    public void setUp() throws Exception {
        borrower1 = new Borrower("2.222.222-2","ass","998","aasss@a");
        borrower2 = new Borrower("21","asd","999","aawws@a");
        borrower3 = new Borrower("31","add","991","sas@a");

        borrowers = new LinkedList<>();
        borrowers.add(borrower1);
        borrowers.add(borrower2);
        borrowers.add(borrower3);

        suspension1 = new Suspension();
        suspension1.setIdentifier("1");

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


}