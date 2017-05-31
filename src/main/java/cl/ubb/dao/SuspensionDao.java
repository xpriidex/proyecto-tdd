package cl.ubb.dao;

import cl.ubb.model.Suspension;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.DeleteException;
import cl.ubb.dao.exceptions.UpdateException;

import java.util.List;

/**
 * Created by Felipe Cifuentes on 29-05-2017.
 */
public interface SuspensionDao {

    public void create(Suspension suspension)throws CreateException;

    public void update(Suspension suspension)throws UpdateException;

    public Suspension delete(String id)throws DeleteException;

    public Suspension get (String id);

    public List<Suspension> getAll();

    public boolean exist(String id);

}
