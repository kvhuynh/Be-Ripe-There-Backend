package com.kvhuynh.server.models.recipes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipes")
public class Recipe  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @NotEmpty(message = "First Name is required!")
    // @Size(min = 3, max = 30, message = "name must be between 3 and 30 characters")
    private String recipeName;

    // @NotEmpty(message = "Email is required!")
    // @Email(message = "Please enter a valid email!")
    private String recipeDescription;

    // @NotEmpty(message = "Password is required!")
    private Double carbohydrateAmount;

    @Column
    private Double calorieAmount;

    @Column
    private Double proteinAmount;

    @Column
    private Double fatAmount;

    @Column
    private String imageUrl;

    @OneToMany(mappedBy="recipe", fetch = FetchType.LAZY)
	private List<Ingredient> ingredients;
    // @Column(updatable = false)
    // @DateTimeFormat(pattern = "yyyy-MM-dd")
    // private Date createdAt;

    // @DateTimeFormat(pattern = "yyyy-MM-dd")
    // private Date updatedAt;

    // @ManyToMany(fetch = FetchType.LAZY)
	// @JoinTable(
	// 	name = "users_favorite_recipes",
	// 	joinColumns = @JoinColumn(name = "recipe_id"),
	// 	inverseJoinColumns = @JoinColumn(name = "user_id")
	// )
	// private List<User> users;

    // @PrePersist
    // protected void onCreate() {
    //     this.createdAt = new Date();
    // }

    // @PreUpdate
    // protected void onUpdate() {
    //     this.updatedAt = new Date();
    // }

}