package mg.cdan4.tp;

import mg.cdan4.tp.controller.MailController;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GestionProduitApplicationTests {
	@Autowired
	MailController mailController;


	@Test
	void contextLoads() {
		int result = mailController.somme(3,5);
		int expected = 8;
		assertEquals(expected, result);
	}

	@Test
	void testValide() {
		int result = mailController.diff(3,5);
		int expected = -2;
		assertEquals(expected, result);
	}

	@Test
	void beforE() {
		String a = "Admin";
		String b = "Admin";
		assertEquals(a, b);
	}


}
