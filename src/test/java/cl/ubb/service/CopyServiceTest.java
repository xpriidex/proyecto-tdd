package cl.ubb.service;

import cl.ubb.dao.CopyDao;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.DeleteException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.dao.exceptions.UpdateException;
import cl.ubb.model.Copy;
import cl.ubb.model.Title;
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
 * Created by Felipe Cifuentes on 05-06-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class CopyServiceTest {
    private Copy copy;
    private List<Copy> copies;
    private Title title;

    @Mock
    CopyDao copyDao;

    @InjectMocks
    CopyService copyService;

    @Before
    public void setUp() throws Exception {
        copy = new Copy();
        copies = new ArrayList<>();
        copies = new ArrayList<>();
        title = new Title();

        title.setIdentifier("1");

        copy.setIdentifier("1");
        copy.setAcquisitionDate("20-06-2017");
        copy.setIdTitle("1");

        copies.add(copy);
    }



    @Test
    public void checkCreateNewCopy() throws Exception {
        Mockito.when(copyDao.exist(copy.getIdentifier()))
                .thenReturn(false);

        copyService.create(copy);
        Mockito.verify(copyDao).create(copy);
    }

    @Test (expected = CreateException.class)
    public void checkCreateNewCopyWhenAlreadyExists() throws Exception {
        Mockito.when(copyDao.exist(copy.getIdentifier()))
                .thenReturn(true);

        copyService.create(copy);

    }

    @Test
    public void checkDeleteExistingCopy() throws Exception {
        Mockito.when(copyDao.exist(copy.getIdentifier()))
                .thenReturn(true);

        Mockito.when(copyDao.get(copy.getIdentifier()))
                .thenReturn(copy);
        Copy result;

        result = copyService.delete(copy.getIdentifier());

        Mockito.verify(copyDao).delete(copy.getIdentifier());
        assertEquals(result,copy);
    }

    @Test(expected = DeleteException.class)
    public void checkDeleteInvalidCopyId() throws Exception {
        Mockito.when(copyDao.exist(copy.getIdentifier()))
                .thenReturn(false);
        copyService.delete(copy.getIdentifier());
    }

    @Test
    public void checkGetBorrowerCopy() throws Exception, ReadErrorException {
        Mockito.when(copyDao.exist(copy.getIdentifier())).thenReturn(true);
        Mockito.when(copyDao.get(copy.getIdentifier())).thenReturn(copy);

        Copy result = copyService.get(copy.getIdentifier());

        Assert.assertEquals(copy,result);
    }

    @Test(expected = ReadErrorException.class)
    public void checkGetInvalidCopy() throws Exception, ReadErrorException {
        Mockito.when(copyDao.exist(copy.getIdentifier())).thenReturn(false);
        copyService.get(copy.getIdentifier());
    }

    @Test
    public void checkReadAllCopies() throws Exception {
        Mockito.when(copyDao.getAll()).thenReturn(copies);
        Assert.assertEquals(copyService.getAll(),copies);
    }

    @Test(expected = EmptyListException.class)
    public void checkReadAllWhenNullCopies() throws Exception {
        Mockito.when(copyDao.getAll()).thenReturn(null);
        copyService.getAll();
    }

    @Test
    public void checkExistCopyIsTrue() throws Exception {
        Mockito.when(copyDao.exist(copy.getIdentifier())).thenReturn(true);

        Assert.assertTrue(copyDao.exist(copy.getIdentifier()));
    }

    @Test
    public void checkExistCopyIsFalse() throws Exception {
        Mockito.when(copyDao.exist(copy.getIdentifier())).thenReturn(false);

        Assert.assertFalse(copyService.exist(copy.getIdentifier()));
    }

    @Test
    public void checkUpdateCopy() throws Exception {
        Copy copyCategoryToUpdate = new Copy();
        copyCategoryToUpdate = copy;
        copyCategoryToUpdate.setAcquisitionDate("21-06-2017");

        when(copyDao.exist(copy.getIdentifier())).thenReturn(true);
        when(copyDao.get(copy.getIdentifier())).thenReturn(copyCategoryToUpdate);

        Copy result = copyService.update(copyCategoryToUpdate);

        verify(copyDao).update(copyCategoryToUpdate);

        Assert.assertEquals("21-06-2017",result.getAcquisitionDate());

    }

    @Test(expected = UpdateException.class)
    public void checkUpdateWhenCopyNotExist() throws Exception {
        Mockito.when(copyDao.exist(copy.getIdentifier())).thenReturn(false);
        copyService.update(copy);
    }



}