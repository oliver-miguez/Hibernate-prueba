package Model;
import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
@Entity
@Table(name = "adestrador")
public class AdestradorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "nacemento", length = 100)
    private Date nacemento;

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

    public String toString(){
        return "Id: "+ getId() + "Nome: "+ getNome()+ " Nacemento: "+ getNacemento();
    }


}
