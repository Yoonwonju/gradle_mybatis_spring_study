package gradle_mybatis_spring_study.config;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gradle_mybatis_spring_study.dto.PhoneNumber;
import gradle_mybatis_spring_study.dto.Student;
import gradle_mybatis_spring_study.mapper.StudentMapper;
import gradle_mybatis_spring_study.mapper.StudentMapperTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class} )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentServiceTest {

protected static final Log log = LogFactory.getLog(StudentServiceTest.class);
	
	@After
	public void tearDown() {
		System.out.println();
	}
	
	@Autowired
	private StudentMapper mapper;
	
	@Test
	public void test01InsertStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);
		
		Student student = new Student();
		student.setStudId(3);
		student.setName("홍길동");
		student.setEmail("lee@test.co.kr");
		student.setPhone(new PhoneNumber("010-123-1234"));
		student.setDob(newDate.getTime());
		int res = mapper.insertStudent(student);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test02UpdateStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(3);
		student.setName("홍길동");
		student.setEmail("hong@hong.co.kr");
		student.setPhone(new PhoneNumber("010-1544-7979"));
		student.setDob(new Date());
		
		int result = mapper.updateStudent(student);
		Assert.assertEquals(1, result);
		
		/////////////////////////////////////
		
		student.setEmail("Test@hong.co.kr");
		student.setPhone(new PhoneNumber("123-123-1234"));
		student.setDob(new GregorianCalendar(1944, 7, 9).getTime());
		result = mapper.updateStudent(student);
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void test03DeleteStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int deleteStudent = mapper.deleteStudent(3);
		Assert.assertEquals(1, deleteStudent);
	}
}
