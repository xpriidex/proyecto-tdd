package cl.ubb.service;

import cl.ubb.dao.LoanDao;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.model.Loan;
import cl.ubb.service.exceptions.EmptyListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Loan> getAllLoansThatStartIn(String date) throws EmptyListException {
        List <Loan> toReturn = loanDao.getAll().stream()
                .filter(l -> l.getStartDate().equals(date))
                .collect(Collectors.toList());
        if(toReturn.isEmpty()){
            throw new EmptyListException();
        } else{
            return toReturn;
        }
    }


    public List<Loan> getAllLoansThatAreDelayed(String date) {
        List<Loan> beforeFilter = loanDao.getAll();
        List<Loan> filtered = new LinkedList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        for (Loan l : beforeFilter){
            try {
                Date loanEndDate = dateFormat.parse(l.getEndDate());
                Date queryDate = dateFormat.parse(date);
                if (queryDate.after(loanEndDate)){
                    filtered.add(l);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return filtered;
    }

    public List<Loan> getAllLoansThatAreInTime(String date) {
        List<Loan> beforeFilter = loanDao.getAll();
        List<Loan> filtered = new LinkedList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        for (Loan l : beforeFilter){
            try {
                Date inTime = dateFormat.parse(l.getEndDate());
                Date queryDate = dateFormat.parse(date);
                if (queryDate.before(inTime)){
                    filtered.add(l);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return filtered;
    }

    public List<Loan> getAllLoansThatHasBeenReturnedWithDelay(String date) {
        List<Loan> all = loanDao.getAll();
        List<Loan> returnedWithDelay = new LinkedList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        for(Loan l: all){
            try{
                Date returnDate = dateFormat.parse(l.getReturnDate());
                Date endDate = dateFormat.parse(l.getEndDate());
                if(returnDate.before(endDate)){
                    returnedWithDelay.add(l);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return returnedWithDelay;
    }


}
