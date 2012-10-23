
package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Código desenvolvido por Christiam Masdeval
 * @author Christiam Masdeval
 * 
 * Adaptado por @tgmarinho
 *
 */

@Entity
@Table(name="onibus")
@XmlRootElement
public class Onibus {

	
    @Column(nullable=false,unique=true)
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;
    @Column(nullable=false)
    private String nome;
    @Column(nullable=true)
    private Double latitude;
    @Column(nullable=true)
    private Double longitude;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    
}
