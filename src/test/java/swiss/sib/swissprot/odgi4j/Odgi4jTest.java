package swiss.sib.swissprot.odgi4j;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sun.jna.Pointer;

public class Odgi4jTest {

	@Test
	public void testVersionNotNull() {
		System.setProperty("jna.debug_load", "false");
		Odgi4j instance = Odgi4j.instance();
		assertNotNull(instance);
		Pointer versionPointer = instance.odgi_c_version();
		String version = versionPointer.getString(0);
		assertTrue(version, version.startsWith("v"));
	}
}
