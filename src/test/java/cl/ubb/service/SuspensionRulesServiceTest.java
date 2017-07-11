package cl.ubb.service;

import cl.ubb.dao.SuspensionRulesDao;
import cl.ubb.model.SuspensionRules;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Felipe Cifuentes on 11-07-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class SuspensionRulesServiceTest {

    private SuspensionRules suspensionRules1,suspensionRules2;
    List<SuspensionRules> suspensionsRules;

    @Mock
    SuspensionRulesDao suspensionRulesDao;
    @InjectMocks
    SuspensionRulesService suspensionRulesService;
    @Before
    public void setUp() throws Exception {

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

}