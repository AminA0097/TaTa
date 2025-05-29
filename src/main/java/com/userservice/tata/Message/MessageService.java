package com.userservice.tata.Message;

import com.userservice.tata.Bases.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService extends BaseService {
    @Override
    protected List<String> getConstraint() throws Exception {
        List<String> filters =  super.getConstraint();
        filters.add("e.receiver@eq" + 1);
        return filters;
    }
}
