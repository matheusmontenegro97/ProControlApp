package ifpe.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifpe.br.model.UsuarioEmpresa;

@Repository
public interface UsuarioRepositoryEmpresa extends JpaRepository<UsuarioEmpresa, String> {

	UsuarioEmpresa findByLoginAndPassword(String login, String password);
}
