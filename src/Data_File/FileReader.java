
package Data_File;

import java.io.FileNotFoundException;

//creating a abstract class

abstract class FileReader 
{
    public abstract String readFile(String filePath) throws FileNotFoundException;
}