package cl.ubb.service;

import cl.ubb.dao.BorrowerDao;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.*;
import cl.ubb.service.exceptions.EmptyListException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
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
    private BorrowerCategory borrowerCategory;
    private LoanCondition loanCondition1;
    private LoanCondition loanCondition2;
    private List<LoanCondition> loanConditions;
    private UnitOfTime unitOfTime;

    @Mock
    private BorrowerCategoryService borrowerCategoryService;

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
        unitOfTime =  new UnitOfTime();
        unitOfTime.setIdentifier("1");
        unitOfTime.setName("Days");


        loanConditions =  new ArrayList<>();
        loanCondition1 = new LoanCondition();
        loanCondition1.setFee("1000");
        loanCondition1.setMaxNumberOfRenewals(1);
        loanCondition1.setMaxNumberOfUnitOfTime(1);
        loanCondition1.setUnitOfTime(unitOfTime);
        loanCondition2 = new LoanCondition();

        loanConditions.add(loanCondition1);
        loanConditions.add(loanCondition2);

        borrowerCategory = new BorrowerCategory();
        borrowerCategory.setIdentifier("1");
        borrowerCategory.setMaxNumberOfLoans(2);
        borrowerCategory.setName("postgrado");

        borrower1 = new Borrower();
        borrower1.setRut("1111111-1");
        borrower1.setName("Andres Perez");
        borrower1.setIdBorrowerCategory("1");
        borrower1.setCellPhone("911");
        borrower1.setEmail("algo@algo.com");


        borrower2 = new Borrower();
        borrower2.setRut("2222222-2");
        borrower2.setName("Cristian Galvez");

        borrower3 = new Borrower();
        borrower3.setRut("3333333-3");
        borrower3.setName("Carlos Casales");

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
    public void whenExistThreeBorrowesGetAllReturnThreeElementsInAList() throws EmptyListException {

        when(borrowerDao.getAll()).thenReturn(borrowers);
        resp=(LinkedList<Borrower>)borrowerService.getAll();
        assertEquals(3,resp.size());
    }

    @Test(expected = EmptyListException.class)
    public void WhenNotBorrowerExistGetAllShoultReturnEmptyList() throws EmptyListException {
        LinkedList<Borrower> output = new LinkedList<>();
        LinkedList<Borrower> result;

        when(borrowerDao.getAll()).thenReturn(output);
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
    public void whenVerifyCanBarrowerByRutReturnTrueBecauseHaveSuspension(){
        calendar.set(2017,03,17);
        LinkedList <Suspension> suspensions = new LinkedList<>();
        suspensions.add(suspension1);
        when(suspensionService.getAllSuspensionByRut(borrower1.getRut())).thenReturn(suspensions);
        Boolean resp;

        resp = borrowerService.canBorrow(borrower1.getRut(),"17-03-2017");

        assertEquals(true,resp);
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
    public void whenVerifyCanBarrowerDateIsTheSameDayThatTheTermOfTheSuspensionThenReturnsTrue(){
        calendar.set(2017,04,05);

        LinkedList <Suspension> suspensions = new LinkedList<>();
        suspensions.add(suspension1);
        when(suspensionService.getAllSuspensionByRut(borrower2.getRut())).thenReturn(suspensions);
        Boolean resp;

        resp = borrowerService.canBorrow(borrower2.getRut(),"05-04-2017");

        assertEquals(true,resp);
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
    public void whenVerifyCurrentDateWithinPenaltyPeriodReturnsTrue(){
        calendar.set(2017,04,1);
        LinkedList <Suspension> suspensions = new LinkedList<>();
        suspensions.add(suspension2);
        when(suspensionService.getAllSuspensionByRut(borrower2.getRut())).thenReturn(suspensions);
        Boolean resp;
        resp = borrowerService.canBorrow(borrower2.getRut(),"21-03-2017");

        assertEquals(true,resp);

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

    @Test
    public void checkBorrowerExist() throws Exception {
        Boolean result;
        when(borrowerDao.exist(borrower1.getRut())).thenReturn(true);

        result=borrowerService.borrowerExist(borrower1.getRut());

        assertTrue(result);
    }

    @Test
    public void checkBorrowerNotExist() throws Exception {
        Boolean result;
        when(borrowerDao.exist(borrower1.getRut())).thenReturn(false);

        result=borrowerService.borrowerExist(borrower1.getRut());

        assertFalse(result);
    }

    @Test
    public void checkBorrowerCategory() throws  ReadErrorException {
        BorrowerCategory borrowerCategory1,borrowerCategory2;
        borrowerCategory1 = new BorrowerCategory();
        borrowerCategory1.setIdentifier("1");

        when(borrowerDao.exist(borrower1.getRut())).thenReturn(true);
        when(borrowerDao.get(borrower1.getRut())).thenReturn(borrower1);
        when(borrowerCategoryService.get(anyString())).thenReturn(borrowerCategory1);

        borrowerCategory2=borrowerService.getBorrowerCategory(borrower1.getRut());

        assertEquals("postgrado",borrowerCategory.getName());
    }

    @Test(expected = ReadErrorException.class)
    public void checkBorrowerCategoryNotExist() throws ReadErrorException {
        when(borrowerDao.exist(borrower1.getRut())).thenReturn(true);
        borrowerService.getBorrowerCategory(null);
    }

    @Test
    public void checkBorrowerHaveAllAtributes(){
        assertTrue(borrowerService.validateAtributes(borrower1));
    }

    @Test
    public void checkBorrowerHaveNotAllAtributes(){
        borrower1.setEmail("");
        assertFalse(borrowerService.validateAtributes(borrower1));
    }

    @Test
    public void checkGetBorrowersHaveSuspention() throws EmptyListException {
        List<Borrower> result;
        when(borrowerDao.getAll()).thenReturn(borrowers);

        result = borrowerService.getAllBorrowerSuspention();

        assertEquals(result,borrowers);
    }

    // TODO: 6/19/2017 consultar la respuest de canBorrower
    @Test
    public void checkGetBorrowersHaveNotSuspention() throws EmptyListException {
        List<Borrower> result;
        List<Borrower> list = new LinkedList<>();
        Borrower borrower6 = new Borrower();
        borrower6.setRut("18457954-7");
        list.add(borrower6);
        when(borrowerDao.getAll()).thenReturn(list);

        result = borrowerService.getAllBorrowerNotHaveSuspention();

        assertEquals(result,list);
    }

    @Test
    public void checkGetBorrower() throws ReadErrorException {
        Mockito.when(borrowerDao.exist(borrower1.getRut())).thenReturn(true);
        Mockito.when(borrowerService.get(borrower1.getRut())).thenReturn(borrower1);

        Borrower result = borrowerDao.get(borrower1.getRut());

        Assert.assertEquals(borrower1, result);
    }

    @Test(expected = ReadErrorException.class)
    public void checkGetBorrowerDontExist() throws Exception, ReadErrorException {
        Mockito.when(borrowerDao.exist(borrower1.getRut())).thenReturn(false);
        borrowerService.get(borrower1.getRut());
    }

    // TODO: 6/19/2017 cambiar a loanservice
    /*@Test
    public void checkLoanConditionUser() throws ReadErrorException, EmptyListException {
        List<LoanCondition> result;
        when(borrowerDao.exist(anyString())).thenReturn(true);
        when(borrowerDao.get(anyString())).thenReturn(borrower1);

        result = borrowerService.getLoanCondition(borrower1.getRut());

        assertEquals(result,loanConditions);

    }*/
}