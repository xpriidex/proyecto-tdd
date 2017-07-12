package cl.ubb.service;

import cl.ubb.dao.SuspensionRulesDao;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.SuspensionRules;
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

/**
 * Created by Felipe Cifuentes on 11-07-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class SuspensionRulesServiceTest {

    private SuspensionRules suspensionRules1, suspensionRules2;
    List<SuspensionRules> suspensionsRules;

    @Mock
    SuspensionRulesDao suspensionRulesDao;
    @InjectMocks
    SuspensionRulesService suspensionRulesService;

    @Before
    public void setUp() throws Exception {
        suspensionRules1 = new SuspensionRules();
        suspensionRules2 = new SuspensionRules();


        suspensionRules1.setDelayUnitOfTime("3");
        suspensionRules1.setSuspensionUnitOfTime("dias");
        suspensionRules1.setUnitOfTime("10");

        suspensionRules2.setDelayUnitOfTime("10");
        suspensionRules2.setSuspensionUnitOfTime("meses");
        suspensionRules2.setUnitOfTime("1");

        suspensionsRules = new LinkedList<>();
        suspensionsRules.add(suspensionRules1);
        suspensionsRules.add(suspensionRules2);


    }

    @Test
    public void checkGetBySuspensionRules() throws ReadErrorException {
        Mockito.when(suspensionRulesDao.exist(suspensionRules1.getIdentifier())).thenReturn(true);
        Mockito.when(suspensionRulesService.get(suspensionRules1.getIdentifier())).thenReturn(suspensionRules1);

        SuspensionRules result = suspensionRulesDao.get(suspensionRules1.getIdentifier());

        Assert.assertEquals(suspensionRules1, result);
    }

    @Test(expected = ReadErrorException.class)
    public void checkGetSuspensionRules() throws Exception, ReadErrorException {
        Mockito.when(suspensionRulesDao.exist(suspensionRules1.getIdentifier())).thenReturn(false);
        suspensionRulesService.get(suspensionRules1.getIdentifier());
    }

}