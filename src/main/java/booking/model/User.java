package booking.model;

import javax.persistence.*;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="user")
@RequiredArgsConstructor
public class User {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;

	private String role;
	private boolean enabled;


	
	
}
