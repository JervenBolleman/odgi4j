package swiss.sib.swissprot.odgi4j;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Pointer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;


public class Odgi4jTest {

	@Rule
	public TemporaryFolder temp = new TemporaryFolder();

	@Test
	public void testVersionNotNull() {
		BytePointer versionPointer = OdgiLibrary.odgi_version();
		String version = versionPointer.getString();
		assertTrue(version, version.startsWith("v"));
	}

	@Test
	public void testLoadGFA() throws IOException {

		File tempFile = temp.newFile("test.og");
		try (InputStream in = Odgi4jTest.class.getClassLoader().getResourceAsStream("t.og")) {
			Files.copy(in, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
		Pointer versionPointer = OdgiLibrary.odgi_load_graph(tempFile.getAbsolutePath());

		assertNotNull(versionPointer);
	}
}
