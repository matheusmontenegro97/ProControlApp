package ifpe.br.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifpe.br.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, UUID>{

}
