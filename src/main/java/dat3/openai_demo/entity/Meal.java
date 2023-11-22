package dat3.openai_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor @Getter @Setter @AllArgsConstructor

@Entity
@Table(name="Meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String mealType;
    String title;

    @ManyToMany
    @JoinTable(
            name = "meal_ingredients", // Navnet på join-tabellen
            joinColumns = @JoinColumn(name = "meal_id"), // Kolonnen i join-tabellen, der refererer til `User`
            inverseJoinColumns = @JoinColumn(name = "ingredient_name") // Kolonnen i join-tabellen, der refererer til `Allergy`
    )
    List<Ingredient> ingredients;

    String instructions;
    int calories;
    int protein;
    int carbs;
    int fat;


    public Meal(String mealType, String title, String instructions, int calories, int protein, int carbs, int fat) {
        this.mealType = mealType;
        this.title = title;
        this.instructions = instructions;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }

    public Meal(String mealType, String title, List<Ingredient> ingredients, String instructions, int calories, int protein, int carbs, int fat) {
        this.mealType = mealType;
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }
}
