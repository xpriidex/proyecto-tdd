package cl.ubb.service;

import cl.ubb.dao.TitleDao;
import cl.ubb.model.Book;
import cl.ubb.model.Journal;
import cl.ubb.model.Subject;
import cl.ubb.model.Title;
import cl.ubb.service.exceptions.EmptyListException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Felipe on 5/29/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class TitleServiceTest {
    private Subject subject1,subject2;
    private Book book1, book2;
    private Journal journal1;


    @Before
    public void setUp() throws Exception {
        subject1 = new Subject();
        subject2 = new Subject();

        book1= new Book();
        book2= new Book();
        journal1= new Journal();

        subject1.setIdentifier("101");
        subject1.setName("Literatura del Siglo XIX");

        subject2.setIdentifier("202");
        subject2.setName("Ingenieria De Software");

        book1.setIdentifier("1001");
        book1.setName("Robin Hood");
        book1.setYear("2004");
        book1.setFormat("Printed");
        book1.setReplacementCost("17610");
        book1.setAuthor("Howard Pyle");
        book1.setIsbn("978-1402714566");
        book1.setEditorial("Sterling");



        book2.setIdentifier("1003");
        book2.setName("Rimas y Leyendas");
        book2.setYear("2016");
        book2.setFormat("Printed");
        book2.setReplacementCost("7200");
        book2.setAuthor("Gustavo Adolfo Bécquer");
        book2.setIsbn("978-9561215955");
        book2.setEditorial("ZigZag");

        journal1.setIdentifier("2001");
        journal1.setName("Nutrition, Metabolism and Cardiovascular Diseases");
        journal1.setYear("2004");
        journal1.setFormat("Electronic");
        journal1.setReplacementCost("0");
        journal1.setVolumen("27");
        journal1.setIssue("5");
    }

    @Mock
    private TitleDao titleDao;

    @InjectMocks
    private TitleService titleService;

    @Test
    public void whenGetTitleForSubjectsIsId101ReturnTheTitles1001And1003() throws EmptyListException {
        LinkedList<Title> titles = new LinkedList<>();
        titles.add(book1);
        titles.add(book2);
        when(titleDao.getBySubject("101")).thenReturn(titles);
        List <Title> result;

        result = titleService.getAllTitlesForSubject("101");

        assertEquals(titles.size(),result.size());
        assertEquals(titles.get(1).getName(),result.get(1).getName());
        assertEquals("",result.get(1).getReplacementCost());
    }

    @Test(expected = EmptyListException.class)
    public void whenGetTitlesForSubjectId202ReturnEmptyListException() throws EmptyListException {
        LinkedList<Title> titles = new LinkedList<>();
        when(titleDao.getBySubject("202")).thenReturn(titles);
        List <Title> result;

        result = titleService.getAllTitlesForSubject("202");
    }
    

}