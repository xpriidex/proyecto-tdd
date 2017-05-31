package cl.ubb.dao;

import cl.ubb.model.Borrower;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.DeleteException;
import cl.ubb.dao.exceptions.UpdateException;

import java.util.List;

/**
 * Created by Felipe Cifuentes on 29-05-2017.
 */
public interface BorrowerDao {
    public void create(Borrower borrower)throws CreateException;

    public void update(Borrower borrower)throws UpdateException;

    public Borrower delete(String id)throws DeleteException;

    public Borrower get (String id);

    public List<Borrower> getAll();

    public boolean exist(String id);
}
