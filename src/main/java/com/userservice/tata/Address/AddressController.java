package com.userservice.tata.Address;

import com.userservice.tata.Util.Remote;
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
//        String filter = "e.JoinPerson.personId@eq1;e.AddressStatus@eq1;";
//        String filter = "e.JoinPerson.personId@eq1;e.deleted@eq0";
        String filter = "";
        AddressInterFace addressInterFace = (AddressInterFace) Remote.makeRemote(AddressInterFace.class);
        return addressInterFace.getList(filter,1,5);
    }
    @GetMapping("/test")
    public String test() throws Exception {
        return addressService.test();
    }
}
