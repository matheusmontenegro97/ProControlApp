package ifpe.br.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ifpe.br.model.Promotor;
import ifpe.br.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	@Query("SELECT p from Promotor p WHERE p.codigoEmpresa = codigoEmpresa")
	public List<Promotor> findPromotoresByCodigoEmpresa(Long codigoEmpresa);
}
