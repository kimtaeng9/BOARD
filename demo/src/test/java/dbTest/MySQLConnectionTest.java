package dbTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest // 스프링부트 어플리케이션의 전체 컨텍스트를 로드하여 통합 테스트 실행
public class MySQLConnectionTest {

    @Autowired // 스프링 컨텍스트에서 JdbcTemplate 빈을 주입받는다.
    private JdbcTemplate jdbcTemplate;

    @Test // JUit 5에서 테스트 메서드 .. 테스트 프레임워크에 의해 실행된다.
    void testConnection() { // JdbcTemplate을 사용하여 데이터베이스에 SELECT 1 쿼리를 실행
        assertDoesNotThrow(() -> { // 쿼리가 예외없이 실행되는지 확인하여 데이터베이스 연결 설정 확인
            jdbcTemplate.execute("SELECT 1");
            // 연결이 성공적으로 설정되었다면, 숫자 1을 반환
        }, "Database connection failed");
    }
}
