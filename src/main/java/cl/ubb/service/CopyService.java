package cl.ubb.service;

import cl.ubb.dao.CopyDao;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.DeleteException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.dao.exceptions.UpdateException;
import cl.ubb.model.Copy;
import cl.ubb.model.Subject;
import cl.ubb.service.exceptions.EmptyListException;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Copies;
import java.util.List;

/**
 * Created by Felipe Cifuentes on 05-06-2017.
 */
@Service
public class CopyService {
    private CopyDao copyDao;


    public void create(Copy copy)throws CreateException{

    }

    public void update(Copy copy)throws UpdateException{

    }

    public Copy delete(String id)throws DeleteException{
        return null;
    }

    public Copy get (String id){
        return null;
    }

    public List<Subject> getAll(){
        return null;
    }

    public boolean exist(String id){
        return false;
    }
   
    public List<Copy> getAllAviableCopiesByTitleId(String id){
        return null;
    }
    public Copy getCopyWithClosestDueOfTitleId(String id){
        return null;
    }
}
