import DAO.CatRepository;
import Entity.Cat;
import Entity.CatColor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CatRepositoryTest
{
    @Mock
    private EntityManagerFactory entityManagerFactory;
    @Mock
    private EntityManager entityManager;
    @Mock
    private EntityTransaction transaction;
    private CatRepository catRepository;

    @BeforeEach
    public void SetUp() {
        MockitoAnnotations.initMocks(this);
        catRepository = new CatRepository(entityManagerFactory);
    }

    @Test
    public void CreateCatTest() {
        Cat cat = new Cat(1, "Tom", "Jerry", CatColor.Grey, LocalDate.now());
        when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        when(entityManager.getTransaction()).thenReturn(transaction);

        catRepository.Create(cat);

        verify(entityManager).persist(cat);
        verify(transaction).commit();
        verify(entityManager).close();
        verify(entityManagerFactory).close();
    }

    @Test
    public void FindCatByIdTest() {
        Cat cat = new Cat();
        Integer id = 1;
        when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        when(entityManager.getTransaction()).thenReturn(transaction);
        when(entityManager.find(Cat.class, id)).thenReturn(cat);

        Cat result = catRepository.FindById(id);

        verify(entityManager).find(Cat.class, id);
        verify(transaction).commit();
        verify(entityManager).close();
        verify(entityManagerFactory).close();
        assertEquals(cat, result);
    }

    @Test
    public void UpdateTest() {
        Cat cat = new Cat();
        when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        when(entityManager.getTransaction()).thenReturn(transaction);

        catRepository.Update(cat);

        verify(entityManager).merge(cat);
        verify(transaction).commit();
        verify(entityManager).close();
        verify(entityManagerFactory).close();
    }
}
