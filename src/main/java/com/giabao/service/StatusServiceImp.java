package com.giabao.service;

import com.giabao.dto.RoleDTO;
import com.giabao.dto.StatusDTO;
import com.giabao.entity.StatusEntity;
import com.giabao.mapper.StatusMapper;
import com.giabao.repository.InterfaceStatusReqository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StatusServiceImp implements InterfaceStatusService{

    @Autowired
    InterfaceStatusReqository statusReqository;

    @Override
    public Iterable<StatusDTO> findAll() {
        ArrayList<StatusDTO> list = new ArrayList<>();
        statusReqository.findAll().forEach((StatusEntity s) -> {
            list.add(new StatusMapper().convertStatusEnityToStatusDTO(s));
        });
        return list;
    }

    @Override
    public StatusDTO findById(Integer id) {
        StatusEntity s = statusReqository.getById(id);
        StatusDTO a = new StatusMapper().convertStatusEnityToStatusDTO(s);
        return a;
    }

    @Override
    public StatusDTO save(StatusDTO statusDTO) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
