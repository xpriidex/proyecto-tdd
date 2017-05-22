package cl.ubb.service.impl;

import cl.ubb.model.Borrower;
import cl.ubb.service.BorrowerService;
import cl.ubb.service.exceptions.CreateException;
import cl.ubb.service.exceptions.DeleteException;
import cl.ubb.service.exceptions.UpdateException;

import java.util.List;

/**
 * Created by Felipe Cifuentes on 22-05-2017.
 */
public class BorrowerServiceImpl implements BorrowerService{


    @Override
    public void create(Borrower borrower) throws CreateException {

    }

    @Override
    public void update(Borrower borrower) throws UpdateException {

    }

    @Override
    public Borrower delete(String id) throws DeleteException {
        return null;
    }

    @Override
    public Borrower get(String id) {
        return null;
    }

    @Override
    public List<Borrower> getAll() {
        return null;
    }

    @Override
    public boolean exist(String id) {
        return false;
    }
}
