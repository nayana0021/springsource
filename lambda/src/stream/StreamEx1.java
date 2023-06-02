package stream;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/* 스트림 연산
 * - 다양한 연산을 이용해 복잡한 작업들을 간단히 처리함
 * - 연산 종류
 * 	1) 중간 연산 : 연산 결과가 스트림
 * 				 map(), filter(), skip()...
 *  2) 최종 연산 : 연산 결과가 스트림이 아닌 상태
 *  			 forEach(), collect(), reduce(), count(), max(), min()...
 *  
 */
public class StreamEx1 {
	public static void main(String[] args) {
		// 파일 객체에서 이름을 출력
		
		List<File> list = new ArrayList<File>();
		
		list.add(new File("/Users/youngkyung/Documents/file1.txt"));
		list.add(new File("/Users/youngkyung/Documents/file2.txt"));
		list.add(new File("/Users/youngkyung/Documents/file3.txt"));
		list.add(new File("/Users/youngkyung/Documents/file4.txt"));
		list.add(new File("/Users/youngkyung/Documents/file5.txt"));
		
		
		// 이름만 수집한 후 출력
		List<String> fileNames = new ArrayList<String>();
		for (File file : list) {
			fileNames.add(file.getName());
		}
		for (String string : fileNames) {
			System.out.println(string);
		}
		
		System.out.println();
		
		// stream 으로 처리?
		// stream 변환(list.stream() -> 연산(map()) -> 결과 출력
		// map() : 스트림의 요소에 저장된 값 중에서 원하는 필드만 추출하거나 특정 형태로 변환시 사용
//		Stream<String> names = list.stream().map(File::getName); //File 객체에 들어있는 getName 메소드 이용
//		names.forEach(f -> System.out.println(f));
		
		list.stream().map(File::getName).forEach(f -> System.out.println(f));
		
		List<String> fruits = Arrays.asList("melon","apple","banana","grape");
		// fruits 대문자로 변경한 걸 새로운 리스트로 생성 후 출력
		List<String> upper = new ArrayList<String>();
		for (String string : fruits) {
			upper.add(string.toUpperCase());
		}
		for (String string : upper) {
			System.out.println(string);
		}
		
		System.out.println();
		
		fruits.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		
		System.out.println();
		
		fruits.stream().map(String::toUpperCase).forEach(System.out::println);
		
	}
}
