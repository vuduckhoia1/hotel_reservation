package booking.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {

	    @NotNull
	    @NotEmpty
	    private String username;
	    

	    
	    @NotNull
	    @NotEmpty
	    private String password;

	
	    
	    // standard getters and setters
	
}
