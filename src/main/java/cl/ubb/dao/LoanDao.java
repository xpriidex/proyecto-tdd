package cl.ubb.dao;

import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.DeleteException;
import cl.ubb.dao.exceptions.UpdateException;
import cl.ubb.model.Copy;
import cl.ubb.model.Loan;

import java.util.List;

/**
 * Created by Felipe Cifuentes on 27-06-2017.
 */
public interface LoanDao {
    public void create(Loan loan)throws CreateException;

    public void update(Loan loan)throws UpdateException;

    public Loan delete(String id)throws DeleteException;

    public Loan get (String id);

    public List<Loan> getAll();

    public boolean exist(String id);
}
