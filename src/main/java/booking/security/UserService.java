package booking.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import booking.model.CustomUserDetails;
import booking.model.User;
import booking.model.UserDTO;
import booking.repository.UserRepository;

@Service
@Transactional
public class UserService implements UserDetailsService,IUserService  {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Kiểm tra xem user có tồn tại trong database không?
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }
    
    @Override
    public User registerNewUserAccount(UserDTO userDto) throws UserAlreadyExistException {
        if (UsernameExist(userDto.getUsername())) {
            throw new UserAlreadyExistException("There is an account with that email address: " + userDto.getUsername());
        }

        User user = new User();

        user.setUsername(userDto.getUsername());

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));



        return userRepository.save(user);
    }
    private boolean UsernameExist(String username) {
        return userRepository.findByUsername(username) != null;
    }


}