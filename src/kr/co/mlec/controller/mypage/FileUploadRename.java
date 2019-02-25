package kr.co.mlec.controller.mypage;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class FileUploadRename implements FileRenamePolicy{

	@Override
	public File rename(File f) {
  
        String uniqueFileName = "momogo-" + UUID.randomUUID().toString();

        String name = f.getName();
        String body = null;
        String ext = null;
  
        int dot = name.lastIndexOf(".");
        if (dot != -1) {
             body = name.substring(0, dot);
             ext = name.substring(dot);  // includes "."
        }
        else {
             body = name;
             ext = "";
        }
  
        String tempName = uniqueFileName + ext;
        f = new File(f.getParent(), tempName);
        if (createNewFile(f)) {
             return f;
        }

        int count = 0;
        while (!createNewFile(f) && count < 9999) {
             count++;
             String newName = uniqueFileName + "_" + count + ext;
             f = new File(f.getParent(), newName);
        }

        return f;
   }

   private boolean createNewFile(File f) {
        try {
             return f.createNewFile();
        }
        catch (IOException ignored) {
             return false;
        }
   }
}
