package rw.isite.ne.auth.security.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import rw.isite.ne.auth.exceptions.BadRequestException;
import rw.isite.ne.auth.exceptions.ResourceNotFoundException;
import rw.isite.ne.auth.models.Customer;
import rw.isite.ne.auth.repositories.IUserRepository;
import rw.isite.ne.auth.services.IUserService;

import java.util.*;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserServiceImpl( IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Customer create(Customer user) {
        validateNewRegistration(user);

        return this.userRepository.save(user);
    }

    @Override
    public boolean isNotUnique(Customer user) {
        Optional<Customer> userOptional = this.userRepository.findByEmailOrPhoneNumber(user.getEmail(), user.getPhoneNumber());
        return userOptional.isPresent();
    }

    @Override
    public void validateNewRegistration(Customer user) {
        if (isNotUnique(user)) {
            throw new BadRequestException(String.format("Customer with email '%s' or phone number '%s' already exists", user.getEmail(), user.getPhoneNumber()));
        }
    }

    @Override
    public Customer getLoggedInUser() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() == "anonymousUser")
            throw new BadRequestException("You are not logged in, try to log in");

        String email;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            email = ((UserDetails) principal).getUsername();
        } else {
            email = principal.toString();
        }

        return userRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "id", email));
    }
}
