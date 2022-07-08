package com.bd.dipti.SpringBoot.Service;

import com.bd.dipti.SpringBoot.Model.Student;
import com.bd.dipti.SpringBoot.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

  public void save(Student s){

    studentRepo.save(s);
  }
  public List<Student>studentList(){

    return studentRepo.findAll();
  }


public Student get(Integer id) throws StudentNotFoundException {
Optional<Student> result=studentRepo.findById(id);
if(result.isPresent()){
return result.get();
}
throw new StudentNotFoundException("no user in this ID"+id);
}

public  void studentDelete(Integer id) throws StudentNotFoundException{
      Integer count=studentRepo.countById(id);
    if(count==null ||count==0){

   throw new StudentNotFoundException("Student not found ");
    }
    studentRepo.deleteById(id);
}


}
