package rw.isite.ne.auth.services;


import rw.isite.ne.auth.models.Customer;

public interface IUserService {

    Customer create(Customer user);

    boolean isNotUnique(Customer user);

    void validateNewRegistration(Customer user);

    Customer getLoggedInUser();

}