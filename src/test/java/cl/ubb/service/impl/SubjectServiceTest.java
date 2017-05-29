package cl.ubb.service.impl;

import cl.ubb.dao.SubjectDao;
import cl.ubb.dao.exceptions.EmptyListException;
import cl.ubb.model.Subject;
import cl.ubb.service.SubjectService;
import cl.ubb.service.exceptions.DeleteException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
    private Subject subject,subject2,subject3;

    @Before
    public void setUp() throws Exception {
        subject = new Subject();
        subject2 = new Subject();
        subject3 = new Subject();

        subject.setIdentifier("1001");
        subject.setName("Robin Hood");
        subject2.setIdentifier("2001");
        subject2.setName("Nutricion");
        subject3.setIdentifier("1003");
        subject3.setName("Rimas y Leyendas");
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
        when(subjectDao.get("12345")).thenReturn(subject);

        when(subjectService.getName("1")).thenReturn("Literatura Siglo XIX");

        resp=subjectService.getName("1");
        assertEquals("Literatura Siglo XIX",resp);

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

}