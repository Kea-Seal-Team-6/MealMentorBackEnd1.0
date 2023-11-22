package dat3.openai_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor @Getter @Setter @AllArgsConstructor

@Entity
@Table(name="Ingredients")
public class Ingredient {
    @Id
    String name;

    @ManyToMany(mappedBy = "ingredients")
    List<Meal> meals;

    public Ingredient(String name) {
        this.name = name;
    }
}
