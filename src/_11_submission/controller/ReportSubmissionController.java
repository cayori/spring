package _11_submission.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class ReportSubmissionController {

	String uploadPath = "C:\\upload\\";
	
	@RequestMapping(value="/report/submission.do", method = RequestMethod.GET)
	public String form() {
		return "_11_submission/report/submissionForm";
	}
	
	@RequestMapping(value="/report/submitReport1.do", method = RequestMethod.POST)
	public String submitReport1(@RequestParam("studentNumber") String studentNumber,
								@RequestParam("report") MultipartFile report) {
		String fileName = report.getOriginalFilename();
		File uploadFile = new File(uploadPath+fileName);
		if(uploadFile.exists()) {
			fileName = new Date().getTime() + fileName;
			uploadFile = new File(uploadPath+fileName);
		}
		try {
			report.transferTo(uploadFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printInfo(studentNumber, report);
		return "_11_submission/report/submissionComplete";
	}
	
	@RequestMapping(value="/report/submitReport2.do", method=RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request) {
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");
		String fileName = report.getOriginalFilename();
		File uploadFile = new File(uploadPath+fileName);
		if(uploadFile.exists()) {
			fileName = new Date().getTime() + fileName;
			uploadFile = new File(uploadPath+fileName);
		}
		try {
			report.transferTo(uploadFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printInfo(studentNumber, report);
		return "_11_submission/report/submissionComplete";
	}
	
	@RequestMapping(value="/report/submitReport3.do", method=RequestMethod.POST)
	public String submitReport3(ReportCommand reportCommand) {
		String fileName = reportCommand.getReport().getOriginalFilename();
		File uploadFile = new File(uploadPath+fileName);
		if(uploadFile.exists()) {
			fileName = new Date().getTime() + fileName;
			uploadFile = new File(uploadPath+fileName);
		}
		try {
			reportCommand.getReport().transferTo(uploadFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printInfo(reportCommand.getStudentNumber(), reportCommand.getReport());
		return "_11_submission/report/submissionComplete";
	}
	
	private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber+" 이(가) 업로드 한 파일: "+report.getOriginalFilename());
	}
}
