package exe2;
import org.junit.Test;

public class VulnerableClassTest  {

	private String FILENAME;
	private VulnerableClass vuln;
	@Test(expected = Exception.class)
	public void invalidFileNameTest() throws Exception {
		FILENAME = "çaida";
		vuln = new VulnerableClass();
		vuln.vulnerableMethod(FILENAME);
	}

}
