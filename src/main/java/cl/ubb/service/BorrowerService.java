package cl.ubb.service;

import cl.ubb.dao.BorrowerDao;
import cl.ubb.model.Borrower;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Felipe Cifuentes on 22-05-2017.
 */
public class BorrowerService {
    @Autowired
    private BorrowerDao borrowerDao;

    @Autowired
    private SuspensionService suspensionService;
    public List<Borrower> getAll() {

        return borrowerDao.getAll();
    }


}
