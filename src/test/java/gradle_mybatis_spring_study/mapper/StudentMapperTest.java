package gradle_mybatis_spring_study.mapper;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

import gradle_mybatis_spring_study.config.ContextRoot;
import gradle_mybatis_spring_study.dto.Gender;
import gradle_mybatis_spring_study.dto.PhoneNumber;
import gradle_mybatis_spring_study.dto.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class} )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentMapperTest {

protected static final Log log = LogFactory.getLog(StudentMapperTest.class);
	
	@After
	public void tearDown() {
		System.out.println();
	}
	
	@Autowired
	private StudentMapper mapper;
	
	@Test
	public void test01SelectStudentByNo() {
		System.out.println("testSelectStudentByNo()");
		Student student = new Student();
		student.setStudId(1);
		Student selectedStd = mapper.selectStudentByNo(student);
		Assert.assertNotNull(selectedStd);
		log.debug(selectedStd.toString());
	}

	@Test
	public void test02SelectStudentByNoWithResultMap() {
		System.out.println("testSelectStudentByNoWithResultMap()");
		Student student = new Student();
		student.setStudId(1);
		Student selectedStd = mapper.selectStudentByNoWithResultMap(student);
		Assert.assertNotNull(selectedStd);
		log.debug(selectedStd.toString());
	}
	
	@Test
	public void test03SelectStudentByAll() {
		System.out.println("testSelectStudentByAll()");
		List<Student> list = mapper.selectStudentByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}
	
	@Test
	public void test04SelectStudentByAllForResultMap() {
		System.out.println("test04SelectStudentByAllForResultMap()");
		List<Student> list = mapper.selectStudentByAllForResultMap();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}
	
	@Test
	public void test05SelectStudentByAllForHashMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Map<String, Object>> list = mapper.selectStudentByAllForHashMap();
		Assert.assertNotNull(list);
		for(Map<String, Object> map : list) {
			for(Entry<String, Object> e : map.entrySet()) {
				log.debug(String.format("%s -> %s", e.getKey(), e.getValue()));
			}
		}
	}
	
	@Test
	public void test06SelectStudentByNoAssociation() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Student student = new Student();
		student.setStudId(1);
		Student seletedStd = mapper.selectStudentByNoAssociation(student);
		Assert.assertNotNull(seletedStd);
		log.debug(seletedStd.toString());
	}
	
	@Test
	public void test07insertEnumStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 1, 28);
		
		Student student = new Student();
		student.setStudId(3);
		student.setName("테스트3");  
		student.setEmail("test@test.co.kr");  
		student.setDob(newDate.getTime());
		student.setPhone(new PhoneNumber("010-1234-1234"));
		student.setGender(Gender.FEMALE);
		int res = mapper.insertEnumStudent(student);
		Assert.assertEquals(1, res);
		
		student.setStudId(4);  
		student.setName("테스트4");  
		student.setEmail("test4@test.co.kr");  
		student.setDob(newDate.getTime());
		student.setPhone(new PhoneNumber("010-1234-1234"));
		student.setGender(Gender.MALE);
		int res1 = mapper.insertEnumStudent(student);
		Assert.assertEquals(1, res1);
	}

	@Test
	public void test08SelectStudentByNoForEnum(){
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Student student = new Student();
		student.setStudId(3);
		Student seletedStd = mapper.selectStudentByNoForEnum(student);
		Assert.assertNotNull(seletedStd);
		log.debug(seletedStd.toString());
	}
	
	@Test
	public void test09selectStudentByAllForEnum() {
		System.out.println("testSelectStudentByAllForEnum()");
		List<Student> list = mapper.selectStudentByAllForEnum();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}
	
}
