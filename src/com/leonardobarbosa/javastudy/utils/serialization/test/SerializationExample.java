package com.leonardobarbosa.javastudy.utils.serialization.test;

import com.leonardobarbosa.javastudy.utils.serialization.domain.StudentClass;
import com.leonardobarbosa.javastudy.utils.serialization.domain.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializationExample {
    public static void main(String[] args) {

        Student student = new Student("Jubileu", "123654789000");

        StudentClass studentClass = new StudentClass("Java one for all");
        student.setStudentClass(studentClass);

        serialize(student);
        deserialize();
    }

    // ObjectOutputStream -> escreve objetos serializados
    // writeObject() -> grava o objeto e seu grafo de atributos
    private static void serialize(Student student) {

        Path path = Paths.get("Files/com/leonardobarbosa/serialized/student.ser");

        try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) {
            out.writeObject(student);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ObjectInputStream -> lê os bytes e reconstrói o objeto
    // readObject() -> retorna Object, precisa de cast
    private static void deserialize() {

        Path path = Paths.get("Files/com/leonardobarbosa/serialized/student.ser");

        try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {

            Student student = (Student) in.readObject();
            System.out.println("Student deserialized: " + student);
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
