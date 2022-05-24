package booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import booking.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{
	@Query(value= "SELECT CASE WHEN (COUNT(*) > 0) THEN 'true' ELSE 'false' END FROM room  WHERE id = :id", nativeQuery = true)
	boolean checkIdExist(@Param("id")long id);
}
