package com.example.javabarapp.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class CocktailCategoryId implements java.io.Serializable {
    private static final long serialVersionUID = 2361522248875397028L;
    @Column(name = "id_cocktail", nullable = false)
    private Integer idCocktail;

    @Column(name = "id_category", nullable = false)
    private Integer idCategory;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CocktailCategoryId entity = (CocktailCategoryId) o;
        return Objects.equals(this.idCocktail, entity.idCocktail) &&
                Objects.equals(this.idCategory, entity.idCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCocktail, idCategory);
    }

}