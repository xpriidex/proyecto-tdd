package cl.ubb.service;

import cl.ubb.dao.LoanDao;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.model.Loan;
import cl.ubb.service.exceptions.EmptyListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Felipe Cifuentes on 27-06-2017.
 */
@Service
public class LoanService {
    @Autowired
    private LoanDao loanDao;

    public List<Loan> getAll() throws EmptyListException {
        List<Loan> toReturn = loanDao.getAll();
        if (toReturn.isEmpty()) {
            throw new EmptyListException();
        } else {
            return loanDao.getAll();
        }
    }


}
