package uy.utec.semana3repartido1.service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uy.utec.semana3repartido1.model.Usuario;
import uy.utec.semana3repartido1.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Service
public class CustomUsuarioDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    public CustomUsuarioDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles("ADMIN".equals(user.getRole())? "ADMIN" : "USER")
                .build();
    }
}
