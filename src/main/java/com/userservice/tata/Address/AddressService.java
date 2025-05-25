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

    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @Override
    protected List<String> getConstraint(List filter) throws Exception {
        List <String> list = new ArrayList<String>();
        list.add("e.AddressStatus@0");
        return super.getConstraint(list);
    }
}