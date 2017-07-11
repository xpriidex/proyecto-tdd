package cl.ubb.service;

import cl.ubb.dao.LoanConditionDao;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.dao.exceptions.UpdateException;
import cl.ubb.model.LoanCondition;
import cl.ubb.service.exceptions.EmptyListException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Felipe Cifuentes on 10-07-2017.
 */
public class LoanConditionService {

    @Autowired
    private LoanConditionDao loanConditionDao;

    public LinkedList<LoanCondition> getAll() throws EmptyListException {
        List<LoanCondition> subjects = (List<LoanCondition>) loanConditionDao.getAll();
        if (subjects.size() == 0) {
            throw new EmptyListException();
        }
        return (LinkedList<LoanCondition>) loanConditionDao.getAll();
    }

    public LoanCondition get(String id) throws ReadErrorException {
        if (!loanConditionDao.exist(id))
            throw new ReadErrorException();

        return loanConditionDao.get(id);
    }

    public void create(LoanCondition loanCondition) throws CreateException {
        if (!loanConditionDao.exist(loanCondition.getIdentifier()))
            throw new CreateException();
        loanConditionDao.create(loanCondition);
    }

    public LoanCondition update(LoanCondition loanCondition) throws ReadErrorException, UpdateException {
        if (!loanConditionDao.exist(loanCondition.getIdentifier()))
            throw new ReadErrorException();

        LoanCondition loanConditionToUpdate = loanConditionDao.get(loanCondition.getIdentifier());
        loanConditionToUpdate.setMaxNumberOfUnitOfTime(loanCondition.getMaxNumberOfUnitOfTime());
        loanConditionToUpdate.setMaxNumberOfRenewals(loanCondition.getMaxNumberOfRenewals());
        loanConditionToUpdate.setUnitOfTime(loanCondition.getUnitOfTime());
        loanConditionToUpdate.setFee(loanCondition.getFee());

        loanConditionDao.update(loanConditionToUpdate);

        return loanConditionToUpdate;
    }

    // TODO: 7/10/2017 delete 


}
