package cl.ubb.service;

import cl.ubb.dao.SuspensionDao;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.DeleteException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.dao.exceptions.UpdateException;
import cl.ubb.model.Suspension;
import cl.ubb.service.exceptions.EmptyListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Felipe on 5/31/2017.
 */
@Service
public class SuspensionService {
    @Autowired
    private SuspensionDao suspensionDao;

    public void create(Suspension suspension)throws CreateException {
        if (suspensionDao.exist(suspension.getIdentifier()))
            throw new CreateException();

        suspensionDao.create(suspension);

    }

    public Suspension update(Suspension suspension)throws UpdateException {
        if (!suspensionDao.exist(suspension.getIdentifier()))
            throw new UpdateException();

        Suspension suspensionToUpdate = suspensionDao.get(suspension.getIdentifier());
        suspensionToUpdate.setNumberOfUnitOfTime(suspension.getNumberOfUnitOfTime());
        suspensionToUpdate.setStarDate(suspension.getStarDate());
        suspensionToUpdate.setBorrower(suspension.getBorrower());
        suspensionToUpdate.setDescription(suspension.getDescription());
        suspensionToUpdate.setUnitOfTime(suspension.getUnitOfTime());

        suspensionDao.update(suspensionToUpdate);

        return suspensionToUpdate;
    }

    public Suspension delete(String id)throws DeleteException {
        if (!suspensionDao.exist(id))
            throw new DeleteException();

        Suspension ouput = suspensionDao.get(id);

        suspensionDao.delete(id);

        return ouput;

    }

    public Suspension get(String id) throws ReadErrorException {
        if (!suspensionDao.exist(id))
            throw new ReadErrorException();
        return suspensionDao.get(id);

    }

    public List<Suspension> getAll() throws EmptyListException {
        List<Suspension> suspensiones = suspensionDao.getAll();
        if (CollectionUtils.isEmpty(suspensiones)) {
            throw new EmptyListException();
        }
        return suspensiones;

    }

    public boolean exist(String id){
        return suspensionDao.exist(id);
    }

    public List <Suspension> getAllSuspensionByRut(String rut) {
        return null;
    }
}