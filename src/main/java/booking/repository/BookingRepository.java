package booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import booking.model.Booking;


public interface BookingRepository extends JpaRepository<Booking, Long> {

}

