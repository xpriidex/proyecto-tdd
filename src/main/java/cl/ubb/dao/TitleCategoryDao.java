package cl.ubb.dao;

import cl.ubb.model.TitleCategory;
import cl.ubb.service.exceptions.CreateException;
import cl.ubb.service.exceptions.DeleteException;
import cl.ubb.service.exceptions.UpdateException;

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
