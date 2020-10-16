package gradle_mybatis_spring_study.service;

import java.util.Date;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gradle_mybatis_spring_study.config.ContextRoot;
import gradle_mybatis_spring_study.dto.Address;
import gradle_mybatis_spring_study.dto.Course;
import gradle_mybatis_spring_study.dto.PhoneNumber;
import gradle_mybatis_spring_study.dto.Tutor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TutorAndCourseServiceTest {

	protected static final Log log = LogFactory.getLog(TutorAndCourseServiceTest.class);

	@After
	public void tearDown() {
		System.out.println();
	}
	
	@Autowired
	private TutorAndCourseService service;
	
	@Test(expected = DuplicateKeyException.class)
	public void test01TrJoinTutorAndCourse_FailTutor() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Address address = new Address();
		address.setAddrId(2);
		PhoneNumber number = new PhoneNumber("010-010-0100");
		
		//tutorId=1 은 존재
		Tutor tutor = new Tutor(1, "Yoon", "Test@naver.com", address, number);
		Course course = new Course(8, "Python", "Programming", new Date(), new Date(), 4);
		service.trJoinTutorAndCourse(tutor, course);
	}
	
	@Test(expected = DuplicateKeyException.class)
	public void test02TrJoinTutorAndCourse_FailCourse() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Address address = new Address();
		address.setAddrId(2);
		PhoneNumber number = new PhoneNumber("010-010-0100");
		
		Tutor tutor = new Tutor(5, "Yoon", "Test@naver.com", address, number); 
		//courseId=2 는 존재 //tutorId = 100은 존재하지 않음
		Course course = new Course(2, "Python", "Programming", new Date(), new Date(), 100);
		service.trJoinTutorAndCourse(tutor, course);
	}
	
	@Test
	public void test03TrJoinTutorAndCourse_Success() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Address address = new Address();
		address.setAddrId(2);
		PhoneNumber number = new PhoneNumber("010-010-0100");
		
		Tutor tutor = new Tutor(5, "Yoon", "Test@naver.com", address, number); 
		Course course = new Course(7, "Python", "Programming", new Date(), new Date(), 5);
		service.trJoinTutorAndCourse(tutor, course);
	}
	
	@Test(expected = RuntimeException.class)
	public void test04TrRemoveTutorAndCourse_FailTutor() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		service.trRemoveTutorAndCourse(10, 7);
	}
	
	@Test(expected = RuntimeException.class)
	public void test05TrRemoveTutorAndCourse_FailCourse() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		service.trRemoveTutorAndCourse(2, 10);
	}
	
	@Test
	public void test06TrRemoveTutorAndCourse_Success() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		service.trRemoveTutorAndCourse(5, 7);
	}
}






