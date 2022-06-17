package swiss.sib.swissprot.odgi4j;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class Odgi4jTest {

	@Test
	public void testVersionNotNull() {
		assertNotNull(new Odgi4j().odgi_version());
	}
}
