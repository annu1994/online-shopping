package com.project.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH = "D:\\New folder (2)\\online-shopping\\online-shopping\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = "";

	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);

	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {

		// getting the real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images");

		logger.info("In [FileUploadUtility] >>> [uploadFile] Image Path : {}", REAL_PATH);

		// to make sure all directories exist if not create the directories
		if (!new File(ABS_PATH).exists()) {
			// create new file
			new File(ABS_PATH).mkdirs();
		}
		if (!new File(REAL_PATH).exists()) {
			// create new file
			new File(REAL_PATH).mkdirs();
		}

		try {
			// server upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			// project directory upload
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
		} catch (IOException ex) {

		}

	}

}
