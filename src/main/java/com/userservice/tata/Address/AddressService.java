package com.userservice.tata.Address;
import com.userservice.tata.Bases.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AddressService extends BaseService<AddressEntity> implements AddressInterFace {
    @Autowired
    private AddressRepo addressRepo;

    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }
    public List<AddressEntity> getList(String filter,int pageNum,int pageSize) throws Exception{
        Specification<AddressEntity> specification = super.createFilter(AddressEntity.class,filter);
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return addressRepo.findAll(specification,pageable).getContent();
    }
    @Override
    public boolean makeActive(long addressId) throws Exception {
        boolean res = super.checkExist(AddressEntity.class,"e.AddressID@" + addressId + ";e.AddressStatus@0");
        if(res){
            int resRepo = addressRepo.active(addressId);
            if(resRepo == 1){
                return true;
            }
            return false;
        }
        return false;
    }

}