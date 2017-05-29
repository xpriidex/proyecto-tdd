package cl.ubb.dao;

import cl.ubb.model.UnitOfTime;
import cl.ubb.service.exceptions.CreateException;
import cl.ubb.service.exceptions.DeleteException;
import cl.ubb.service.exceptions.UpdateException;

import java.util.List;

/**
 * Created by Felipe Cifuentes on 29-05-2017.
 */
public interface UnitOfTimeDao {

    public void create(UnitOfTime unitOfTime)throws CreateException;

    public void update(UnitOfTime unitOfTime)throws UpdateException;

    public UnitOfTime delete(String id)throws DeleteException;

    public UnitOfTime get (String id);

    public List<UnitOfTime> getAll();

    public boolean exist(String id);
}
