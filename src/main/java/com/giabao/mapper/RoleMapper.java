package com.giabao.mapper;

import com.giabao.dto.RoleDTO;
import com.giabao.entity.RoleEntity;

public class RoleMapper {
    public RoleDTO convertRoleEnityToRoleDTO(RoleEntity roleEntity){
        return new RoleDTO(roleEntity.getRoleID(),roleEntity.getRoleName());
    }
}
