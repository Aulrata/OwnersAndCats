package DAO;

import Entity.Cat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CatRepository
{
    private final EntityManagerFactory entityManagerFactory;

    public CatRepository(EntityManagerFactory entityManagerFactory1)
    {

        this.entityManagerFactory = entityManagerFactory1;
    }

    public void Create(Cat cat)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try
        {
            transaction.begin();
            entityManager.persist(cat);
            transaction.commit();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void Update(Cat cat)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        try
        {
            transaction.begin();
            entityManager.merge(cat);
            transaction.commit();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public Cat FindById(Integer _id)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Cat cat = null;
        try
        {
            transaction.begin();
            cat = entityManager.find(Cat.class, _id);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        }
        finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return cat;
    }
}
