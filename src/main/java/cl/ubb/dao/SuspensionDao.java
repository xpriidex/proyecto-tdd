package cl.ubb.dao;

import cl.ubb.model.Suspension;
import cl.ubb.service.exceptions.CreateException;
import cl.ubb.service.exceptions.DeleteException;
import cl.ubb.service.exceptions.UpdateException;

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
