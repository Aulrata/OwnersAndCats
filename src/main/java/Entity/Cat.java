package Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
        Friends = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer _id;

    @Setter

    @JoinColumn(name = "owner_id", referencedColumnName = "_id")
    public Integer OwnerId;

    @Setter
    public String Name;

    @Setter
    public String Breed;

    @Setter
    public LocalDate Birthday;

    @Setter
    public CatColor Color;

    @ManyToMany
    public ArrayList<Cat> Friends;


}
