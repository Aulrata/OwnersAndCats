package Entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Entity
@Table(name = "Cats")
public class Cat
{

    public Cat() {}
    public Cat(Integer ownerId, String name, String breed, CatColor color, LocalDate birthday)
    {
        OwnerId = ownerId;
        Name = name;
        Breed = breed;
        Color = color;
        Birthday = birthday;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer _id;


    @JoinColumn(name = "owner_id", referencedColumnName = "_id")
    public Integer OwnerId;

    public String Name;
    public String Breed;
    public LocalDate Birthday;
    public CatColor Color;

    @ManyToMany
    public ArrayList<Cat> Friends;


}
