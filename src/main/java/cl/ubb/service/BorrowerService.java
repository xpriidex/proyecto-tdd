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
<<<<<<< HEAD

=======
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
>>>>>>> 06b637d8c8cc036a13b2b6337732a95b4dce1c8a

}
