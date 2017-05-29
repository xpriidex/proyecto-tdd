package cl.ubb.service.impl;

import cl.ubb.dao.exceptions.EmptyListException;
import cl.ubb.dao.daoImpl.SubjectDaoImpl;
import cl.ubb.model.Subject;
import cl.ubb.service.SubjectService;
import cl.ubb.service.exceptions.DeleteException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.xml.ws.Service;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Felipe on 5/22/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class SubjectServiceTest {
    private Subject subject;

    @Before
    public void setUp() throws Exception {
        subject = new Subject();
        subject.setIdentifier(1);
    }

    @Mock
    private SubjectDaoImpl subjectDao;

    @InjectMocks
    private SubjectService subjectService;

    @Test
    public void whengerAllCalledAmdThereAreSubjectsAllOfThenShouldBeReturnedInAList() throws EmptyListException {
        LinkedList <Subject> resp;
        LinkedList <Subject> subjects = new LinkedList<Subject>();
        subjects.add(new Subject((long)12345,"Literatura Siglo XIX"));
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
        when(subjectDao.get(12345)).thenReturn(subject);

        when(subjectService.getName(1)).thenReturn("Literatura Siglo XIX");

        resp=subjectService.getName(1);
        assertEquals("Literatura Siglo XIX",resp);

    }

    @Test
    public void whenDeleteSubjectOneReturnSubjectOne() throws DeleteException {
        subjectService.delete(1);
        verify(subjectDao).delete(1);
    }




}