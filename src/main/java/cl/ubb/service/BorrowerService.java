package cl.ubb.service;

import cl.ubb.dao.daoImpl.BorrowerDao;
import cl.ubb.model.Borrower;

import java.util.List;

/**
 * Created by Felipe Cifuentes on 22-05-2017.
 */
public class BorrowerService {

    private BorrowerDao borrowerDao;
    public List<Borrower> getAll() {

        return borrowerDao.getAll();
    }

}
