package cl.ubb.dao;

import cl.ubb.model.TitleCategory;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.DeleteException;
import cl.ubb.dao.exceptions.UpdateException;

import java.util.List;

/**
 * Created by Felipe Cifuentes on 29-05-2017.
 */
public interface TitleCategoryDao {

    public void create(TitleCategory titleCategory)throws CreateException;

    public void update(TitleCategory titleCategory)throws UpdateException;

    public TitleCategory delete(String id)throws DeleteException;

    public TitleCategory get (String id);

    public List<TitleCategory> getAll();

    public boolean exist(String id);
}
