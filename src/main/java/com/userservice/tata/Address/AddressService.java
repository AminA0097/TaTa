package com.userservice.tata.Address;
import com.userservice.tata.Bases.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AddressService extends BaseService<AddressEntity> implements AddressInterFace {
    @Autowired
    private AddressRepo addressRepo;
    @Override
    protected List<String> getConstraint() throws Exception {
        List<String> filters =  super.getConstraint();
        filters.add("e.AddressStatus@eq1");
        return filters;
    }
}