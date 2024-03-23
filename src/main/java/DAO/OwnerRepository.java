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
}
