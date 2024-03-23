package Service;

import DAO.OwnerRepository;
import Entity.Owner;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;

public class OwnerService
{
    private final OwnerRepository _ownerRepository = new OwnerRepository();

    public void CreateOwner(String name, LocalDate birthday)
    {
        Owner owner = new Owner(name, birthday);

        _ownerRepository.Create(owner);
    }

    public void AddCatToOwner(Integer ownerId, Integer catId)
    {

    }
}
