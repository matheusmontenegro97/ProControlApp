package ifpe.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifpe.br.model.UsuarioPromotor;

@Repository
public interface UsuarioRepositoryPromotor extends JpaRepository<UsuarioPromotor, String> {

	UsuarioPromotor findByLoginAndPassword(String login, String password);
}
