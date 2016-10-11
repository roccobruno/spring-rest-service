package com.bruno.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FileResourceUtil implements ResourceLoaderAware {
	
	private static final Logger logger = LoggerFactory.getLogger(FileResourceUtil.class);

	private ResourceLoader resourceLoader;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}	

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public File getFile(String fileName, String fileLocation) throws IOException {
		
		Resource resource = resourceLoader.getResource("file:" + fileLocation + fileName);
		boolean extis = resource.exists();
		logger.debug(fileLocation + fileName + " exits: " + extis);
		return resource.getFile();
	}

	public void createFile(List<String> fileLines,String fileName, String pathDir, String header) {

		String outputFile = pathDir + "/"+ fileName;
		CSVPrinter csvFilePrinter = null;
        CSVFormat csvFileFormat = CSVFormat.EXCEL.withHeader(header);        
        FileWriter fileWriter = null;
        File file = null;
        
		try {
			file = new File(outputFile);
			file.getParentFile().mkdirs();
	        fileWriter = new FileWriter(file);
	        csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
	        csvFilePrinter.printRecords(fileLines);
	        fileWriter.flush();
	        fileWriter.close();
	        csvFilePrinter.close();
	        
	        } catch (IOException e) {
	        	logger.error("ERROR in writing in file = "+pathDir+"/"+fileName);
	        	logger.error("ERROR "+e.getMessage());
	        	}
		}

	public ResponseEntity<byte[]> download(String fileName, HttpServletResponse resp, String fileLocation) throws IOException {
		
		final HttpHeaders headers = new HttpHeaders();
		File toServeUp = this.getFile(fileName, fileLocation);

		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(toServeUp);
		} catch (FileNotFoundException e) {

			// Also useful, this is a good was to serve down an error message
			String msg = "ERROR: Could not find the file specified. fileName:"+fileLocation+"/"+fileName;
			headers.setContentType(MediaType.TEXT_PLAIN);
			logger.error(msg);
			return new ResponseEntity<byte[]>(msg.getBytes(), headers,HttpStatus.NOT_FOUND);

		}
		resp.setContentType("application/octet-stream"); // .exe/csv file
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		Long fileSize = toServeUp.length();
		resp.setContentLength(fileSize.intValue());
		OutputStream outputStream = null;
		try {
			outputStream = resp.getOutputStream();
		} catch (IOException e) {
			String msg = "ERROR: Could not generate output stream.";
			headers.setContentType(MediaType.TEXT_PLAIN);
			inputStream.close();
			return new ResponseEntity<byte[]>(msg.getBytes(), headers,
					HttpStatus.NOT_FOUND);
		}
		byte[] buffer = new byte[1024];
		int read = 0;
		try {

			while ((read = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, read);
			}
			// close the streams to prevent memory leaks
			outputStream.flush();
			outputStream.close();
			inputStream.close();
		} catch (Exception e) {
			String msg = "ERROR: Could not read file.";
			headers.setContentType(MediaType.TEXT_PLAIN);
			return new ResponseEntity<byte[]>(msg.getBytes(), headers,HttpStatus.NOT_FOUND);
		}
		return null;
	}

}
