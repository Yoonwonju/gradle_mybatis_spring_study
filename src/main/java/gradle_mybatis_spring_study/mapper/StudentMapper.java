package gradle_mybatis_spring_study.mapper;

import java.util.List;
import java.util.Map;

import gradle_mybatis_spring_study.dto.Student;

public interface StudentMapper {
	//TypeHandler 사용
	Student selectStudentByNo(Student student);
	//ResultMap 사용
	Student selectStudentByNoWithResultMap(Student student);
	//List 또는 Collection, Iterable 인터페이스를 구현한 타입은 ArrayList 타입으로 리턴
	List<Student> selectStudentByAll();
	
	int insertStudent(Student student);
	
	int updateStudent(Student student);
	
	int deleteStudent(int id);
	
	/* ResultMap */
	List<Student> selectStudentByAllForResultMap();
	
	/* Result - HashMap */
	List<Map<String, Object>> selectStudentByAllForHashMap();
	
	/* 내포된 결과매핑(ResultMap)을 사용한 일대일 매핑 */
	Student selectStudentByNoAssociation(Student student);
	
	/* enum 타입 다루기 */
	int insertEnumStudent(Student student);
	Student selectStudentByNoForEnum(Student student);
	List<Student> selectStudentByAllForEnum();
	
	/* 여러 개의 입력 파라미터 전달 */
	Student selectStudentByMap(Map<String, String> map);
	List<Student> selectAllStudentByMap(Map<String, String> map);
	
	/* ResultSet 처리방식의 재정의 */ 
	Map<Integer, Student> selectStudentForMap(Student student);

}
