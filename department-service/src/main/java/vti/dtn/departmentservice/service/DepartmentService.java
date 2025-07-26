package vti.dtn.departmentservice.service;

import vti.dtn.departmentservice.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDTO> getAllDepartments();
}
