package ifpe.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifpe.br.model.Promotor;

@Repository
public interface PromotorRepository extends JpaRepository<Promotor, Long>{

}
