package student_management_system.dao;

import student_management_system.db.DBConnection;
import student_management_system.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao implements StudentDaoInterface{

    @Override
    public boolean insertStudent(Student s) {
        boolean flag=false;
        try{
            Connection con= DBConnection.createConnection();
            String query="insert into students(sname,clgname,city,percentage) values(?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1,s.getName());
            pst.setString(2,s.getClgName());
            pst.setString(3,s.getCity());
            pst.setDouble(4,s.getPercentage());
            pst.executeUpdate();
            flag=true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(int roll) {
        boolean flag=false;
        try{
            Connection con=DBConnection.createConnection();
            String query="delete from students where rollnum="+roll;
            PreparedStatement pst=con.prepareStatement(query);
            pst.executeUpdate();
            flag=true;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(int roll, String update, int ch, Student s) {
        boolean flag=false;
        int choice=ch;
        try {
            if (choice==1){
                Connection con=DBConnection.createConnection();
                String query="update students set sname=? where rollnum=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,update);
                ps.setInt(2,roll);
                ps.executeUpdate();
                flag=true;

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try{
            if (choice==2){
                Connection con=DBConnection.createConnection();
                String query="update students set clgname=? where rollnum=? ";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,update);
                ps.setInt(2,roll);
                ps.executeUpdate();
                flag=true;

            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try{
            if (choice==3){
                Connection con=DBConnection.createConnection();
                String query="update students set city=? where rollnum=? ";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,update);
                ps.setInt(2,roll);
                ps.executeUpdate();
                flag=true;

            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    @Override
    public void showAllStudent() {
        try{
            Connection con=DBConnection.createConnection();
            String query="select*from students";
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                System.out.println("Roll Number:"+rs.getInt(1)+"\nName:"+rs.getString(2)
                        +"\ncollege name:"+rs.getString(3)+"\nCity:"+rs.getString(4)+"\nPercentage:"+rs.getDouble(5));
                System.out.println("-----------------------------------------------");

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean showStudentByID(int roll) {
        boolean found=false;
        try{
            Connection con=DBConnection.createConnection();
            String query="select*from students where rollnum="+roll;
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                System.out.println("Roll Number:"+rs.getInt(1)+"\nName:"+rs.getString(2)
                        +"\ncollege name:"+rs.getString(3)+"\nCity:"+rs.getString(4)+"\nPercentage:"+rs.getDouble(5));
                //System.out.println("-----------------------------------------------");
            found=true;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return found;
    }
}
