package dao;

import javax.persistence.EntityManager;

/**
 * Código desenvolvido por Christiam Masdeval
 * @author Christiam Masdeval
 * 
 * Adaptado por @tgmarinho
 *
 */

public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
    }

    public void edit(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();
    }

    public void remove(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(getEntityManager().merge(entity));
        getEntityManager().getTransaction().commit();
    }

    public T find(Object id) {
        getEntityManager().getTransaction().begin();
        T aux = getEntityManager().find(entityClass, id);
        getEntityManager().getTransaction().commit();
        return aux;
    }
}