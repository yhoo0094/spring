package co.company.spring.users.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import co.company.spring.users.service.UserService;
import co.company.spring.users.service.UserVO;

@Controller
public class UserController {

	@Autowired
	UserService service;

	// 등록페이지로 이동
	@GetMapping("/userInsert")
	public String userInsertForm() {
		return "user/insert";
	}

	// 등록처리
	@PostMapping("/userInsert")
	public String userInsert(HttpServletRequest request, UserVO user) throws IllegalStateException, IOException {
		// request를 multipart로 캐스팅
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 이미지파일
		MultipartFile multipartFile = multipartRequest.getFile("uploadFile");
		// 첨부파일
		if (!multipartFile.isEmpty() && multipartFile.getSize() > 0) {
			String path = request.getSession().getServletContext().getRealPath("/images");
			System.out.println("path = " + path);
			multipartFile.transferTo(new File(path, multipartFile.getOriginalFilename()));
			user.setProfile(multipartFile.getOriginalFilename());
		}
		// 등록처리
		service.insertUser(user);
		return "user/insert";
	}
	
	@RequestMapping("/getUser")
	public String getUser(UserVO user, Model model) {
		model.addAttribute("user", service.getUser(user));
		return "user/user";
	}

	@RequestMapping("/filedown")
	public void filedown(HttpServletRequest request, HttpServletResponse response, @RequestParam String uFile) throws IOException {
		response.setContentType("application/octet-stream;charset=UTF-8");
		String fn = URLEncoder.encode(uFile, "utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=\""+ fn + "\"");
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
			String path = request.getSession().getServletContext().getRealPath("/images");
			in = new BufferedInputStream(new FileInputStream(path + "/" + uFile));
			out = new BufferedOutputStream(response.getOutputStream());
			FileCopyUtils.copy(in, out);
			out.flush();
		} catch (IOException ex) {
		} finally {
			in.close();
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
	}
}
