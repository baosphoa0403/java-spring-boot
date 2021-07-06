package com.giabao.mapper;

import com.giabao.dto.StatusDTO;
import com.giabao.entity.StatusEntity;


public class StatusMapper {
    public StatusDTO convertStatusEnityToStatusDTO(StatusEntity statusEntity){
        return new StatusDTO(statusEntity.getStatusID(), statusEntity.getStatusName());
    }
}
