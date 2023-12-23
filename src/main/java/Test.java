import com.cn.entity.Student;
import com.cn.dao.StudentDao;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args ){
        Student student = new Student(2,"乐正绫");
        StudentDao studentDao = new StudentDao();
        ArrayList<Student> list = studentDao.getAllStu();
        System.out.println(list);


    }
}
