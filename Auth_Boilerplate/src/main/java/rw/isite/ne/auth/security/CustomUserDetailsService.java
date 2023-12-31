package rw.isite.ne.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rw.isite.ne.auth.exceptions.BadRequestException;
import rw.isite.ne.auth.models.Customer;
import rw.isite.ne.auth.repositories.IUserRepository;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final IUserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDetails loadByUserId(UUID id) {
        Customer user = this.userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Customer not found with id: " + id));
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserByUsername(String s) throws BadRequestException {
        Customer user = userRepository.findByEmailOrPhoneNumber(s, s).orElseThrow(() -> new UsernameNotFoundException("user not found with email or mobile of " + s));

        return UserPrincipal.create(user);
    }
}
