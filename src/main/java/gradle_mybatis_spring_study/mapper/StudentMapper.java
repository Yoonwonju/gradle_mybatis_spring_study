package gradle_mybatis_spring_study.mapper;

import java.util.List;

import gradle_mybatis_spring_study.dto.Student;

public interface StudentMapper {
	//TypeHandler 사용
	Student selectStudentByNo(Student student);
	//ResultMap 사용
	Student selectStudentByNoWithResultMap(Student student);
	//List 또는 Collection, Iterable 인터페이스를 구현한 타입은 ArrayList 타입으로 리턴
	List<Student> selectStudentByAll();

}
