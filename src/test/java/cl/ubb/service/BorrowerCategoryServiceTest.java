package cl.ubb.service;

import cl.ubb.dao.BorrowerCategoryDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 * Created by Felipe on 6/19/2017.
 */
public class BorrowerCategoryServiceTest {
    @Mock
    private BorrowerCategoryDao borrowerCategoryDao;

    @InjectMocks
    private BorrowerCategoryService borrowerCategoryService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getAllLoanConditionByBorrowerCategory(){

    }


}