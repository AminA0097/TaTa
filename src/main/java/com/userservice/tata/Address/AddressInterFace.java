package com.userservice.tata.Address;
import com.userservice.tata.Bases.BaseInterFace;
public interface AddressInterFace extends BaseInterFace<AddressEntity> {
    public boolean makeActive(long addressId)throws Exception;

}