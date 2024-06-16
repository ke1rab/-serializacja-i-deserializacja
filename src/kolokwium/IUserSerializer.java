package kolokwium;

import java.io.IOException;
import java.util.List;

public interface IUserSerializer {
	public <T> void serialize(List<T> list, String filename) throws IOException;
	public <T> List<T> deserialize(String filename) throws ClassNotFoundException, IOException;
}
