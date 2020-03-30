package com.targa.labs.myBoutique.product.web;

import com.targa.labs.myBoutique.commons.dto.DepartmentDto;
import com.targa.labs.myBoutique.product.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.targa.labs.myBoutique.commons.utils.Web.API;

@RestController
@RequiredArgsConstructor
@RequestMapping(API + "/departments")
public class DepartmentResource {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public List<DepartmentDto> findAll(){
        return this.departmentService.findAll();
    }

}
