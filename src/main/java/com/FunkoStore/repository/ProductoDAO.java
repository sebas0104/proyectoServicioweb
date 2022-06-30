package  com.FunkoStore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.FunkoStore.model.Producto;

@Repository
public interface ProductoDAO extends CrudRepository<Producto, Long>{

	public List<Producto> findAll();
	
	public Optional<Producto> findById(Long id);
	
}
