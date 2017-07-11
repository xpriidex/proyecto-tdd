package cl.ubb.dao;

import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.DeleteException;
import cl.ubb.dao.exceptions.UpdateException;
import cl.ubb.model.SuspensionRules;

import java.util.List;

/**
 * Created by Felipe Cifuentes on 11-07-2017.
 */
public interface SuspensionRulesDao {

    public SuspensionRules create(SuspensionRules suspensionRules) throws CreateException;

    public SuspensionRules update(SuspensionRules suspensionRules) throws UpdateException;

    public SuspensionRules delete(SuspensionRules suspensionRules) throws DeleteException;

    public SuspensionRules get(String id);

    public boolean exist(String id);

    public List<SuspensionRules> getAll();
}
