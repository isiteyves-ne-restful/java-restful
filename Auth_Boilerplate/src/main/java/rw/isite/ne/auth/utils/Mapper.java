package rw.isite.ne.auth.utils;

import org.modelmapper.ModelMapper;
import rw.isite.ne.auth.models.Customer;

public class Mapper {

    public static ModelMapper modelMapper = new ModelMapper();

    public static Customer getUserFromDTO(Object object) {
        return modelMapper.map(object, Customer.class);
    }


}
