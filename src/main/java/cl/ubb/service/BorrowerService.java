package cl.ubb.service;

import cl.ubb.dao.BorrowerDao;
import cl.ubb.model.Borrower;
import cl.ubb.model.Suspension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
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
    public boolean canBorrow(String rut, String date){
        Boolean status;
        String finishSuspension = date;

        LinkedList<Suspension> suspensions =new LinkedList<>();
        suspensions = (LinkedList<Suspension>) suspensionService.getAllSuspensionByRut(rut);

        if (suspensions.size()>=1)
            if (finishSuspension==date)
                return false;

        return true;
    }

}
