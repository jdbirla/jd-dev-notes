package com.jd.interviewprep.corejava;

import java.io.*;

class SuperClass {
    int superField;
    
    public SuperClass()
    {
    	
    }

    public SuperClass(int superField) {
        this.superField = superField;
    }

    public void printSuperField() {
        System.out.println("SuperField: " + superField);
    }
}

class ChildClass extends SuperClass implements Serializable {
    int childField;

    public ChildClass(int superField, int childField) {
     //   super(superField);
        this.childField = childField;
    }

    public void printChildField() {
        System.out.println("ChildField: " + childField);
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        ChildClass child = new ChildClass(1, 2);

        // Serialize the child object
        try {
            FileOutputStream fileOut = new FileOutputStream("child.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(child);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in child.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

        // Deserialize the child object
        ChildClass deserializedChild = null;
        try {
            FileInputStream fileIn = new FileInputStream("child.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deserializedChild = (ChildClass) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("ChildClass not found");
            c.printStackTrace();
            return;
        }

        // Print the fields of the deserialized child object
        deserializedChild.printSuperField(); // prints 1
        deserializedChild.printChildField(); // prints 2
    }
}
