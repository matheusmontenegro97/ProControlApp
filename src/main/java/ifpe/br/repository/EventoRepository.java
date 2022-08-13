package ifpe.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifpe.br.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{

}
