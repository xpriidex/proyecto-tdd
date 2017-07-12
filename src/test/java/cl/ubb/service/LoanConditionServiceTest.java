package cl.ubb.service;

import cl.ubb.dao.LoanConditionDao;
import cl.ubb.model.Loan;
import cl.ubb.model.LoanCondition;
import cl.ubb.model.UnitOfTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Felipe on 7/12/2017.
 */
public class LoanConditionServiceTest {

    private LoanCondition loanCondition1,loanCondition2;
    private UnitOfTime unitOfTime1, unitOfTime2;
    private UnitOfTime unitOfTime;

    private List<LoanCondition> loanConditionList;


    @Mock
    private LoanConditionDao loanConditionDaoDao;

    @InjectMocks
    private LoanConditionService loanConditionServiceServiceService;


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
    public void getAll() throws Exception {
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void create() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

}