package com.codersnation.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.codersnation.bean.AdminLoginBean;
import com.codersnation.bean.SMSBean;
import com.codersnation.controller.exception.CodersNationException;
import com.codersnation.controller.exception.ExceptionEnum;
import com.codersnation.service.AdminService;
import com.codersnation.service.UserService;
import com.codersnation.util.FailResponse;
import com.codersnation.util.SuccessResponse;

@RestController
@CrossOrigin
public class AdminController {
	@Autowired
	UserService userService;
	@Autowired
	AdminService adminService;
	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public Object login(@RequestBody AdminLoginBean adminLoginBean ) {
		try {
			return adminService.validateAdminLogin(adminLoginBean);
		}
		catch(CodersNationException e) {
			return new FailResponse(e);
		}
		
	}
	@RequestMapping(value = "/getadminuser", method = RequestMethod.GET)
	public Object getAdminUserInfo(@RequestHeader("token") String token) {
		try {
			return adminService.getAdminUser(token);
		}
		catch(CodersNationException e) {
			return new FailResponse(e);
		}
	}
	
	@RequestMapping(value = "/sendsms", method = RequestMethod.POST)
	public Object sendSMS(@RequestHeader("token") String token,@RequestBody SMSBean bean) {
		try {
			int batch=100;
			List<String[]> listN=new ArrayList<String[]>();
			String[] allnumbers=bean.getNumbers();
			List<String> numbers = Arrays.asList(allnumbers);  
			 if(numbers.size()>batch) {
		        	int rem=numbers.size();
		        	int i=0;
		        	int iter=0;
		        	while(i!=numbers.size()) {
		        		String[] x=new String[batch];
		        		int k=0;
		        		if(rem>batch)
		        			iter=batch;
		        		else
		        			iter=rem;
		        		for(int j=i;j<i+iter;j++) {
		        			
		        			x[k]=numbers.get(j);
		        			k++;
		        		}
		        		listN.add(x);
		        		i=i+batch;
		        		rem=rem-batch;
		        	}
		        	
		        }
		        else {
		        	String[] x=new String[numbers.size()];
		        	for(int j=0;j<numbers.size();j++) {
	        			x[j]=numbers.get(j);
	        		}
		        	listN.add(x);
		        }
			 List<Object> lists=new ArrayList<>();
			 for(String[] eachBatch:listN) {
				 bean.setNumbers(eachBatch);
				lists.add(adminService.sendsms(bean,token));
			 }
			 
			return lists;
		}
		catch(CodersNationException e) {
			return new FailResponse(e);
		}
	}
	
	@RequestMapping(value = "/import", method = RequestMethod.POST)
	    public Object mapReapExcelDatatoDB(@RequestHeader("token") String token,@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {

		int batch=100;
		List<String[]> listN=new ArrayList<String[]>();
	       List<String> numbers = new ArrayList<String>();
	        XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	        XSSFSheet worksheet = workbook.getSheetAt(0);

	        for(int i=0;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	            XSSFRow row = worksheet.getRow(i);
	            String number=row.getCell(0).getStringCellValue();
	            numbers.add(number);
//	                tempStudentList.add(tempStudent);   
	        }
	        System.out.println(numbers);
	       return new SuccessResponse(ExceptionEnum.NUMBERS_GENERATED, numbers);
	    }
}
