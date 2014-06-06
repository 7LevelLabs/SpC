package ua.ll7.slot21.spc.dao.impl;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ua.ll7.slot21.spc.dao.ADao;
import ua.ll7.slot21.spc.dao.IF2Dao;
import ua.ll7.slot21.spc.model.F2;

/**
 * @author Alex Velichko
 *         03.06.14 : 14:15
 */
@Repository
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class F2DaoImpl extends ADao<F2> implements IF2Dao {

}
