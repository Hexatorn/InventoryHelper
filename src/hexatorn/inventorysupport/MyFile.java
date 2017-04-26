package hexatorn.inventorysupport;

import java.io.File;

/**
 * Created by Hexatorn on 2017-04-25.
 */
public class MyFile{
    File file;
    MyFile(String patchfile){
            setPatchfile(patchfile);
    }
    MyFile(File file){
        setFile(file);
    }
    String getAbsolutePath(){
        return getPatchfile();
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setPatchfile(String patchfile) {
        this.file = new File(patchfile);
    }

    public String getPatchfile() {
        return file.getAbsolutePath();
    }
}
