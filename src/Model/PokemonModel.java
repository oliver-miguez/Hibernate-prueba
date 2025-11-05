package Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Model de pokemon
 */

@Entity
@Table(name = "pokemon")
public class PokemonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "nome")
    String nome;

    @Column(name = "nacemento")
    Date nacemento;

    @OneToOne
    @JoinColumn(name = "pokedexentry")
    PokedexModel pokedexentry;

    @ManyToOne
    @JoinColumn(name = "adestrador")
    AdestradorModel adestrador;

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

    public Date getNacemento() {
        return nacemento;
    }

    public void setNacemento(Date nacemento) {
        this.nacemento = nacemento;
    }

    public PokedexModel getPokedexentry() {
        return pokedexentry;
    }

    public void setPokedexentry(PokedexModel pokedexentry) {
        this.pokedexentry = pokedexentry;
    }

    public AdestradorModel getAdestrador() {
        return adestrador;
    }

    public void setAdestrador(AdestradorModel adestrador) {
        this.adestrador = adestrador;
    }

    public String toString(){
        return "Id: "+ getId()+ "Nome: "+ getNome()+ " Nacemento: "+ getNacemento()+ " PokedexEntry: "+ getPokedexentry()+ " Adestrador: "+ getAdestrador();
    }
}
