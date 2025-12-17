package com.example.demo.newservice.newserviceimpl;

import java.util.List;
import org.springframework.steretype.Service;
import com.example.demo.newservice.NewfileService;
import com.example.demo.newrepository.NewfileRepo;
import com.example.demo.newservice.NewfileService;

@Service
public class NewfileServiceImpl implements NewfileService{

    private final NewfileRepo rep;

    public NewfileSerivceImpl(NewfileRepo rep){
        this.rep = rep;
    }
    @Override
    public NewfileEntity savedata(NewfileEntity newfile){
        return rep.save(newfile);
    }
    @Override
    public NewfileEntity getidval(Long id){
        return rep.findByid(id)
    }

    
}
