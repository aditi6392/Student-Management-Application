package student_management_system.main;

import student_management_system.dao.StudentDao;
import student_management_system.dao.StudentDaoInterface;
import student_management_system.model.Student;

import java.sql.SQLOutput;
import java.util.Scanner;
//student result management

public class Client {
    public static void main(String[] args) {
        StudentDaoInterface dao=new StudentDao();
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Student Management Application");
        while (true){
            System.out.println("\n1.Add Student"+"\n2.Show All Students"+"\n3.Get student based on roll number"+"\n4.Delete Student"+"\n5.Update Student"+"\n6.Exit");
            System.out.println("Enter choice:");

            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Add Student");
                    System.out.println("Enter Student's Name:");
                    String name=sc.next();
                    System.out.println("Enter student clg name:");
                    String clgname=sc.next();
                    System.out.println("Enter City:");
                    String city=sc.next();
                    System.out.println("Percentage:");
                    double percentage=sc.nextDouble();
                    Student st=new Student(name,clgname,city,percentage);
                    boolean ans=dao.insertStudent(st);
                    if (ans) {
                        System.out.println("Record added succesfully.");
                    }
                    else {
                        System.out.println("something went wrong.");
                    }

                    break;
                case 2:
                    System.out.println("Show all students");
                    dao.showAllStudent();
                     break;
                case 3:
                    System.out.println("Get students based on thier roll number");
                    System.out.println("Enter RollNumber:");
                    int roll=sc.nextInt();
                    boolean f=dao.showStudentByID(roll);
                    if(!f){
                        System.out.println("Student with this roll number is not available. ");
                    }

                    break;
                case 4:
                    System.out.println("Delete Student");
                    System.out.println("Enter Roll number to delete student detail.");
                    int rollnum=sc.nextInt();
                    boolean ff=dao.delete(rollnum);
                    if(ff){
                        System.out.println("Record deleted successfully...");
                    }
                    else {
                        System.out.println("Something went wromg.");
                    }
                    break;
                case 5:
                    System.out.println("Update Student");
                    System.out.println("\n1.Update name"+"\n2.Update College name"+"\n3.Update City");
                    System.out.println("Enter your choice:");
                    int choice=sc.nextInt();
                    Student std=new Student();

                    if (choice==1){
                        System.out.println("Enter Rollno:");
                        int rnum=sc.nextInt();
                        System.out.println("Enter new name:");
                        String sname=sc.next();

                        std.setName(sname);
                        boolean flag=dao.update(rnum,sname,choice,std);
                        if(flag){
                            System.out.println("Name updated succesfully....");
                        }
                        else{
                            System.out.println("Something went wrong....");
                        }
                    }
                    if (choice==2){
                        System.out.println("Enter Rollno:");
                        int rnum=sc.nextInt();
                        System.out.println("Enter new College name:");
                        String cname=sc.next();
                        std.setClgName(cname);
                        boolean fff=dao.update(rnum,cname,choice,std);
                        if (fff){
                            System.out.println("College name update succesfully...");
                        }
                        else {
                            System.out.println("Something went wrong....");
                        }
                    }
                    if (choice==3){
                        System.out.println("Enter Rollno:");
                        int rnum=sc.nextInt();
                        System.out.println("Enter new City name:");
                        String cityname=sc.next();
                        std.setClgName(cityname);
                        boolean fff=dao.update(rnum,cityname,choice,std);
                        if (fff){
                            System.out.println("City name update succesfully...");
                        }
                        else {
                            System.out.println("Something went wrong....");
                        }
                    }

                    break;
                case 6:
                    System.out.println("Thankyou you for using student management application!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("please enter valid choice... ");
            }

        }
    }
}
