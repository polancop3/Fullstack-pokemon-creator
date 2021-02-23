package com.example.server.model;




import javax.persistence.*;

@Entity
@Table(name="pokemon_name")
public class Pokemons {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String type;
    @Column
    private int level;
    @Column
    private Boolean found;
    @Column
    private String ability;

    public Pokemons(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Boolean getFound() {
        return found;
    }

    public void setFound(Boolean found) {
        this.found = found;
    }
}
