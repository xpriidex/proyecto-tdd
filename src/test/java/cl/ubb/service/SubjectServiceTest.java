package cl.ubb.service;

import cl.ubb.dao.SubjectDao;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.DeleteException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.Subject;
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
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Felipe on 5/22/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class SubjectServiceTest {
    private Subject subject,subject2,subject3,subject4,subject5;

    @Before
    public void setUp() throws Exception {
        subject = new Subject();
        subject2 = new Subject();
        subject3 = new Subject();
        subject4 = new Subject();
        subject5 = new Subject();

        subject.setIdentifier("1001");
        subject.setName("Robin Hood");

        subject2.setIdentifier("2001");
        subject2.setName("Nutricion");

        subject3.setIdentifier("1003");
        subject3.setName("Rimas y Leyendas");

        subject4.setIdentifier("101");
        subject4.setName("Literatura Del Siglo XIX");

        subject5.setIdentifier("202");
        subject5.setName("Ingenieria De Software");

    }

    @Mock
    private SubjectDao subjectDao;

    @InjectMocks
    private SubjectService subjectService;

    @Test
    public void whengerAllCalledAmdThereAreSubjectsAllOfThenShouldBeReturnedInAList() throws EmptyListException {
        LinkedList <Subject> resp;
        LinkedList <Subject> subjects = new LinkedList<Subject>();
        subjects.add(new Subject("12345","Literatura Siglo XIX"));
        when(subjectDao.getAll()).thenReturn(subjects);

        resp = subjectService.getAll();

        assertEquals(resp,subjects);

    }

    @Test(expected = EmptyListException.class)
    public void whenGetAllIsCalledAndThereAreNoSubjectsShouldBeReturnNull() throws EmptyListException {
        List<Subject> resp;
        List<Subject> subjects = new LinkedList<>();
        when(subjectDao.getAll()).thenReturn(subjects);
        resp = subjectService.getAll();
    }
    @Test
    public void whendoIsCalledAndThereIsASubjectWhitAnIdGivenShouldReturnTheNameOfSubject(){
        String resp;
        when(subjectDao.exist(anyString())).thenReturn(true);
        when(subjectDao.get(anyString())).thenReturn(subject);


        resp=subjectService.getName("1");
        assertEquals("Robin Hood",resp);

    }

    @Test
    public void whenDeleteSubjectOneReturnSubjectOne() throws DeleteException {
        subjectService.delete("1");
        verify(subjectDao).delete("1");
    }

    @Test
    public void whenGetAllSubjects() throws EmptyListException {
        List <Subject> result= new LinkedList<>();
        List<Subject>subjects=new LinkedList<>();
        subjects.add(subject);
        subjects.add(subject2);
        subjects.add(subject3);
        when(subjectDao.getAll()).thenReturn(subjects);

        result = subjectService.getAll();

        assertEquals(result, subjects);
        assertEquals("1001",result.get(0).getIdentifier());
        assertEquals("2001",result.get(1).getIdentifier());
        assertEquals("1003",result.get(2).getIdentifier());
        assertEquals("Robin Hood",result.get(0).getName());
        assertEquals("Nutricion",result.get(1).getName());
        assertEquals("Rimas y Leyendas",result.get(2).getName());



    }
    @Test(expected = EmptyListException.class)
    public void whenGetAllSubjectsEmptyList() throws EmptyListException {
        List<Subject>subjects=new LinkedList<>();
        when(subjectDao.getAll()).thenReturn(subjects);

        subjectService.getAll();

    }
    @Test
    public void whenGetSubjectIdIs101ReturnLiteraturaDelSigloXIX() throws ReadErrorException {
        Subject result = new Subject();
        when(subjectDao.exist(subject4.getIdentifier())).thenReturn(true);
        when(subjectDao.get(subject4.getIdentifier())).thenReturn(subject4);

        result = subjectService.get(subject4.getIdentifier());

        assertEquals("101",result.getIdentifier());
        assertEquals("Literatura Del Siglo XIX",result.getName());


    }

    @Test
    public void checkGetGetSubject() throws Exception, ReadErrorException {
        Mockito.when(subjectDao.exist(subject.getIdentifier())).thenReturn(true);
        Mockito.when(subjectDao.get(subject.getIdentifier())).thenReturn(subject);

        Subject result = subjectService.get(subject.getIdentifier());

        Assert.assertEquals(subject,result);
    }

    @Test(expected = ReadErrorException.class)
    public void whenGetSubjectIdIs202ReturnIngenieriaDeSoftware() throws ReadErrorException {
        Subject result = new Subject();
        when(subjectDao.get("102")).thenReturn(null);

        result = subjectService.get("102");

    }

    @Test
    public void checkCreateSubject() throws CreateException {
        when(subjectDao.exist(subject.getIdentifier())).thenReturn(true);

        subjectService.create(subject);
        verify(subjectDao).create(subject);
    }

    @Test(expected = CreateException.class)
    public void checkCreateSubjectAlreadyExist() throws CreateException {
        when(subjectDao.exist(subject.getIdentifier())).thenReturn(false);

        subjectService.create(subject);
    }

    @Test
    public void checkUpdateSubject() throws Exception, ReadErrorException {
        Subject subjectToUpdate = subject;
        subjectToUpdate.setName("Cambio");

        Mockito.when(subjectDao.exist(subject.getIdentifier())).thenReturn(true);
        Mockito.when(subjectDao.get(subject.getIdentifier())).thenReturn(subject);

        Subject result = subjectService.update(subjectToUpdate);

        Mockito.verify(subjectDao).update(subjectToUpdate);

        Assert.assertEquals("Cambio",result.getName());

    }

    @Test(expected = ReadErrorException.class)
    public void checkUpdateSubjectNotExist() throws Exception, ReadErrorException {
        Subject subjectToUpdate = subject;
        subjectToUpdate.setName("Cambio");

        Mockito.when(subjectDao.exist(subject.getIdentifier())).thenReturn(false);

        Subject result = subjectService.update(subjectToUpdate);

    }







}