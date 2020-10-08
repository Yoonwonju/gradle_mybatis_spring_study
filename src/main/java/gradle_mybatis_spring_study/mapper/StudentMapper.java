package gradle_mybatis_spring_study.mapper;

import gradle_mybatis_spring_study.dto.Student;

public interface StudentMapper {
	//TypeHandler 사용
	Student selectStudentByNo(Student student);
	//ResultMap 사용
	Student selectStudentByNoWithResultMap(Student student);

}
