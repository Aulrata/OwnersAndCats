package Service;

import DAO.CatRepository;
import Entity.Cat;
import Entity.CatColor;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;

public class CatService
{
    private final CatRepository _catRepository = new CatRepository();

    public void CreateCat(Integer ownerId, String name, String breed, CatColor color, LocalDate birthday)
    {
        Cat cat = new Cat(ownerId, name, breed, color, birthday);
        _catRepository.Create(cat);
    }

    public void ChangeOwner(Integer catId, Integer ownerId)
    {
        Cat cat = _catRepository.FindById(catId);
        cat.setOwnerId(ownerId);
        _catRepository.Update(cat);
    }

}
