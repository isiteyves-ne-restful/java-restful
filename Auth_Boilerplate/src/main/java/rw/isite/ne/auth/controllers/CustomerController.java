package rw.isite.ne.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rw.isite.ne.auth.dtos.SignUpDTO;
import rw.isite.ne.auth.enums.ERole;
import rw.isite.ne.auth.models.Customer;
import rw.isite.ne.auth.payload.ApiResponse;
import rw.isite.ne.auth.services.IUserService;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/users")
public class CustomerController {

    private final IUserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public CustomerController(IUserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping(path = "/current-user")
    public ResponseEntity<ApiResponse> currentlyLoggedInUser() {
        return ResponseEntity.ok(new ApiResponse(true, userService.getLoggedInUser()));
    }

    @PostMapping(path = "/register")
    public ResponseEntity<ApiResponse> registerAsStandard(@Valid @RequestBody SignUpDTO dto) {

        return getApiResponseResponseEntity(dto);
    }

    private ResponseEntity<ApiResponse> getApiResponseResponseEntity(@RequestBody @Valid SignUpDTO dto) {
        Customer user = new Customer();
        System.out.println("The password received is..." + dto.getPassword());

        String encodedPassword = bCryptPasswordEncoder.encode(dto.getPassword());

        user.setEmail(dto.getEmail());
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setPhoneNumber(dto.getMobile());
        user.setPassword(encodedPassword);

        Customer entity = this.userService.create(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, entity));
    }

    @PostMapping(path = "/register/as-admin")
    public ResponseEntity<ApiResponse> registerAsAdmin(@Valid @RequestBody SignUpDTO dto) {

        return getApiResponseResponseEntity(dto);
    }

    @GetMapping(path = "/routes/admin")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<ApiResponse> adminRoute(){
        return ResponseEntity.ok(ApiResponse.success("Admin route"));
    }

    @GetMapping(path = "/routes/customer")
    public ResponseEntity<ApiResponse> standardRoute(){
        return ResponseEntity.ok(ApiResponse.success("Standard route"));
    }
}