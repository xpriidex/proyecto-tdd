package cl.ubb.service;

import cl.ubb.dao.SuspensionDao;
import cl.ubb.model.Borrower;
import cl.ubb.model.Suspension;
import cl.ubb.service.exceptions.EmptyListException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Felipe on 5/31/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class SuspensionServiceTest {
    private Borrower borrower1,borrower2,borrower3;
    private Suspension suspension1,suspension2,suspension3;

    @Mock
    SuspensionDao suspensionDao;
    @InjectMocks
    SuspensionService suspensionService;

    @Before
    public void setUp() throws Exception {
        borrower1 = new Borrower("1111111-1","Andres Perez","","");
        borrower2 = new Borrower("2222222-2","Cristian Galvez","","");
        borrower3 = new Borrower("3333333-3","Carlos Casales","","");

        suspension1 = new Suspension("1","atraso","10-05-2017","5","dias",borrower1);
        suspension2 = new Suspension("2","atraso","20-05-2017","20","dias",borrower1);
        suspension3 = new Suspension("3","perdida","05-05-2017","1","año",borrower2);







    }
    @Test
    public void whenGetAllIsCalledAndThreeSuspensionExistAListWithThreeItemIsReturned() throws EmptyListException {
        List<Suspension> suspensions = new LinkedList<>();
        suspensions.add(suspension1);
        suspensions.add(suspension2);
        suspensions.add(suspension3);

        when(suspensionDao.getAll()).thenReturn(suspensions);
        List<Suspension> result ;
        result= suspensionService.getAll();

        assertEquals(3,result.size());
    }

    @Test(expected = EmptyListException.class)
    public void whenGetAllIsCalledAndNowSuspensionExistAEmptyListException() throws EmptyListException{
        List<Suspension> suspensions = new LinkedList<>();
        List<Suspension> result;

        when(suspensionDao.getAll()).thenReturn(suspensions);

        result= suspensionDao.getAll();
    }

    @Test
    public void whenGetSuspensionIdIs1ReturnSuspensionId1AndDescriptionIsAtraso(){
        Suspension result;

        when(suspensionDao.get("1")).thenReturn(suspension1);

        result = suspensionService.get("1");

        assertEquals("atraso",result.getDescription());

    }
}