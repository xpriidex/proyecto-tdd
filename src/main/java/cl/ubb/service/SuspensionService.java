package cl.ubb.service;

import cl.ubb.dao.SuspensionDao;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.Suspension;
import cl.ubb.service.exceptions.EmptyListException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Felipe on 5/31/2017.
 */
public class SuspensionService {
    @Autowired
    private SuspensionDao suspensionDao;
    public List<Suspension> getAll() throws EmptyListException {

        List<Suspension> result= suspensionDao.getAll();
        if(result.isEmpty())
            throw new EmptyListException();

        return result;
    }

    public Suspension get(String id) throws ReadErrorException{
        Suspension output = suspensionDao.get(id);
        if(output==null){
            throw new ReadErrorException();

        }
        return output;

    }

    public List <Suspension> getAllSuspensionByRut(String rut) {
        return null;
    }
}
