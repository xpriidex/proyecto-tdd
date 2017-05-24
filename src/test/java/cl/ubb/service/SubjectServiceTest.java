package cl.ubb.service;

import cl.ubb.dao.exceptions.EmptyListException;
import cl.ubb.dao.SubjectDao;
import cl.ubb.model.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Felipe on 5/22/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class SubjectServiceTest {
    @Mock
    private SubjectDao subjectDao;

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
        when(subjectDao.getName(12345)).thenReturn("Literatura Siglo XIX");

        resp=subjectService.getName(12345);
        assertEquals("Literatura Siglo XIX",resp);

    }


}