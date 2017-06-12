package cl.ubb.service;

import cl.ubb.dao.BorrowerDao;
import cl.ubb.model.Borrower;
import cl.ubb.model.Suspension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Felipe Cifuentes on 22-05-2017.
 */
@Service
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

        LinkedList<Suspension> suspensions;
        suspensions = (LinkedList<Suspension>) suspensionService.getAllSuspensionByRut(rut);

        Calendar startDate = Calendar.getInstance();
        Calendar queryDate = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        boolean resp = true;
        List <Suspension> suspensionsFiltered = new LinkedList<>();
        for(Suspension s : suspensions){
            if(s.getIdentifier().equals(rut)){
                suspensionsFiltered.add(s);
            }
        }
        for(Suspension s : suspensionsFiltered){
            try {
                Date start = (Date)dateFormat.parse(s.getStarDate());
                Date query = (Date)dateFormat.parse(date);
                startDate.setTime(start);
                queryDate.setTime(query);
                switch (s.getUnitOfTime()){
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
                if(queryDate.after(startDate)){
                    resp = true;
                }else{
                    resp = false;
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        return resp;
    }

}
