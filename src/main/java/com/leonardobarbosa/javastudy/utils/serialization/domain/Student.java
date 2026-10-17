package com.leonardobarbosa.javastudy.utils.serialization.domain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;

public class Student implements Serializable {

    /*
    Serializable -> interface marcadora
    - objetos dessa classe podem ser convertidos em bytes (serializados)


     */

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private transient String password;  // transient -> não é serializado

    private transient StudentClass studentClass;
    /*
    StudentClass não implementa Serializable, por isso o campo é transient,
    mas ainda é preciso guardar o nome da turma.
    writeObject e readObject permitem fazer isso manualmente
     */


    // constructors
    public Student() {
    }

    public Student(String name, String password) {
        this.name = name;
        this.password = password;
    }


    // StudentClass
    @Serial
    private void writeObject(ObjectOutputStream oos) {

        try {

            oos.defaultWriteObject();   // sempre roda -> grava {name}

            boolean hasStudentClass = studentClass != null;
            oos.writeBoolean(hasStudentClass);  // grava se tem ou não, pra readObject saber se deve ler o UTF
            if (hasStudentClass) {
                oos.writeUTF(studentClass.getName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Serial
    private void readObject(ObjectInputStream ois) {

        try {

            ois.defaultReadObject();    // sempre roda -> lê {name}

            if (ois.readBoolean()) {
                String studentClass = ois.readUTF();
                this.studentClass = new StudentClass(studentClass);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    // toString
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", studentClass=" + studentClass +
                '}';
    }

    // set
    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }
}
