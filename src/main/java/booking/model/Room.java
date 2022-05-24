package booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
public class Room {
	@Id
	//@GeneratedValue
	private long id; 
	private long hotel_id;
	private String name, type, description;
	private long price;
	
	
}
