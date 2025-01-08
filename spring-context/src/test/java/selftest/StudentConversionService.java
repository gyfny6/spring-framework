package selftest;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;
import selftest.StudentService;

/**
 * 转换器
 * 将字符串 'age#name' 使用#分割开，将age赋值给age，name赋值给name
 */
public class StudentConversionService implements Converter<String, StudentService> {

	@Override
	public StudentService convert(String source) {
		if(StringUtils.hasLength(source)){
			String[] sources = source.split("#");

			StudentService studentService = new StudentService();
			studentService.setAge(Integer.parseInt(sources[0]));
			studentService.setName(sources[1]);

			return studentService;
		}
		return null;
	}

}
