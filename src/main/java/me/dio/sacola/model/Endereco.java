package me.dio.sacola.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@AllArgsConstructor
@Builder
@Data
@Embeddable // Toda classe que tiver um atributo Endereco com @Embedded vai "herdar" estes dois atributos para salvar no banco de dados, desta forma não é criado uma tabela Endereco
@NoArgsConstructor
public class Endereco {
    private String cep;
    private String complemento;
}