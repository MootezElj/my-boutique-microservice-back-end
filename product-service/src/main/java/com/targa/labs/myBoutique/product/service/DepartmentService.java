package com.targa.labs.myBoutique.product.service;

import com.targa.labs.myBoutique.commons.dto.DepartmentDto;
import com.targa.labs.myBoutique.product.domain.Category;
import com.targa.labs.myBoutique.product.domain.Department;
import com.targa.labs.myBoutique.product.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<DepartmentDto> findAll(){
        log.debug("Request to find all Departments:{} ");
        return this.departmentRepository.findAll()
                .stream().map(DepartmentService::mapToDto)
                .collect(Collectors.toList());
    }


    public static DepartmentDto mapToDto(Department department) {
        if (department != null) {
            return new DepartmentDto(
                    department.getId(),
                    department.getDepName(),
                    department.getDescription(),
                    department.getImage()
            );
        }
        return null;
    }
}
