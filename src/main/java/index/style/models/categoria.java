package index.style.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "categorias")
public class categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcat;

    @Column
    private String nomcat;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<producto> productos;

}
