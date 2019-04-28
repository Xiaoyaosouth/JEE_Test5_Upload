package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UploadController {
	// 上传文件会自动绑定到MultipartFile
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(HttpServletRequest request,
			@RequestParam("file") MultipartFile uploadfile)
	throws Exception{
		// 如果文件不为空，写入上传路径
		if(!uploadfile.isEmpty()) {
			// 上传文件路径
			String path = request.getSession().getServletContext().getRealPath("/uploads/");
			// 上传文件名字
			String filename = uploadfile.getOriginalFilename();
			File filepath = new File(path + java.io.File.separator + filename);
			// 判断路径是否存在，如果不存在就创建
			if(!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			// 将上传文件保存到一个目标文件中
			//uploadfile.transferTo(new File(path+File.separator+UUID.randomUUID()+filename));
			uploadfile.transferTo(filepath);
			return "uploadsuccess";
		}else {
			return "error";
		}
	}

}
