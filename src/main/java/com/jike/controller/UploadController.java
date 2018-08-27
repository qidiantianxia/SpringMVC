package com.jike.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class UploadController {

	@RequestMapping("oneUpload")
	public String oneUpload(@RequestParam("imageFile") MultipartFile imageFile, HttpServletRequest request) {
		System.out.println("oneUpload start");
		/*修改tomcat的Server Locations为Use Tomcat installation
		 * 为灰色，不能修改的时候
		 * 1.remove 部署的项目
		 * 2.clean server
	     */
		String path = request.getSession().getServletContext().getRealPath("/") + "upload/";
		String filename = imageFile.getOriginalFilename();

		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		System.out.println("文件上传到：" + path + filename);

		File targetFile = new File(path + filename);
		if (!targetFile.exists()) {
			try {
				targetFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			imageFile.transferTo(targetFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "redirect:http://localhost:8080/SpringMVC/upload/" + filename;
	}

	@RequestMapping("moreUpload")
	public String moreUpload(HttpServletRequest request) {
		System.out.println("moreUpload start");
		MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> map = mRequest.getFileMap();

		String path = request.getSession().getServletContext().getRealPath("/") + "upload/";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		List<String> fileList = new ArrayList<String>();
		for (MultipartFile file : map.values()) {

			File targetFile = new File(path + file.getOriginalFilename());
			if (!targetFile.exists()) {
				try {
					targetFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				file.transferTo(targetFile);
				fileList.add("http://localhost:8080/SpringMVC/upload/" + file.getOriginalFilename());
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("files", fileList);

		return "moreUploadResult";
	}
}
