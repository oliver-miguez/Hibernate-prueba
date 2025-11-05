package Model;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Model de pokedex
 */

@Entity
@Table(name = "pokedex")
public class PokedexModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "nome")
    String nome;

    @Column(name = "peso")
    double peso;

    @Column(name = "misc")
    String misc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    public String toString(){
        return "Id: "+getId()+ " Nome: "+ getNome()+ " Peso: "+ getPeso() + " Misc: "+ getMisc();
    }
}
