package cl.ubb.dao.daoImpl;

import cl.ubb.model.Borrower;
import cl.ubb.service.exceptions.CreateException;
import cl.ubb.service.exceptions.DeleteException;
import cl.ubb.service.exceptions.UpdateException;

import java.util.List;

/**
 * Created by Felipe Cifuentes on 24-05-2017.
 */
public class BorrowerDao {
    public void create(Borrower borrower) throws CreateException {

    }

    public void update (Borrower borrower)throws UpdateException{

    }
    public Borrower delete(String id)throws DeleteException{
        return new Borrower("","","","");
    }
    public Borrower get(String id){
        return  null;
    }
    public List<Borrower>getAll(){
        return null;
    }
    public boolean exist(String id){
        return true;
    }
}
