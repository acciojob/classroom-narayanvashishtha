package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentRepository {

    HashMap<String, Student> studentDb = new HashMap<>();
    HashMap<String, Teacher> teacherDb = new HashMap<>();
    HashMap<String, List<String>> studentTeacherPairDb = new HashMap<>();

    public void addStudentToDb(Student student) {
        studentDb.put(student.getName(), student);
    }

    public void addTeacherToDb(Teacher teacher) {
        teacherDb.put(teacher.getName(), teacher);
    }

    public Student getStudentFromDb(String name) {
        return studentDb.get(name);
    }

    public List<String> getTeacherFromDb(String teacherName) {
        List<String> student = new ArrayList<>();
        if (studentTeacherPairDb.containsKey(teacherName)) {
            student = studentTeacherPairDb.get(teacherName);
        }
        return student;
    }

    public void addStudentTeacherPairToDb(String studentName, String teacherName) {
        if (studentDb.containsKey(studentName) && teacherDb.containsKey(teacherName)) {
            if (studentTeacherPairDb.containsKey(teacherName)) {
                studentTeacherPairDb.get(teacherName).add(studentName);
            } else {
                List<String> list = new ArrayList<>();
                list.add(studentName);
                studentTeacherPairDb.put(teacherName, list);
            }
        }
    }

    public List<String> getAllStudentFromDb() {
        List<String> list = new ArrayList<>();
        for (String s : studentDb.keySet()) {
            list.add(s);
        }
        return list;
    }

    public void deleteTeacherByNameFromDb(String teacherName) {
        if (teacherDb.containsKey(teacherName)) {

            if (studentTeacherPairDb.containsKey(teacherName)) {
                List<String> student = studentTeacherPairDb.get(teacherName);
                for (String s : student) {
                    studentDb.remove(s);
                }
                studentTeacherPairDb.remove(teacherName);
            }
            teacherDb.remove(teacherName);
        }
    }
    public void deleteAllTeachersFromDb() {
        ArrayList<String> list = new ArrayList<>();
        for (String s : studentTeacherPairDb.keySet()) {
            for (String m : studentTeacherPairDb.get(s)) {
                list.add(m);
            }
        }
        for (String l : list) {
            studentDb.remove(l);
        }
    }

    public List<String> getStudentsByTeacherNameFromDb(String name) {
        List<String> list = new ArrayList<>();
        for (String s : studentTeacherPairDb.keySet()) {
            list.add(s);
        }
        return list;
    }
}
