package DAO;

import Entity.Cat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CatRepository
{
    private final EntityManagerFactory entityManagerFactory;

    public CatRepository()
    {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("DB");
    }

    public void Create(Cat cat) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(cat);
            transaction.commit();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
