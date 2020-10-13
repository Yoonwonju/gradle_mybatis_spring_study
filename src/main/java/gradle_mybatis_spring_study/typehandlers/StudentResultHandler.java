package gradle_mybatis_spring_study.typehandlers;

import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import gradle_mybatis_spring_study.dto.Student;

public class StudentResultHandler implements ResultHandler<Student> {
	private Map<Integer, String> map;

	public StudentResultHandler(Map<Integer, String> map) {
		this.map = map;
	}

	@Override
	public void handleResult(ResultContext<? extends Student> resultContext) {
		Student student = resultContext.getResultObject();
		map.put(student.getStudId(), student.getName());
	}
	
	
}
