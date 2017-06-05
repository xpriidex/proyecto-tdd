package cl.ubb.service;

import cl.ubb.dao.TitleDao;
import cl.ubb.model.Title;
import cl.ubb.service.exceptions.EmptyListException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Felipe on 5/29/2017.
 */
public class TitleService {

    @Autowired
    private TitleDao titleDao;


    public List<Title> getAllTitlesForSubject(String subjectId) throws EmptyListException {
        List<Title>output = titleDao.getBySubject(subjectId);
        if(output.size()==0)
            throw new EmptyListException();
        for(Title title : output){
            title.setReplacementCost("");

        }
        return output;

    }
}
