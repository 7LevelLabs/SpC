package ua.ll7.slot21.spc.dao.impl;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ua.ll7.slot21.spc.dao.ADao;
import ua.ll7.slot21.spc.dao.IF1Dao;
import ua.ll7.slot21.spc.model.F1;

/**
 * @author Alex Velichko
 *         03.06.14 : 13:58
 */
@Repository
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class F1DaoImpl extends ADao<F1> implements IF1Dao {

}
