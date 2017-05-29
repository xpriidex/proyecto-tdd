package cl.ubb.service.impl;

import cl.ubb.dao.daoImpl.BorrowerDaoImpl;
import cl.ubb.model.Borrower;
import cl.ubb.service.BorrowerService;
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

    @Mock
    private BorrowerDaoImpl borrowerDao;

    @InjectMocks
    private BorrowerService borrowerService;

    @Test
    public void whenExistThreeBorrowesGetAllReturnThreeElementsInAList(){
        LinkedList<Borrower> resp;
        LinkedList<Borrower> borrowers = new LinkedList<>();
        borrowers.add(new Borrower("11","ass","998","aasss@a"));
        borrowers.add(new Borrower("21","asd","999","aawws@a"));
        borrowers.add(new Borrower("31","add","991","sas@a"));

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
}