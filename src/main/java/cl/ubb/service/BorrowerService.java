package cl.ubb.service;

import cl.ubb.dao.BorrowerDao;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.Borrower;
import cl.ubb.model.BorrowerCategory;
import cl.ubb.model.LoanCondition;
import cl.ubb.model.Suspension;
import cl.ubb.service.exceptions.EmptyListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Felipe Cifuentes on 22-05-2017.
 */
@Service
public class BorrowerService {
    @Autowired
    private BorrowerDao borrowerDao;

    @Autowired
    private SuspensionService suspensionService;

    public List<Borrower> getAll() throws EmptyListException {
        List<Borrower> output = borrowerDao.getAll();
        if (output.isEmpty())
            throw new EmptyListException();

        return output;

    }

    public void create(Borrower borrower) throws CreateException {
        if (borrowerDao.exist(borrower.getRut()))
            throw new CreateException();
        borrowerDao.create(borrower);

    }

    public Boolean borrowerExist(String rut) {
        if (borrowerDao.exist(rut))
            return true;
        return false;
    }

    public BorrowerCategory getBorrowerCategory(String rut) throws ReadErrorException {
        if (!borrowerDao.exist(rut))
            throw new ReadErrorException();

        BorrowerCategory output = borrowerDao.get(rut).getBorrowerCategory();

        // TODO: 6/13/2017  if (output==null)


        return output;


    }

    public boolean canBorrow(String rut, String date) {
        Boolean status;
        String finishSuspension = date;

        LinkedList<Suspension> suspensions;
        suspensions = (LinkedList<Suspension>) suspensionService.getAllSuspensionByRut(rut);

        Calendar startDate = Calendar.getInstance();
        Calendar queryDate = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        boolean resp = true;
        List<Suspension> suspensionsFiltered = new LinkedList<>();
        for (Suspension s : suspensions) {
            if (s.getIdentifier().equals(rut)) {
                suspensionsFiltered.add(s);
            }
        }
        for (Suspension s : suspensionsFiltered) {
            try {
                Date start = (Date) dateFormat.parse(s.getStarDate());
                Date query = (Date) dateFormat.parse(date);
                startDate.setTime(start);
                queryDate.setTime(query);
                switch (s.getUnitOfTime()) {
                    case "Days":
                        startDate.add(Calendar.DATE, new Integer(s.getUnitOfTime()));
                        break;
                    case "Months":
                        startDate.add(Calendar.MONTH, new Integer(s.getUnitOfTime()));
                        break;
                    case "Years":
                        startDate.add(Calendar.YEAR, new Integer(s.getUnitOfTime()));
                        break;
                }
                if (queryDate.after(startDate)) {
                    resp = true;
                } else {
                    resp = false;
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        return resp;
    }

    public boolean validateAtributes(Borrower borrower1) {
        if (borrower1.getRut().equals("") || borrower1.getName().equals("") || borrower1.getCellPhone().equals("")
                || borrower1.getEmail().equals("") || borrower1.getBorrowerCategory() == null) {
            return false;
        }
        return true;
    }

    public List<Borrower> getAllBorrowerSuspention() throws EmptyListException {
        List<Borrower> allBorrower = getAll();
        List<Borrower> borrowerSuspentions = new ArrayList<>();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date date = cal.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
        String date1 = format1.format(date);


        for (Borrower borrower : allBorrower) {
            if (canBorrow(borrower.getRut(), date1))
                borrowerSuspentions.add(borrower);
        }

        return borrowerSuspentions;
    }

    public List<Borrower> getAllBorrowerNotHaveSuspention() throws EmptyListException {
        List<Borrower> allBorrower = getAll();
        List<Borrower> borrowerNotHaveSuspentions = new ArrayList<>();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date date = cal.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
        String date1 = format1.format(date);


        for (Borrower borrower : allBorrower) {
            if (!canBorrow(borrower.getRut(), date1))
                borrowerNotHaveSuspentions.add(borrower);
        }

        return borrowerNotHaveSuspentions;
    }

    public List<LoanCondition> getLoanCondition(String rut) throws ReadErrorException, EmptyListException {
        BorrowerCategory borrowerCategory = getBorrowerCategory(rut);

        if (borrowerCategory.getLoanConditions().size() == 0)
            throw new EmptyListException();

        return borrowerCategory.getLoanConditions();
    }

    public Borrower get(String rut) throws ReadErrorException {
        if (!borrowerDao.exist(rut))
            throw new ReadErrorException();

        return borrowerDao.get(rut);
    }
}
