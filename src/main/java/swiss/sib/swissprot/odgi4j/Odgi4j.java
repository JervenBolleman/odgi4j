package swiss.sib.swissprot.odgi4j;

public class Odgi4j {
	static {
		Native.load();
	}

	public native String odgi_version();

	public static void main(String[] args) {
		new Odgi4j().odgi_version();
	}
}
