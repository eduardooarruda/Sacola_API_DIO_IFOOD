package me.dio.sacola.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.sacola.enumeration.FormaPagamento;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor //Cria um construtor com todos os parâmetros
@Builder // É um padrão de design patterns
@Data // Cria os Gets e Sets de cada atributo da Classe
@Entity // Faz com que a Classe vire uma entidade no Banco de dados
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Para ignorar alguns erros que podem vi em decorrência do hibernate que foi inicializado como Lazy
@NoArgsConstructor //Cria um construtor sem parâmetros
public class Sacola {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore // Para não aparecer alguns erros que podem vi do Front-End com o Javascript
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itens;
    private Double valorTotal;
    @Enumerated
    private FormaPagamento FormaPagamento;
    private boolean fechada;

}
