package cl.ubb.dao.daoImpl;

import cl.ubb.dao.SubjectDao;
import cl.ubb.model.Subject;
import cl.ubb.service.exceptions.CreateException;
import cl.ubb.service.exceptions.DeleteException;
import cl.ubb.service.exceptions.UpdateException;

import java.util.List;

/**
 * Created by Felipe on 5/22/2017.
 */
public class SubjectDaoImpl implements SubjectDao{


    @Override
    public void create(Subject subject) throws CreateException {

    }

    @Override
    public void update(Subject subject) throws UpdateException {

    }

    @Override
    public Subject delete(long id) throws DeleteException {
        return null;
    }

    @Override
    public Subject get( long id) {
        return null;
    }

    @Override
    public List<Subject> getAll() {
        return null;
    }

    @Override
    public boolean exist(long id) {
        return false;
    }
}
