package cl.ubb.service;

import cl.ubb.dao.TitleDao;
import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.DeleteException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.dao.exceptions.UpdateException;
import cl.ubb.model.Title;
import cl.ubb.service.exceptions.EmptyListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Felipe on 5/29/2017.
 */
@Service
public class TitleService {

    @Autowired
    private TitleDao titleDao;

    public List<Title> getAllTitlesForSubject(String subjectId) throws EmptyListException {
        List<Title>output = titleDao.getBySubject(subjectId);
        if(CollectionUtils.isEmpty(output))
            throw new EmptyListException();

        for(Title title : output){
            title.setReplacementCost("");
        }

        return output;
    }

    public void create(Title title) throws CreateException {
        if (titleDao.exist(title.getIdentifier()))
            throw new CreateException();
        titleDao.create(title);
    }

    public Title delete(String id) throws DeleteException {

        if (!titleDao.exist(id))
            throw new DeleteException();
        Title output = titleDao.get(id);
        titleDao.delete(id);

        return output;
    }

    public Title update(Title title) throws ReadErrorException, UpdateException {
        if (!titleDao.exist(title.getIdentifier()))
            throw new ReadErrorException();

        Title titleToUpdate = titleDao.get(title.getIdentifier());
        titleToUpdate.setCopies(title.getCopies());
        titleToUpdate.setFormat(title.getFormat());
        titleToUpdate.setName(title.getName());
        titleToUpdate.setReplacementCost(title.getReplacementCost());
        titleToUpdate.setSubject(title.getSubject());
        titleToUpdate.setTitleCategory(title.getTitleCategory());

        titleDao.update(titleToUpdate);

        return titleToUpdate;
    }


    public Title get(String id) throws ReadErrorException {
        if (!titleDao.exist(id))
            throw new ReadErrorException();
        return titleDao.get(id);
    }

    public List<Title> getAll() throws EmptyListException {
        List<Title> titles =  titleDao.getAll();
        if (CollectionUtils.isEmpty(titles)) {
            throw new EmptyListException();
        }
        return titles;
    }
}
