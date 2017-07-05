package cl.ubb.controller;

import cl.ubb.model.BorrowerCategory;
import cl.ubb.service.BorrowerCategoryService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Felipe Cifuentes on 05-07-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class BorrowerCategoryControllerTest {
    private BorrowerCategory borrowerCategory1, borrowerCategory2;
    private List<BorrowerCategory> borrowerCategories;

    @Mock
    private BorrowerCategoryService borrowerCategoryService;

    @InjectMocks
    private BorrowerCategoryController borrowerCategoryController;

    @Before
    public void setUp()throws Exception{
        borrowerCategory1 = new BorrowerCategory();
        borrowerCategory2 = new BorrowerCategory();

        borrowerCategory1.setIndentifier("111");
        borrowerCategory1.setName("category1");
        borrowerCategory1.setMaxNumberOfLoans(1);


    }

}