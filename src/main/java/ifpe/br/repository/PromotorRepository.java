package ifpe.br.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ifpe.br.model.Promotor;

@Repository
public interface PromotorRepository extends JpaRepository<Promotor, Long>{

	@Query(value = "SELECT * FROM PROMOTOR p WHERE p.codigo_empresa = :codigoEmpresa", nativeQuery = true)
	public List<Promotor> findPromotoresByCodigoEmpresa(Long codigoEmpresa);
}
