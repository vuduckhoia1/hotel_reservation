package booking.security;

import booking.model.User;
import booking.model.UserDTO;

public interface IUserService {

	  User registerNewUserAccount(UserDTO accountDto);
}
