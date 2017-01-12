package com.pfe.ahmed.facade.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.inject.Inject;

import org.apache.commons.codec.binary.Base64;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ImageBase64Transformer {

	@Inject
	private Environment env;
	
	public String transform2File(String base64,String fileName) throws IOException{
		final byte[] imageByte = Base64.decodeBase64(base64);
		File myFile = new File(env.getProperty("images.downloded.path")+File.separator+fileName);
		myFile.createNewFile();
		FileOutputStream outputStream = new FileOutputStream(myFile);  
		outputStream.write(imageByte);
		outputStream.flush();
		outputStream.close();
		return myFile.getAbsolutePath();
	}
}
