package lambda;

// 람다식은 어디에 포함해서 쓸것인가?
// @FunctionalInterface 어노테이션이
// 필수 요소는 아니지만, 하나의 추상 메소드만 정의되도록 컴파일 단계에서 처리

@FunctionalInterface	// 람다식으로 불러서 쓸거야 라는 의미
public interface Lambda3 {
	public void method(int x); // 인자를 받는 형태
//	public void method2();
}
