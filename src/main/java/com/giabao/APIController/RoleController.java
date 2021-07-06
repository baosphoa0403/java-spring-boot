package com.giabao.APIController;

import com.giabao.dto.RoleDTO;
import com.giabao.service.InterfaceRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/role")
public class RoleController {

    @Autowired
    InterfaceRoleService roleService;


    @GetMapping
    public Iterable<RoleDTO> getAll() {
        return roleService.findAll();
    }

}
