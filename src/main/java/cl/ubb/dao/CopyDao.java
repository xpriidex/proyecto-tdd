package cl.ubb.dao;

import cl.ubb.model.Copy;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.DeleteException;
import cl.ubb.dao.exceptions.UpdateException;

import java.util.List;

/**
 * Created by Felipe Cifuentes on 29-05-2017.
 */
public interface CopyDao {
    public void create(Copy copy)throws CreateException;

    public void update(Copy copy)throws UpdateException;

    public Copy delete(String id)throws DeleteException;

    public Copy get (String id);

    public List<Copy> getAll();

    public boolean exist(String id);
}
