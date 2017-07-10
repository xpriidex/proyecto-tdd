package cl.ubb.service;

import cl.ubb.dao.CopyDao;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.DeleteException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.dao.exceptions.UpdateException;
import cl.ubb.model.Copy;
import cl.ubb.service.exceptions.EmptyListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Felipe Cifuentes on 05-06-2017.
 */
@Service
public class CopyService {

    @Autowired
    private CopyDao copyDao;

    public void create(Copy copy)throws CreateException{
        if (copyDao.exist(copy.getIdentifier()))
            throw new CreateException();

        copyDao.create(copy);

    }

    public Copy update(Copy copy)throws UpdateException{
        if (!copyDao.exist(copy.getIdentifier()))
            throw new UpdateException();

        Copy copyToUpdate = copyDao.get(copy.getIdentifier());
        copyToUpdate.setIdTitle(copy.getIdTitle());
        copyToUpdate.setAcquisitionDate(copy.getAcquisitionDate());


        copyDao.update(copyToUpdate);

        return copyToUpdate;
    }

    public Copy delete(String id)throws DeleteException{
        if (!copyDao.exist(id))
            throw new DeleteException();

        Copy ouput = copyDao.get(id);

        copyDao.delete(id);

        return ouput;

    }

    public Copy get(String id) throws ReadErrorException {
        if (!copyDao.exist(id))
            throw new ReadErrorException();

        return copyDao.get(id);
    }

    public List<Copy> getAll() throws EmptyListException {
        List<Copy> copies = copyDao.getAll();
        if (CollectionUtils.isEmpty(copies)) {
            throw new EmptyListException();
        }
        return copies;

    }

    public boolean exist(String id){
        return copyDao.exist(id);
    }

    // TODO: 7/5/2017 crear test 
    /*public List<Copy> getAllAviableCopiesByTitleId(String id){
        return null;
    }
    public Copy getCopyWithClosestDueOfTitleId(String id){
        return null;
    }*/
}
