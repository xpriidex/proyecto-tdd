package cl.ubb.service;

import cl.ubb.model.Borrower;
import cl.ubb.service.exceptions.CreateException;
import cl.ubb.service.exceptions.DeleteException;
import cl.ubb.service.exceptions.UpdateException;

import java.util.List;

/**
 * Created by Felipe Cifuentes on 22-05-2017.
 */
public interface BorrowerService {
    public void create(Borrower borrower) throws CreateException;

    public void update(Borrower borrower) throws UpdateException;

    public Borrower delete (String id) throws DeleteException;

    public Borrower get (String id);

    public List<Borrower> getAll();

    public boolean exist(String id);



}




