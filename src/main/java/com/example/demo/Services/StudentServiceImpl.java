package com.example.demo.Services;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.StudentDao;
import com.example.demo.entities.Students;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	@Autowired
	private StudentDao studentDao;
	List<Students> list;
	
	public StudentServiceImpl()
	{
		list=new ArrayList<>();
		list.add(new Students(10,"Rahul","Tenth","Hadapsar"));
		list.add(new Students(11,"Vartika","BSc" ,"Katraj"));
		list.add(new Students(12,"Karan","Twelth","Kharadi"));
		list.add(new Students(13,"Manoj","MA","Saswad"));
		list.add(new Students(14,"Priya","MSc","Jejuri"));		
		
	}

	@Override
	public List<Students>getStudentInfo() {
		return studentDao.findAll();
	}

	@Override
	public Students getStudentInfos(int studentId) 
	{
		Students s= null;

		for(Students studentinfo:list) 
		{
			if(studentinfo.getId()==studentId)
			{
				s=studentinfo;
				break;
			}
		}
		return studentDao.getById(studentId);
	}

	@Override
	public Students addStudents(Students student) {
		list.add(student);
		studentDao.save(student);
		return student;
	}

	@Override
	public Students updateStudents(Students student)
	{
		list.forEach(e-> {
			if(e.getId()==student.getId())
			{
			e.setName(student.getName());
			e.setStandard(student.getStandard());
			e.setAddress(student.getAddress());
			}
		});
		return studentDao.save(student);
	}

	@Override
	public void deleteStudents(int parseLong) 
	{
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		 Students entity= studentDao.getOne(parseLong);
		 studentDao.delete(entity);
	}

}
