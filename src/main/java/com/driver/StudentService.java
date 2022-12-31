package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    static
    StudentRepository studentRepository;

    public void addStudentService(Student student){
        studentRepository.addStudentToDb(student);
    }

    public void addTeacherService(Teacher teacher){
        studentRepository.addTeacherToDb(teacher);

    }

    public void addStudentTeacherPairService(String studentName,String teacherName){
        studentRepository.addStudentTeacherPairToDb(studentName,teacherName);
    }

    public Student getStudentByNameService(String name){
        Student student=studentRepository.getStudentFromDb(name);
        return student;
    }

    public List<String> getTeacherByNameService(String name){
        List<String> teacher = studentRepository.getTeacherFromDb(name);
        return teacher;
    }

    public List<String> getStudentsByTeacherNameService(String name){
        return studentRepository.getStudentsByTeacherNameFromDb(name);
    }

    public List<String> getAllStudentService(){
        return studentRepository.getAllStudentFromDb();
    }

    public void deleteTeacherByNameService(String name){
        studentRepository.deleteTeacherByNameFromDb(name);
    }

    public static void deleteAllTeachersService(){
        studentRepository.deleteAllTeachersFromDb();
    }

}