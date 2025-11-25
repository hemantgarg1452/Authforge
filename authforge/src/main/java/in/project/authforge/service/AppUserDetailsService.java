package in.project.authforge.service;

import in.project.authforge.entity.UserEntity;
import in.project.authforge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity existingUser = repo.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("Email not found fir the email: "+email));
        return new User(existingUser.getEmail(), existingUser.getPassword(), new ArrayList<>());
    }
}
