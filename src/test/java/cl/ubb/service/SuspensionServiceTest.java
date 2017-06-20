package cl.ubb.service;

import cl.ubb.dao.SuspensionDao;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.DeleteException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.dao.exceptions.UpdateException;
import cl.ubb.model.Borrower;
import cl.ubb.model.Suspension;
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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Felipe on 5/31/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class SuspensionServiceTest {
    private Borrower borrower1,borrower2,borrower3;
    private Suspension suspension1,suspension2,suspension3;
    List<Suspension> suspensions;

    @Mock
    SuspensionDao suspensionDao;
    @InjectMocks
    SuspensionService suspensionService;

    @Before
    public void setUp() throws Exception {
        borrower1 = new Borrower();
        borrower1.setRut("1111111-1");
        borrower1.setName("Andres Perez");

        borrower2 = new Borrower();
        borrower2.setRut("2222222-2");
        borrower2.setName("Cristian Galvez");

        borrower3 = new Borrower();
        borrower3.setRut("3333333-3");
        borrower3.setName("Carlos Casales");

        suspension1 = new Suspension("1","atraso","10-05-2017","5","dias",borrower1);
        suspension2 = new Suspension("2","atraso","20-05-2017","20","dias",borrower1);
        suspension3 = new Suspension("3","perdida","05-05-2017","1","año",borrower2);

        suspensions = new LinkedList<>();
        suspensions.add(suspension1);
        suspensions.add(suspension2);
        suspensions.add(suspension3);

    }

    @Test
    public void whenGetAllIsCalledAndThreeSuspensionExistAListWithThreeItemIsReturned() throws EmptyListException {
        when(suspensionDao.getAll()).thenReturn(suspensions);
        List<Suspension> result ;
        result= suspensionService.getAll();

        assertEquals(3,result.size());
    }

    @Test
    public void whenGetSuspensionIdIs1ReturnSuspensionId1AndDescriptionIsAtraso() throws ReadErrorException {
        Suspension result;

        when(suspensionDao.exist("1")).thenReturn(true);
        when(suspensionDao.get("1")).thenReturn(suspension1);

        result = suspensionService.get("1");

        assertEquals("atraso",result.getDescription());

    }

    @Test(expected = ReadErrorException.class)
    public void whenGetSuspensionIdIs4ReturnReadException() throws ReadErrorException {
        Suspension result;

        when(suspensionDao.get("4")).thenReturn(null);

        result = suspensionService.get("4");
    }


    @Test
    public void checkCreateNewSuspension() throws Exception {
        Mockito.when(suspensionDao.exist(suspension1.getIdentifier()))
                .thenReturn(false);

        suspensionService.create(suspension1);
        Mockito.verify(suspensionDao).create(suspension1);
    }

    @Test (expected = CreateException.class)
    public void checkCreateNewSuspensionWhenAlreadyExists() throws Exception {
        Mockito.when(suspensionDao.exist(suspension1.getIdentifier()))
                .thenReturn(true);

        suspensionService.create(suspension1);

    }

    @Test
    public void checkDeleteExistingSuspension() throws Exception {
        Mockito.when(suspensionDao.exist(suspension1.getIdentifier()))
                .thenReturn(true);
        Mockito.when(suspensionDao.get(suspension1.getIdentifier()))
                .thenReturn(suspension1);
        Suspension result;

        result = suspensionService.delete(suspension1.getIdentifier());

        Mockito.verify(suspensionDao).delete(suspension1.getIdentifier());
        assertEquals(result,suspension1);
    }

    @Test(expected = DeleteException.class)
    public void checkDeleteInvalidSuspensionId() throws Exception {
        Mockito.when(suspensionDao.exist(suspension1.getIdentifier()))
                .thenReturn(false);
        suspensionService.delete(suspension1.getIdentifier());
    }

    @Test
    public void checkGetBorrowerSuspension() throws Exception, ReadErrorException {
        Mockito.when(suspensionDao.exist(suspension1.getIdentifier())).thenReturn(true);
        Mockito.when(suspensionDao.get(suspension1.getIdentifier())).thenReturn(suspension1);

        Suspension result = suspensionService.get(suspension1.getIdentifier());

        Assert.assertEquals(suspension1,result);
    }

    @Test(expected = ReadErrorException.class)
    public void checkGetInvalidSuspension() throws Exception, ReadErrorException {
        Mockito.when(suspensionDao.exist(suspension1.getIdentifier())).thenReturn(false);
        suspensionService.get(suspension1.getIdentifier());
    }

    @Test
    public void checkReadAllSuspensions() throws Exception {
        Mockito.when(suspensionDao.getAll()).thenReturn(suspensions);
        Assert.assertEquals(suspensionService.getAll(),suspensions);
    }

    @Test(expected = EmptyListException.class)
    public void checkReadAllWhenNullSuspensions() throws Exception {
        Mockito.when(suspensionDao.getAll()).thenReturn(null);
        suspensionService.getAll();
    }

    @Test
    public void checkExistSuspensionisTrue() throws Exception {
        Mockito.when(suspensionDao.exist(suspension1.getIdentifier())).thenReturn(true);

        Assert.assertTrue(suspensionService.exist(suspension1.getIdentifier()));
    }

    @Test
    public void checkExistSuspensionisFalse() throws Exception {
        Mockito.when(suspensionDao.exist(suspension1.getIdentifier())).thenReturn(false);

        Assert.assertFalse(suspensionService.exist(suspension1.getIdentifier()));
    }

    @Test
    public void checkUpdateSuspension() throws Exception {
        Suspension suspensionCategoryToUpdate = new Suspension();
        suspensionCategoryToUpdate = suspension1;
        suspensionCategoryToUpdate.setDescription("Cambio");

        when(suspensionDao.exist(suspension1.getIdentifier())).thenReturn(true);
        when(suspensionDao.get(suspension1.getIdentifier())).thenReturn(suspensionCategoryToUpdate);

        Suspension result = suspensionService.update(suspensionCategoryToUpdate);

        verify(suspensionDao).update(suspensionCategoryToUpdate);

        Assert.assertEquals("Cambio",result.getDescription());

    }

    @Test(expected = UpdateException.class)
    public void checkUpdateWhenSuspensionNotExist() throws Exception {
        Mockito.when(suspensionDao.exist(suspension1.getIdentifier())).thenReturn(false);
        suspensionService.update(suspension1);
    }

}