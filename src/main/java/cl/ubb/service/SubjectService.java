package cl.ubb.service;

import cl.ubb.dao.SubjectDao;
import cl.ubb.dao.exceptions.EmptyListException;
import cl.ubb.model.Subject;
import cl.ubb.service.exceptions.DeleteException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Felipe on 5/22/2017.
 */
public class SubjectService {
    @Autowired
    private SubjectDao subjectDao;
    public LinkedList<Subject> getAll() throws EmptyListException{
        List<Subject> subjects = (List<Subject>) subjectDao.getAll();
        if(subjects.size()==0){
            throw new EmptyListException();
        }
        return (LinkedList<Subject>) subjectDao.getAll();
    }

    public String getName(String id) {
        return subjectDao.get(id).getName();
    }

    public Subject delete(String i) throws DeleteException {
        return subjectDao.delete(i);
    }

}
