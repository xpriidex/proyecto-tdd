package cl.ubb.dao;

import cl.ubb.model.BorrowerCategory;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.DeleteException;
import cl.ubb.dao.exceptions.UpdateException;

import java.util.List;

/**
 * Created by Felipe Cifuentes on 29-05-2017.
 */
public interface BorrowerCategoryDao {

    public void create(BorrowerCategory borrowerCategory)throws CreateException;

    public void update(BorrowerCategory borrowerCategory)throws UpdateException;

    public BorrowerCategory delete(String id)throws DeleteException;

    public BorrowerCategory get (String id);

    public List<BorrowerCategory> getAll();

    public boolean exist(String id);
}
