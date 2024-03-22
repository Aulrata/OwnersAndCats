package Controller;

import Entity.CatColor;
import Service.CatService;

import java.time.LocalDate;

public class CatController
{
    private final CatService _catService = new CatService();
    public void CreateCat()
    {
        _catService.CreateCat(1, "Tom", "Jerry", CatColor.Black, LocalDate.now());
    }
}
