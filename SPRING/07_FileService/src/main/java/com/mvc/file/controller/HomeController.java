package com.mvc.file.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mvc.file.service.UploadService;

/* <Context docBase="C:/upload" path="/photo" />
 *  파일업로드를 진행시 위의 내용을 server.xml 에 추가 해 주자 
 */


@Controller
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());	

	@Autowired UploadService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {		
		logger.info("홈으로 이동");
		return "home";
	}
	
	//text 로 오는 파라메터는 @RequestParam 으로 받고
	//File 형태로 오는 파라메터는 MultipartFile 로 받는다.(commons-io 라이브러리가 없으면 사용 불가)
	@RequestMapping(value = "/upload", method = RequestMethod.POST) //post 방식으로 upload 요청을 받으면 아래의 메서드를 실행
	//뷰에서 보낸 text 는 @RequestParam으로, file은  MultipartFile 로 받는데 보낼때 name과 받을 때 파라메터 이름이 같아야 함
	public String upload(Model model, MultipartFile uploadFile, @RequestParam String title) { 
		logger.info("업로드 요청 : {}",title); //받은 title 확인
		service.upload(uploadFile); //받아온 uploadFile 을 UploadService 의 upload 메서드에게 매개변수로 넘겨주면서 실행 요청 
		return "redirect:/filelist";
	}
	
	//파일 리스트 보기
	@RequestMapping(value = "/filelist", method = RequestMethod.GET)
	public String filelist(Model model) {		
		logger.info("filelist 요청");
		
		ArrayList<String> list = service.filelist();
		model.addAttribute("list", list);
		
		return "result";
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model model, @RequestParam String file) {		
		logger.info("{} delete 요청",file);
		
		service.fileDelete(file);
		
		return "redirect:/filelist";
	}
	
	
	//여러 파일 업로드(파일이 한개가 아니기 때문에 배열로 받아준다)
	@RequestMapping(value = "/multiupload", method = RequestMethod.POST)
	public String multiupload(Model model, MultipartFile[] files) {		
		logger.info("upload 한 파일의 수 : {}",files.length);
		int count = service.multiupload(files);
		logger.info("업로드한 파일 갯수 : {}",count);
		return "redirect:/filelist";
	}
	
	
	
	
	
}


























