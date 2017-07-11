package cl.ubb.service;

import cl.ubb.dao.BorrowerCategoryDao;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.DeleteException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.dao.exceptions.UpdateException;
import cl.ubb.model.BorrowerCategory;
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
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Felipe on 6/19/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class BorrowerCategoryServiceTest {
    private BorrowerCategory borrowerCategory;
    private List<BorrowerCategory> borrowerCategories;

    @Mock
    private BorrowerCategoryDao borrowerCategoryDao;

    @InjectMocks
    private BorrowerCategoryService borrowerCategoryService;

    @Before
    public void setUp() throws Exception {
        borrowerCategory = new BorrowerCategory();
        borrowerCategories = new ArrayList<>();

        borrowerCategory.setIdentifier("1");
        borrowerCategory.setName("categoria");
        borrowerCategory.setMaxNumberOfLoans(2);

        borrowerCategories.add(borrowerCategory);
    }

    @Test
    public void checkCreateNewBorrowerCategory() throws Exception {
        Mockito.when(borrowerCategoryDao.exist(borrowerCategory.getIdentifier()))
                .thenReturn(false);

        borrowerCategoryService.create(borrowerCategory);
        Mockito.verify(borrowerCategoryDao).create(borrowerCategory);
    }

    @Test (expected = CreateException.class)
    public void checkCreateNewBorrowerCategoryWhenAlreadyExists() throws Exception {
        Mockito.when(borrowerCategoryDao.exist(borrowerCategory.getIdentifier()))
                .thenReturn(true);

        borrowerCategoryService.create(borrowerCategory);

    }

    @Test
    public void checkDeleteExistingBorrowerCategory() throws Exception {
        Mockito.when(borrowerCategoryDao.exist(borrowerCategory.getIdentifier()))
                .thenReturn(true);
        Mockito.when(borrowerCategoryDao.get(borrowerCategory.getIdentifier()))
                .thenReturn(borrowerCategory);
        BorrowerCategory result;

        result = borrowerCategoryService.delete(borrowerCategory.getIdentifier());

        Mockito.verify(borrowerCategoryDao).delete(borrowerCategory.getIdentifier());
        assertEquals(result,borrowerCategory);
    }

    @Test(expected = DeleteException.class)
    public void checkDeleteInvalidBorrowerCategoryId() throws Exception {
        Mockito.when(borrowerCategoryDao.exist(borrowerCategory.getIdentifier()))
                .thenReturn(false);
        borrowerCategoryService.delete(borrowerCategory.getIdentifier());
    }

    @Test
    public void checkGetBorrowerCategory() throws Exception, ReadErrorException {
        Mockito.when(borrowerCategoryDao.exist(borrowerCategory.getIdentifier())).thenReturn(true);
        Mockito.when(borrowerCategoryDao.get(borrowerCategory.getIdentifier())).thenReturn(borrowerCategory);

        BorrowerCategory result = borrowerCategoryService.get(borrowerCategory.getIdentifier());

        Assert.assertEquals(borrowerCategory,result);
    }

    @Test(expected = ReadErrorException.class)
    public void checkGetInvalidBorrowerCategory() throws Exception, ReadErrorException {
        Mockito.when(borrowerCategoryDao.exist(borrowerCategory.getIdentifier())).thenReturn(false);
        borrowerCategoryService.get(borrowerCategory.getIdentifier());
    }

    @Test
    public void checkReadAllBorrowerCategory() throws Exception {
        Mockito.when(borrowerCategoryDao.getAll()).thenReturn(borrowerCategories);
        Assert.assertEquals(borrowerCategoryService.getAll(),borrowerCategories);
    }

    @Test(expected = EmptyListException.class)
    public void checkReadAllWhenNullBorrowerCategory() throws Exception {
        Mockito.when(borrowerCategoryDao.getAll()).thenReturn(null);
        borrowerCategoryService.getAll();
    }

    @Test
    public void checkExistBorrowerCategoryisTrue() throws Exception {
        Mockito.when(borrowerCategoryDao.exist(borrowerCategory.getIdentifier())).thenReturn(true);

        Assert.assertTrue(borrowerCategoryService.existBorrowerCategory(borrowerCategory.getIdentifier()));
    }

    @Test
    public void checkExistBorrowerCategoryisFalse() throws Exception {
        Mockito.when(borrowerCategoryDao.exist(borrowerCategory.getIdentifier())).thenReturn(false);

        Assert.assertFalse(borrowerCategoryService.existBorrowerCategory(borrowerCategory.getIdentifier()));
    }

    @Test
    public void checkUpdateBorrowerCategory() throws Exception {
        BorrowerCategory borrowerCategoryToUpdate = new BorrowerCategory();
        borrowerCategoryToUpdate = borrowerCategory;
        borrowerCategoryToUpdate.setName("Cambio");

        when(borrowerCategoryDao.exist(borrowerCategory.getIdentifier())).thenReturn(true);
        when(borrowerCategoryDao.get(borrowerCategory.getIdentifier())).thenReturn(borrowerCategoryToUpdate);

        BorrowerCategory result = borrowerCategoryService.update(borrowerCategoryToUpdate);

        verify(borrowerCategoryDao).update(borrowerCategoryToUpdate);

        Assert.assertEquals("Cambio",result.getName());

    }

    @Test(expected = UpdateException.class)
    public void checkUpdateWhenBorrowerCategoryNotExist() throws Exception {
        Mockito.when(borrowerCategoryDao.exist(borrowerCategory.getIdentifier())).thenReturn(false);
        borrowerCategoryService.update(borrowerCategory);
    }


}