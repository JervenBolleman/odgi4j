package swiss.sib.swissprot.odgi4j;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;

public interface Odgi4j extends Library {

	public Pointer odgi_c_version();
	
	public NativeLong odgi_long_long_size();
	
	public static Odgi4j instance() {
		Native.load("jemalloc", Jemalloc.class);
		
		return Native.load("odgi", Odgi4j.class);
	}

	public String divsufsort_version();
}
