package com.giabao.service;

import com.giabao.dto.RoleDTO;
import com.giabao.entity.RoleEntity;
import com.giabao.mapper.RoleMapper;
import com.giabao.repository.InterfaceRoleReqository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoleServiceImp implements InterfaceRoleService {

    @Autowired
    InterfaceRoleReqository roleReqository;

    @Override
    public Iterable<RoleDTO> findAll() {
        ArrayList<RoleDTO> list = new ArrayList<>();
        RoleMapper mapper = new RoleMapper();
        for (RoleEntity r : roleReqository.findAll()){
            list.add(mapper.convertRoleEnityToRoleDTO(r));
        }
        return list;
    }

    @Override
    public RoleDTO findById(Integer id) {
        RoleEntity roleEntity = roleReqository.getById(id);
        RoleMapper mapper = new RoleMapper();
        return mapper.convertRoleEnityToRoleDTO(roleEntity);
    }

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }

    public RoleEntity addRoleToUser(int roleID, int userID){
        return null;
    }



}
