package swiss.sib.swissprot.odgi4j;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.sun.jna.Pointer;

public class Odgi4jTest {

	@Rule
	public TemporaryFolder temp = new TemporaryFolder();

	@Test
	public void testVersionNotNull() {

		Odgi4j instance = Odgi4j.instance();
		assertNotNull(instance);
		Pointer versionPointer = instance.odgi_c_version();
		String version = versionPointer.getString(0);
		assertTrue(version, version.startsWith("v"));
	}

	@Test
	public void testLoadGFA() throws IOException {

		Odgi4j instance = Odgi4j.instance();
		assertNotNull(instance);
		File tempFile = temp.newFile("test.og");
		try (InputStream in = Odgi4jTest.class.getClassLoader().getResourceAsStream("t.og")) {
			Files.copy(in, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
		Pointer versionPointer = instance.odgi_load_graph(tempFile.getAbsolutePath());

		assertNotNull(versionPointer);
	}
}
