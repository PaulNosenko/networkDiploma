package api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	User findById(long id);
	
}
