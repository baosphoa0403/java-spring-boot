package com.giabao.repository;

import com.giabao.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceStatusReqository extends JpaRepository<StatusEntity, Integer> {
}
