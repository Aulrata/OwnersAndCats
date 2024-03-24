import DAO.OwnerRepository;
import Entity.Owner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OwnerRepositoryTest
{
    @Mock
    private EntityManagerFactory entityManagerFactory;

    @Mock
    private EntityManager entityManager;

    @Mock
    private EntityTransaction transaction;

    private OwnerRepository ownerRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ownerRepository = new OwnerRepository(entityManagerFactory);
    }

    @Test
    public void testInsert() {
        Owner owner = new Owner();
        when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        when(entityManager.getTransaction()).thenReturn(transaction);

        ownerRepository.Create(owner);

        verify(entityManager).persist(owner);
        verify(transaction).commit();
        verify(entityManager).close();
        verify(entityManagerFactory).close();
    }

    @Test
    public void testGetHostByName() {
        Integer id = 1;
        Owner owner = new Owner();
        when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        when(entityManager.getTransaction()).thenReturn(transaction);
        when(entityManager.find(Owner.class, id)).thenReturn(owner);

        Owner result = ownerRepository.FindById(id);

        verify(entityManager).find(Owner.class, id);
        verify(transaction).commit();
        verify(entityManager).close();
        verify(entityManagerFactory).close();
        assertEquals(owner, result);
    }

    @Test
    public void testUpdate() {
        Owner owner = new Owner();
        when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        when(entityManager.getTransaction()).thenReturn(transaction);

        ownerRepository.Update(owner);

        verify(entityManager).merge(owner);
        verify(transaction).commit();
        verify(entityManager).close();
        verify(entityManagerFactory).close();
    }
}
