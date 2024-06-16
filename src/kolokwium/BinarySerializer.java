package kolokwium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class BinarySe
        rializer implements IUserSerializer{
	public <T> void serialize(List<T> list, String filename) throws IOException{
		File file = new File(filename);
		
		if(!file.exists())
			file.createNewFile();
		
		if(!file.canWrite())
			return;
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
			oos.writeObject(list);
		}
	}

	public <T> List<T> deserialize(String filename) throws ClassNotFoundException, IOException{
		File file = new File(filename);
		
		if(!(file.exists() && file.canRead()))
			return null;
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
			Object o = ois.readObject();
			
			if(o != null && o instanceof List)
				return (List<T>) o;
		}
		
		return null;
	}
}
