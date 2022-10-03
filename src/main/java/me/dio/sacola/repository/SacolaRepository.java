package me.dio.sacola.repository;

import me.dio.sacola.model.Sacola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                             // <>: Generics // Primeiro é o tipo de classe que é uma entidade do BD que eu desejo acessar e o segundo o tipo do ID
public interface SacolaRepository extends JpaRepository <Sacola, Long> {
}
