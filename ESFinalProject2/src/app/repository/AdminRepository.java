package app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
