package vti.dtn.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vti.dtn.authservice.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByUsername(String username);
}
