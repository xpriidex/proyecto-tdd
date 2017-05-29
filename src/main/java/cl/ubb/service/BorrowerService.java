package cl.ubb.service;

import cl.ubb.dao.daoImpl.BorrowerDaoImpl;
import cl.ubb.model.Borrower;

import java.util.List;

/**
 * Created by Felipe Cifuentes on 22-05-2017.
 */
public class BorrowerService {

    private BorrowerDaoImpl borrowerDao;
    public List<Borrower> getAll() {

        return borrowerDao.getAll();
    }

}
