package swiss.sib.swissprot.odgi4j;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class Odgi4jTest {

	@Test
	public void testVersionNotNull() {
		System.setProperty("jna.debug_load", "true");
		Odgi4j instance = Odgi4j.instance();
		assertNotNull(instance);
		assertNotEquals(0, instance.divsufsort_version());
	}
}
