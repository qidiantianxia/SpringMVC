package com.jike.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DownloadController {

	@RequestMapping("download")
	private String download(@RequestParam String fileName, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("download" + fileName);
		response.setContentType("text/html;charset=utf-8");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		String ctxPath = request.getSession().getServletContext().getRealPath("/") + "upload/";
		String downloadPath = ctxPath + fileName;
		System.out.println(downloadPath);

		try {
			long fileLength = new File(downloadPath).length();
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Length", String.valueOf(fileLength));
			response.setHeader("Content-disposition",
					"attachment;filename=" + new String(fileName.getBytes("GB2312"), "ISO_8859_1"));

			bis = new BufferedInputStream(new FileInputStream(downloadPath));
			bos = new BufferedOutputStream(response.getOutputStream());

			byte[] buff = new byte[2048];
			int byteRead;
			while ((byteRead = bis.read(buff, 0, buff.length)) != -1) {
				bos.write(buff, 0, byteRead);
			}
		} catch (Exception e) {

		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}
}
