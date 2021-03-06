package cl.ubb.dao;

import cl.ubb.model.Title;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.DeleteException;
import cl.ubb.dao.exceptions.UpdateException;

import java.util.List;

/**
 * Created by Felipe Cifuentes on 29-05-2017.
 */
public interface TitleDao {

    public void create(Title title)throws CreateException;

    public void update(Title title)throws UpdateException;

    public Title delete(String id)throws DeleteException;

    public Title get (String id);

    public List<Title> getAll();

    public List<Title> getBySubject(String subjetcId);

    public boolean exist(String id);
}
