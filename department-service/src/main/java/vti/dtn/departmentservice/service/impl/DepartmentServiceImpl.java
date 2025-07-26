package vti.dtn.departmentservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vti.dtn.departmentservice.dto.DepartmentDTO;
import vti.dtn.departmentservice.entity.DepartmentEntity;
import vti.dtn.departmentservice.repository.DepartmentRepository;
import vti.dtn.departmentservice.service.DepartmentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities.stream()
                .map(departmentEntity -> DepartmentDTO.builder()
                        .name(departmentEntity.getName())
                        .type(departmentEntity.getType().toString())
                        .createdDate(departmentEntity.getCreatedAt())
                        .build())
                .toList();
    }
}
