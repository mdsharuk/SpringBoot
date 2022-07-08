package com.bd.dipti.SpringBoot.Repo;


import com.bd.dipti.SpringBoot.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
  public Integer countById(Integer id);
}
