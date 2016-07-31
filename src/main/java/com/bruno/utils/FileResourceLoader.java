package com.bruno.utils;

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

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
public class FileResourceLoader implements ResourceLoaderAware {
	private ResourceLoader resourceLoader;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	private static final Logger logger = LoggerFactory
			.getLogger(FileResourceLoader.class);

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public File getFile(String fileName, String fileLocation)
			throws IOException {
		Resource resource = resourceLoader.getResource("file:" + fileLocation
				+ fileName);
		boolean extis = resource.exists();
		logger.debug(fileLocation + fileName + " exits: " + extis);
		return resource.getFile();
	}

	public ResponseEntity<byte[]> download(String fileName,
                                           HttpServletResponse resp, String fileLocation) throws IOException {
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
			return new ResponseEntity<byte[]>(msg.getBytes(), headers,
					HttpStatus.NOT_FOUND);

		}
		resp.setContentType("application/octet-stream"); // .exe/csv file
		resp.setHeader("Content-Disposition", "attachment; filename=\""
				+ fileName + "\"");
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
			return new ResponseEntity<byte[]>(msg.getBytes(), headers,
					HttpStatus.NOT_FOUND);
		}
		return null;
	}

}
