package com.userservice.tata.Address;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @GetMapping("/find")
    public List<AddressEntity> getFilteredAddresses() throws Exception {
        String filter = "e.AddressStatus@1;";
        return addressService.getList(filter,0,2);
    }
    @GetMapping("/active")
    public boolean checkDone() throws Exception {
        return addressService.makeActive(1);
    }
    @GetMapping("/test")
    public String test() throws Exception {
        return addressService.test();
    }
}
