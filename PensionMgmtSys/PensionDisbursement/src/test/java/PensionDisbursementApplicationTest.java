import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.pensionmanagement.pensiondisbursement.PensionDisbursementApplication;


@SpringBootTest
@ContextConfiguration(classes=PensionDisbursementApplication.class)
public class PensionDisbursementApplicationTest {

	@Test
	public void contextLoads() {
	}
	
}
