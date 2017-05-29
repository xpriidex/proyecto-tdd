package cl.ubb.dao;

import cl.ubb.model.Subject;
import cl.ubb.service.exceptions.CreateException;
import cl.ubb.service.exceptions.DeleteException;
import cl.ubb.service.exceptions.UpdateException;
import org.hibernate.sql.Update;

import java.util.List;

/**
 * Created by Felipe Cifuentes on 29-05-2017.
 */
public interface SubjectDao {

    public void create(Subject subject)throws CreateException;

    public void update(Subject subject)throws UpdateException;

    public Subject delete(long id)throws DeleteException;

    public Subject get (long id);

    public List<Subject>getAll();

    public boolean exist(long id);
}
