package DAO;

import Entity.Owner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OwnerRepository
{
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DB");

    public void Create(Owner owner)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try
        {
            transaction.begin();
            entityManager.persist(owner);
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

    public Owner FindById(Integer _id)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Owner owner = null;
        try
        {
            transaction.begin();
            owner = entityManager.find(Owner.class, _id);
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
        return owner;
    }

    public void Update(Owner owner)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try
        {
            transaction.begin();
            entityManager.merge(owner);
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
}
