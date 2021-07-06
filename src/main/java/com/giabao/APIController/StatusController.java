package com.giabao.APIController;

import com.giabao.dto.RoleDTO;
import com.giabao.dto.StatusDTO;
import com.giabao.dto.StudentDTO;
import com.giabao.service.InterfaceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/status")
public class StatusController {

    @Autowired
    InterfaceStatusService statusService;

    @GetMapping
    public Iterable<StatusDTO> getAll() {
        return statusService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDTO> getStudentByID(@PathVariable(value = "id") Integer id) {
        StatusDTO a = this.statusService.findById(id);
        return ResponseEntity.ok(a);
    }


}
