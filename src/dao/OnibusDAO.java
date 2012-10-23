
package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import pojos.Onibus;

/**
 * Código desenvolvido por Christiam Masdeval
 * @author Christiam Masdeval
 * 
 * Adaptado por @tgmarinho
 *
 */

public class OnibusDAO extends AbstractFacade<Onibus>{
    @PersistenceContext(unitName = "JerseyWebServicePU")
    private EntityManager em;

    public OnibusDAO() {
        super(Onibus.class);
        
        em = Persistence.createEntityManagerFactory("JerseyWebServicePU").createEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

 
    
}
