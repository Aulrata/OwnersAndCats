package Entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;


@Getter
@Entity
@Table(name = "Owners")
public class Owner
{
    public Owner() {}
    public Owner(String name, LocalDate birthday)
    {
        Name = name;
        Birthday = birthday;
        Cats = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer _id;
    public String Name;
    public LocalDate Birthday;

    @OneToMany(mappedBy = "_id")
    public ArrayList<Cat> Cats;

}
