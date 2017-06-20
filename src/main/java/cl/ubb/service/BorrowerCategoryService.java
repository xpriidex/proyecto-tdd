package cl.ubb.service;

import cl.ubb.dao.BorrowerCategoryDao;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.DeleteException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.dao.exceptions.UpdateException;
import cl.ubb.model.BorrowerCategory;
import cl.ubb.service.exceptions.EmptyListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Felipe on 6/19/2017.
 */
@Service
public class BorrowerCategoryService {

    @Autowired
    private BorrowerCategoryDao borrowerCategoryDao;

    public void createBorrowerCategory(BorrowerCategory borrowerCategory)throws CreateException{
        if (borrowerCategoryDao.exist(borrowerCategory.getIndentifier()))
            throw new CreateException();

        borrowerCategoryDao.create(borrowerCategory);

    }

    public BorrowerCategory updateBorrowerCategory(BorrowerCategory borrowerCategory)throws UpdateException{
        if (!borrowerCategoryDao.exist(borrowerCategory.getIndentifier()))
            throw new UpdateException();

        BorrowerCategory borrowerCategoryToUpdate = borrowerCategoryDao.get(borrowerCategory.getIndentifier());
        borrowerCategoryToUpdate.setName(borrowerCategory.getName());
        borrowerCategoryToUpdate.setMaxNumberOfLoans(borrowerCategory.getMaxNumberOfLoans());
        borrowerCategoryToUpdate.setBorrowers(borrowerCategory.getBorrowers());
        borrowerCategoryToUpdate.setLoanConditions(borrowerCategory.getLoanConditions());


        borrowerCategoryDao.update(borrowerCategoryToUpdate);

        return borrowerCategoryToUpdate;
    }

    public BorrowerCategory deleteBorrowerCategory(String id)throws DeleteException{
        if (!borrowerCategoryDao.exist(id))
            throw new DeleteException();

        BorrowerCategory ouput = borrowerCategoryDao.get(id);

        borrowerCategoryDao.delete(id);

        return ouput;

    }

    public BorrowerCategory getBorrowerCategory(String id) throws ReadErrorException {
        if (!borrowerCategoryDao.exist(id))
            throw new ReadErrorException();
        return borrowerCategoryDao.get(id);

    }

    public List<BorrowerCategory> getAllBorrowerCategory() throws EmptyListException {
        List<BorrowerCategory> borrowerCategories = borrowerCategoryDao.getAll();
        if (CollectionUtils.isEmpty(borrowerCategories)) {
            throw new EmptyListException();
        }
        return borrowerCategories;

    }

    public boolean existBorrowerCategory(String id){
        return borrowerCategoryDao.exist(id);
    }

}
