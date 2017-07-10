package cl.ubb.service;

import cl.ubb.dao.LoanDao;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.model.Loan;
import cl.ubb.service.exceptions.EmptyListException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Felipe Cifuentes on 28-06-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoanServiceTest {

    @Mock
    private LoanDao loanDao;

    @InjectMocks
    private LoanService loanService;

    private Loan loan1,loan2,loan3;

    private List<Loan> loans;
    private List<Loan> noLoans;

    @Before
    public void setUp(){
        loans = new LinkedList<>();
        noLoans = new LinkedList<>();

        loan1 = new Loan();
        loan2 = new Loan();
        loan3 = new Loan();

        loan1.setIdentifier("1");
        loan2.setIdentifier("2");
        loan3.setIdentifier("3");

        loan1.setStartDate("10-05-2017");
        loan2.setStartDate("05-05-2017");
        loan3.setStartDate("11-05-2017");

        loan1.setEndDate("13-05-2017");
        loan2.setEndDate("13-05-2017");
        loan3.setEndDate("15-05-2017");

        loan1.setReturnDate("15-05-2017");
        loan2.setReturnDate("11-05-2017");
        loan3.setReturnDate("19-05-2017");

        loans.add(loan1);
        loans.add(loan2);
        loans.add(loan3);
    }

    @Test
    public void whenGetAllIsCallReturnAllTheLoans() throws EmptyListException {
        List<Loan> resp;
        when(loanDao.getAll()).thenReturn(loans);

        resp = loanService.getAll();

        assertEquals(loans, resp);
    }

    @Test(expected = EmptyListException.class)
    public void whenGetAllIsCalledAndThereNotExistReturnEmptyListException() throws EmptyListException {
        when(loanDao.getAll()).thenReturn(noLoans);

        loanService.getAll();
    }

    @Test
    public void whenGetAllLoanInAStartDateReturnThisLoan() throws EmptyListException {
        when(loanDao.getAll()).thenReturn(loans);
        List<Loan> loansFiltered = new LinkedList<>();
        loansFiltered.add(loan1);
        List<Loan> resp;

        resp = loanService.getAllLoansThatStartIn("10-05-2017");

        assertEquals(loansFiltered, resp);
    }

    @Test(expected = EmptyListException.class)
    public void whenGetAllLoansThatStartsIsNotExistReturnEmptyListException() throws EmptyListException{
        when(loanDao.getAll()).thenReturn(noLoans);

        loanService.getAllLoansThatStartIn("21-05-2017");
    }

    @Test
    public void whenGetAllLoansReturnAllLoansHasNotReturn(){
        List<Loan> delayedLoans = new LinkedList<>();

        List<Loan> resp;
        when(loanDao.getAll()).thenReturn(loans);

        resp = loanService.getAllLoansThatAreDelayed("21-05-2017");

        assertEquals(loans, resp);
    }

    @Test
    public void checkCreateNewLoan() throws Exception {
        loanService.create(loan1);
        Mockito.verify(loanDao).create(loan1);
    }

    @Test(expected = CreateException.class)
    public void checkCreateNewLoanWhenAlreadyExists() throws Exception {
        when(loanDao.exist(loan1.getIdentifier())).thenReturn(true);
        loanService.create(loan1);

    }

}