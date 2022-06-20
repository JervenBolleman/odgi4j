package swiss.sib.swissprot.odgi4j;

public class Odgi4j {
	static {
		new Native("jemalloc").load();
		new Native("odgi").load();
	}

	public native String odgi_version();
	
	public native long odgi_long_long_size();
	
	public native long _Z19_long_long_sizev();
}
