package com.cn.dao;

import com.cn.entity.Student;
import com.cn.util.DBCon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {

    //添加学生
    public int addStu(Student stu) {
        int count=0;
        Connection con= DBCon.getCon();
        String sql="insert into student value(?,?)";
        PreparedStatement prest=null;
        try {
            prest = con.prepareStatement(sql);
            prest.setInt(1,stu.getId());
            prest.setString(2,stu.getUsername());
            count=prest.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBCon.close(prest, con);
        return count;
    }
//删除学生
public int delStu(String id) {
    int count=0;
    Connection con=DBCon.getCon();
    String sql="delete from student where id=?";
    PreparedStatement prest=null;
    try {
        prest = con.prepareStatement(sql);
        prest.setString(1,id);
        count=prest.executeUpdate();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    DBCon.close(prest, con);
    return count;
}
//修改学生信息
public int update(Student stu) {
    int count=0;
    Connection con=DBCon.getCon();
    String sql="update student set name=? where id=?";
    PreparedStatement prest=null;
    try {
        prest = con.prepareStatement(sql);
        prest.setString(1,stu.getUsername());
        prest.setInt(2,stu.getId());
        count=prest.executeUpdate();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    DBCon.close(prest, con);
    return count;
}
    //根据学号查询候选人信息
    public Student selStubyid(int id) {
        Student stu=null;
        Connection con=DBCon.getCon();
        String sql="SELECT * FROM student WHERE id = ?";
        PreparedStatement prest=null;
        ResultSet rs=null;
        try {
            prest = con.prepareStatement(sql);
            prest.setInt(1,id);
            rs = prest.executeQuery();
            System.out.println(rs.next());
            if(rs.next()) {
                int ids=rs.getInt("id");
                String name=rs.getString(2);
                stu=new Student(ids, name);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBCon.close(rs,prest, con);
        return stu;
    }
    public ArrayList<Student> getAllStu()
    {
        ArrayList<Student> list = new ArrayList<Student>();
        Connection con =DBCon.getCon();
        String sql = "select * from student";
        PreparedStatement prest=null;
        ResultSet rs=null;
        try {
            prest = con.prepareStatement(sql);
            rs = prest.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Student stu= new Student(id, name);
                list.add(stu);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBCon.close(rs, prest, con);
        return list;
    }
}
