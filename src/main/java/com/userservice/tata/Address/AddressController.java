package com.userservice.tata.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private  AddressService addressService;
    @GetMapping("/find")
    public List<?> getFilteredAddresses() throws Exception {
//        String filter = "e.AddressStatus@eq1;";
        String filter = "e.deleted@eq0;e.Address@eqNiavaran";
        return addressService.getList(filter,1,5);
    }
    @GetMapping("/test")
    public String test() throws Exception {
        return addressService.test();
    }
}
