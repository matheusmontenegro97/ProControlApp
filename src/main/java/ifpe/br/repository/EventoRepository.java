package ifpe.br.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifpe.br.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{
	List<Evento> findByCodigoEmpresa(Long codigoEmpresa);
	List<Evento> findByCodigoPromotor(Long codigoPromotor);
}
