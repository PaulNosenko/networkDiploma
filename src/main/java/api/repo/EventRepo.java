package api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.entity.Event;
@Repository
public interface EventRepo extends JpaRepository<Event, Long>{

	Event findById(long id);
	
	List<Event> findByWhoInvitesId(long id);

	List<Event> findByBeeingInvitedId(long id);
	
}
