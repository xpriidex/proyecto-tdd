package cl.ubb.service;

import cl.ubb.dao.SuspensionRulesDao;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.SuspensionRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Felipe Cifuentes on 11-07-2017.
 */
@Service
public class SuspensionRulesService {
    @Autowired
    private SuspensionRulesDao suspensionRulesDao;

    public SuspensionRules get(String id) throws ReadErrorException {
        if (!suspensionRulesDao.exist(id))
            throw new ReadErrorException();

        return suspensionRulesDao.get(id);
    }

}
