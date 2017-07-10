package cl.ubb.dao;

import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.DeleteException;
import cl.ubb.dao.exceptions.UpdateException;
import cl.ubb.model.Loan;
import cl.ubb.model.LoanCondition;

import java.util.List;

/**
 * Created by Felipe Cifuentes on 10-07-2017.
 */
public interface LoanConditionDao {

    public void create(LoanCondition loanCondition)throws CreateException;

    public void update(LoanCondition loanCondition)throws UpdateException;

    public LoanCondition delete(String id)throws DeleteException;

    public LoanCondition get (String id);

    public List<LoanCondition> getAll();

    public boolean exist(String id);
}
