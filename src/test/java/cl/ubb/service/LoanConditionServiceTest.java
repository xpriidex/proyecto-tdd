package cl.ubb.service;

import cl.ubb.dao.LoanConditionDao;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.dao.exceptions.UpdateException;
import cl.ubb.model.LoanCondition;
import cl.ubb.model.UnitOfTime;
import cl.ubb.service.exceptions.EmptyListException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Felipe on 7/12/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoanConditionServiceTest {

    private LoanCondition loanCondition1,loanCondition2;
    private UnitOfTime unitOfTime1, unitOfTime2;
    private UnitOfTime unitOfTime;

    private List<LoanCondition> loanConditionList;


    @Mock
    private LoanConditionDao loanConditionDao;

    @InjectMocks
    private LoanConditionService loanConditionService;


    @Before
    public void setUp() throws Exception {
        loanConditionList = new LinkedList<>();

        loanCondition1 = new LoanCondition();
        loanCondition2 = new LoanCondition();
        unitOfTime1 = new UnitOfTime();
        unitOfTime2 = new UnitOfTime();

        loanCondition1.setIdentifier("12456");
        loanCondition1.setMaxNumberOfUnitOfTime(5);
        loanCondition1.setMaxNumberOfRenewals(2);
        loanCondition1.setUnitOfTime(unitOfTime1);
        loanCondition1.setFee("2000");
        loanCondition1.setIdBorrowerCategory("1111111-1");
        loanCondition1.setIdTitleCategory("1247");

        loanCondition1.setIdentifier("77596");
        loanCondition1.setMaxNumberOfUnitOfTime(4);
        loanCondition1.setMaxNumberOfRenewals(3);
        loanCondition1.setUnitOfTime(unitOfTime2);
        loanCondition1.setFee("1500");
        loanCondition1.setIdBorrowerCategory("2222222-2");
        loanCondition1.setIdTitleCategory("7521");

        loanConditionList.add(loanCondition1);
        loanConditionList.add(loanCondition2);

    }


    @Test
    public void checkGetAllLoanCondition() throws Exception {
        when(loanConditionDao.getAll()).thenReturn(loanConditionList);
        Assert.assertEquals(loanConditionService.getAll(),loanConditionList);
    }

    @Test(expected = EmptyListException.class)
    public void checkGetAllWhenNotExistLoanCondition() throws Exception, ReadErrorException {
        List<LoanCondition> loanConditions2=new LinkedList<>();
        when(loanConditionDao.getAll()).thenReturn(loanConditions2);
        loanConditionService.getAll();
    }

    @Test
    public void checkGetLoanCondition() throws Exception, ReadErrorException {
        when(loanConditionDao.exist(loanCondition1.getIdentifier())).thenReturn(true);
        when(loanConditionService.get(loanCondition1.getIdentifier())).thenReturn(loanCondition1);

        LoanCondition result = loanConditionService.get(loanCondition1.getIdentifier());

        Assert.assertEquals(loanCondition1,result);
    }
    @Test(expected = ReadErrorException.class)
    public void checkGetInvalidLoanCondition() throws Exception, ReadErrorException {
        when(loanConditionDao.exist(loanCondition1.getIdentifier())).thenReturn(false);
        loanConditionService.get(loanCondition1.getIdentifier());
    }

    @Test
    public void checkCreateNewLoanCondition() throws Exception {
        when(loanConditionDao.exist(loanCondition1.getIdentifier())).thenReturn(false);

        loanConditionService.create(loanCondition1);
        verify(loanConditionDao).create(loanCondition1);
    }

    @Test (expected = CreateException.class)
    public void checkCreateNewLoanConditionWhenAlreadyExists() throws Exception {
        when(loanConditionDao.exist(loanCondition1.getIdentifier()))
                .thenReturn(true);

        loanConditionService.create(loanCondition1);
    }

    @Test
    public void checkUpdateLoanCondition() throws Exception, ReadErrorException {
        LoanCondition loanConditionToUpdate = new LoanCondition();
        loanConditionToUpdate = loanCondition1;
        loanConditionToUpdate.setFee("2000");

        when(loanConditionDao.exist(loanCondition1.getIdentifier())).thenReturn(true);
        when(loanConditionService.get(loanCondition1.getIdentifier())).thenReturn(loanCondition1);

        LoanCondition result = loanConditionService.update(loanConditionToUpdate);

        verify(loanConditionDao).update(loanCondition1);

        Assert.assertEquals("2000",result.getFee());
    }

    @Test(expected = UpdateException.class)
    public void checkUpdateWhenLoanConditionNotExist() throws Exception, ReadErrorException {
        Mockito.when(loanConditionDao.exist(loanCondition1.getIdentifier())).thenReturn(false);
        loanConditionService.update(loanCondition1);
    }

}