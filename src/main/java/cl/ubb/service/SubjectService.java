package cl.ubb.service;

import cl.ubb.dao.SubjectDao;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.DeleteException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.dao.exceptions.UpdateException;
import cl.ubb.model.Subject;
import cl.ubb.service.exceptions.EmptyListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Felipe on 5/22/2017.
 */
@Service
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

    public Subject get(String id) throws ReadErrorException {
        if (!subjectDao.exist(id))
            throw new ReadErrorException();

        return subjectDao.get(id);
    }

    public void create(Subject subject) throws CreateException {
        if (!subjectDao.exist(subject.getIdentifier()))
            throw new CreateException();
        subjectDao.create(subject);
    }

    public Subject update(Subject subject) throws CreateException, UpdateException, ReadErrorException {
        if (!subjectDao.exist(subject.getIdentifier()))
            throw new ReadErrorException();

        Subject subjectToUpdate = subjectDao.get(subject.getIdentifier());

        subjectToUpdate.setName(subject.getName());

        subjectDao.update(subjectToUpdate);

        return subjectToUpdate;


    }
}
