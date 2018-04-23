package com.test.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.test.model.User;
//区分模块
@RequestMapping(value="/user")
@Controller
public class UserController {
	
	//requestMapping中可用相关符号进行模糊匹配 如下 **代表任意层数，任意字符
	/*？：匹配一个字符

	　　*：匹配任意字符

	　　**：匹配多层路径
	*/
	@RequestMapping(value="/**/user_list")
	public String listuser() {
		return "user_list";
	}
	
	/**
	 * 通过链接访问该方法，参数注入获得参数
	 * requestMapping路径中使用{} 表明注入的值
	 * 使用了该注解  @PathVariable(value="") 注入参数
	 * 
	 * @param id
	 * @param name
	 * @return
	 * @author lujian
	 * @create 2017年5月3日
	 */
	@RequestMapping(value="/user_view/{id},{name}")
	public String getUser(@PathVariable(value="id")int id, @PathVariable(value="name")String name) {
		System.out.println(id + " " +name);
		return "user_view";
	}
	
	/**
	 * 通过链接访问该方法，参数注入获得参数 2
	 * requestMapping无需添加变量传值
	 * 使用了该注解  @RequestParam(value="") 注入参数
	 * 在页面访问路径中，需要是  localhost:8080/prj/user_view?name=zhangsan&age=1 这种一般形式
	 * 在requestParam这注解中 还有校验和赋予默认值的功能    如下方法中的age
	 * 
	 * 
	 * @param name
	 * @param age
	 * @return
	 * @author lujian
	 * @create 2017年5月3日
	 */
	@RequestMapping(value="/user_view")
	public String getUser2(@RequestParam(value="name")String name, @RequestParam(value="age",defaultValue="10",required=false)int age) {
		System.out.println(age + " " +name);
		return "user_view";
	}
	
	
	//rest风格 curd
	//增（post）删（delete）改（put）查（get）
	//	1.web.xml中添加 过滤器
	//	2.form表单请求使用post，
	//	3.使用hidden隐藏域传递_method 令牌，value为put或delete
	//	4.想使用put和delete时，form中不能使用enctype="multipart/form-data",在spring mvc中上传文件一律使用post
	/**
	 * rest风格 put
	 * @param userId
	 * @return
	 * @author lujian
	 * @create 2017年5月5日
	 */
	@RequestMapping(value="/testrest/{id}", method=RequestMethod.PUT)
	public String testrestPut(@PathVariable(value="id")int userId) {
		System.out.println("put "+ userId);
		return "success";
	}
	
	/**
	 * rest风格 delete
	 * @param userId
	 * @return
	 * @author lujian
	 * @create 2017年5月5日
	 */
	@RequestMapping(value="/testrest/{id}", method=RequestMethod.DELETE)
	public String testrestDelete(@PathVariable(value="id")int userId) {
		System.out.println("delete "+ userId);
		return "success";
	}
	
	/**
	 * rest风格 post
	 * @param userId
	 * @return
	 * @author lujian
	 * @create 2017年5月5日
	 */
	@RequestMapping(value="/testrest/{id}", method=RequestMethod.POST)
	public String testrestPost(@PathVariable(value="id")int userId) {
		System.out.println("POST "+ userId);
		return "success";
	}
	
	/**
	 * rest风格 get
	 * @param userId
	 * @return
	 * @author lujian
	 * @create 2017年5月5日
	 */
	@RequestMapping(value="/testrest/{id}", method=RequestMethod.GET)
	public String testrestGet(@PathVariable(value="id")int userId) {
		System.out.println("GET "+ userId);
		return "success";
	}
	
	
	//@CookieValue
	/**
	 * 从cookie中取值使用@CookieValue这个注解
	 * @param value
	 * @return
	 * @author lujian
	 * @create 2017年5月5日
	 */
	@RequestMapping(value="/getCookieValue")
	public String testCookieValue(@CookieValue(value="JSESSIONID")String value) {
		System.out.println("value : "+value);
		return "success";
	}
	
	
	//@RequestHeader
	/**
	 * 获取请求头中相关信息，和上述cookievalue差不多
	 * 使用的是@RequestHeader注解
	 * @param value
	 * @return
	 * @author lujian
	 * @create 2017年5月5日
	 */
	@RequestMapping("/getHeaderValue")
	public String testRequestHeader(@RequestHeader(value="Accept-Language")String value) {
		System.out.println("value : "+value);
		return "success";
	}
	
	//表单获取数据封装成model类
	/**
	 * Pojo测试 
	 * @param user
	 * @return
	 * @author lujian
	 * @create 2017年5月5日
	 */
	@RequestMapping("/testPojo")
	public String testPojo(User user) {
		System.out.println(user);
		return "success";
	}
	
	//ModelAndView
	/**
	 * 除了返回一个视图，还可以向request请求域中添加数据，在页面呈现
	 * @param value
	 * @return
	 * @author lujian
	 * @create 2017年5月5日
	 */
	@RequestMapping("/testModelAndView/{name}")
	public ModelAndView testModelAndView(@PathVariable(value="name")String value) {
		User user = new User();
		user.setName("蔡彧");
		User user1 = new User();
		user1.setName("吴友德");
		User user2 = new User();
		user2.setName("李浩");
		User user3 = new User();
		user3.setName("梁慧");
		
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
		String viewName = "user/modelAndView";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("name", value);
		modelAndView.addObject("user",user);
		modelAndView.addObject("userList",userList);
		return modelAndView;
	}
	
	
	//多视图解析测试
	/**
	 * 测试解析html
	 * @return
	 * @author lujian
	 * @create 2017年5月5日
	 */
	@RequestMapping("/testHtml1")
	public String testHtml() {
		return "html_hello1";
	}
	
	/**
	 * 测试解析html2
	 * @return
	 * @author lujian
	 * @create 2017年5月5日
	 */
	@RequestMapping("/testHtml2")
	public String testHtml2() {
		return "hello2";
	}
	
	/**
	 * 测试解析html3
	 * @return
	 * @author lujian
	 * @create 2017年5月5日
	 */
	@RequestMapping("/testHtml3")
	public String testHtml3() {
		return "testh_hello1";
	}
	
	/**
	 * 测试json1
	 * 返回json数据
	 * @return
	 * @author lujian
	 * @create 2017年5月9日
	 */
	@ResponseBody
	@RequestMapping("/testJson1")
	public User testJson1() {
		User user = new User();
		user.setName("张三");
		return user;
	}
	
	/**
	 * 测试json1
	 * 返回json格式字符串数据
	 * （如果手动再转换一次，会中文乱码）
	 * @return
	 * @author lujian
	 * @throws Exception 
	 * @create 2017年5月9日
	 */
	@RequestMapping("/testJson2")
	public @ResponseBody List<Object> testJson2(@RequestParam(value="userId")int userId) throws Exception{
		List<Object> objList = new ArrayList<Object>();
		User user = new User();
		user.setUserId(userId);
		user.setName("李四");
			
		String newName = "hei邓超";
		
//		ObjectMapper mapper = new ObjectMapper();
//		String userjson = mapper.writeValueAsString(user);
		
		objList.add(user);
		objList.add(newName);
		return objList;
	}
	
	
	
	
	
	
	
	
	
	/*===========================================================测试上传============================================================*/
	//获得MultipartFile原理 :MultipartHttpServletRequest mulReq = (MultipartHttpServletRequest) request;
	//	  				  MultipartFile file = mulReq.getFile("前台图片的name值");
	//
	//结论: springMVC的transferTo > apache > 流   > 没有字节缓冲的流             
	//	   transferTo差不多在10毫秒左右，   apache和流上传差不多，都在100~200毫秒左右
	
	
	
	/**
	 * 测试上传文件页面
	 * @return
	 * @author lujian
	 * @create 2017年6月13日
	 */
	@RequestMapping("/openToTestUpload")
	public ModelAndView openToTestUpload() {
		ModelAndView view = new ModelAndView("/file1");
		return view;
	}
	
	
	//(spring mvc的上传文件方式,此外常用的还有两种，一个是流的方式，一个是spring的方式（母鸡。。）,还有apach自带的fileUtils的方法)
	/**
	 * 上传文件(CommonsMultipartFile)
	 * @return
	 * @author lujian
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @create 2017年6月13日
	 */
	@RequestMapping("/upload1")
	public ModelAndView testUpload(@RequestParam("file")CommonsMultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		//long begintime = new Date().getTime();
		long begintime = System.currentTimeMillis();
		
		ModelAndView view = new ModelAndView("/file1");
		
		String pathName = "upload/";
		String fileName = file.getOriginalFilename();
		String path = request.getServletContext().getRealPath(pathName + fileName);
		
		File file1 = new File(path);
		if (!file1.exists()) {
			file1.mkdirs();
		}
		file.transferTo(file1);
		
		
		long overtime = System.currentTimeMillis();
		long useTime = overtime-begintime;
		
		
		view.addObject("fileUrl", pathName + fileName);
		view.addObject("useTime", useTime);
		return view;
	}
	
	/**
	 * 上传文件(MultipartFile,和上面的区别是 MultipartFile可以直接使用，不用在前面加@RequestParam注解)
	 * @return
	 * @author lujian
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @create 2017年6月13日
	 */
	@RequestMapping("/upload2")
	public ModelAndView testUpload2(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
//		ModelAndView view = new ModelAndView("/file1");
//		String fileName = file.getOriginalFilename();
//		File file1 = new File("D:/upload_springMvc/"+fileName);
//		file.transferTo(file1);
		
		long begintime = System.currentTimeMillis();
		
		ModelAndView view = new ModelAndView("/file1");
		String pathName = "upload/";
		String fileName = file.getOriginalFilename();
		String path = request.getServletContext().getRealPath(pathName + fileName);
		
		File file1 = new File(path);
		if (!file1.exists()) {
			file1.mkdirs();
		}
		file.transferTo(file1);
		
		long overtime = System.currentTimeMillis();
		long useTime = overtime-begintime;
		
		view.addObject("fileUrl1", pathName + fileName);
		view.addObject("useTime1", useTime);
		return view;
	}
	
	/**
	 * 上传文件(使用最原始 流的方式)---这个巨慢
	 * @return
	 * @author lujian
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @create 2017年6月13日
	 */
	@RequestMapping("/upload3")
	public ModelAndView testUpload3(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		ModelAndView view = new ModelAndView("/file1");
		long begintime = System.currentTimeMillis();
		
		
		
		String pathName = "upload/";
		String fileName = file.getOriginalFilename();
		String fileUrl = pathName + fileName;
		String path = request.getServletContext().getRealPath(fileUrl);
		
		OutputStream os = new FileOutputStream(path);
		InputStream is = file.getInputStream();
		
		int byteTemp; 
		while((byteTemp = is.read())!=-1) {
			os.write(byteTemp);
		}
		
		os.flush();
		os.close();
		is.close();
		
		
		long overtime = System.currentTimeMillis();
		long useTime = overtime-begintime;
		view.addObject("fileUrl2",fileUrl);
		view.addObject("useTime2", useTime);
		return view;
	}
	
	/**
	 * 上传文件(使用最原始 流的方式)--
	 * 我看到大部分项目使用io上传文件中间都使用到了一个字节数组，
	 * 并且 flush放在了while里面
	 * 确实快的很多
	 * 
	 * @return
	 * @author lujian
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @create 2017年6月13日
	 */
	@RequestMapping("/upload4")
	public ModelAndView testUpload4(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		ModelAndView view = new ModelAndView("/file1");
		long begintime = System.currentTimeMillis();
		
		
		
		String pathName = "upload/";
		String fileName = file.getOriginalFilename();
		String fileUrl = pathName + fileName;
		String path = request.getServletContext().getRealPath(fileUrl);
		
		OutputStream os = new FileOutputStream(path);
		InputStream is = file.getInputStream();
		byte[] buffer = new byte[1024*1024];
		
		int byteTemp; 
		int length = 0;
		while((byteTemp = is.read(buffer))!=-1) {
			//os.write(byteTemp);
			length += byteTemp;
			os.write(buffer, 0, byteTemp);
			//flush放在里面和外面，经过测试，虽然差不多，但是平均下来放在里面更快
			os.flush();
		}
		
		os.close();
		is.close();
		
		
		long overtime = System.currentTimeMillis();
		long useTime = overtime-begintime;
		view.addObject("fileUrl3",fileUrl);
		view.addObject("useTime3", useTime);
		view.addObject("length", length);
		return view;
	}
	
	
	/**
	 * 上传文件(使用最原始 流的方式)--
	 * 这里使用网上看到的bufferInputStream来试一下，不是用中间数组还是慢
	 * 这里输入流使用缓冲流来读取，写的时候也要用缓冲流来写，要不然文件会损坏
	 * 得出结论 和上面不用缓冲流的差不多
	 * @return
	 * @author lujian
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @create 2017年6月13日
	 */
	@RequestMapping("/upload5")
	public ModelAndView testUpload5(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		ModelAndView view = new ModelAndView("/file1");
		long begintime = System.currentTimeMillis();
		
		
		
		String pathName = "upload/";
		String fileName = file.getOriginalFilename();
		String fileUrl = pathName + fileName;
		String path = request.getServletContext().getRealPath(fileUrl);
		
		OutputStream os = new FileOutputStream(path);
		InputStream is = file.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(is);
		BufferedOutputStream bos = new BufferedOutputStream(os);
		
		byte[] buffer = new byte[1024*1024];
		int byteTemp; 
		while((byteTemp = bis.read(buffer))!=-1) {
			bos.write(buffer, 0, byteTemp);
			bos.flush();
		}
		
		bos.close();
		os.close();
		bis.close();
		is.close();
		
		
		long overtime = System.currentTimeMillis();
		long useTime = overtime-begintime;
		view.addObject("fileUrl4",fileUrl);
		view.addObject("useTime4", useTime);
		return view;
	}
	
	
	/**
	 * 上传文件(使用apache自带的fileutils)
	 * @return
	 * @author lujian
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @create 2017年6月13日
	 */
	@RequestMapping("/upload6")
	public ModelAndView testUpload6(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		long begintime = System.currentTimeMillis();
		
		ModelAndView view = new ModelAndView("/file1");
		String pathName = "upload/";
		String fileName = file.getOriginalFilename();
		String fileUrl = pathName + fileName;
		String path = request.getServletContext().getRealPath(fileUrl);
		
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path));
		
		
		
		long overtime = System.currentTimeMillis();
		long useTime = overtime-begintime;
		
		view.addObject("fileUrl5", fileUrl);
		view.addObject("useTime5", useTime);
		return view;
	}
	
	
	/**
	 * 上传文件(使用spring的方法，这个应用据说较多),可以用于多文件上传,很灵活
	 * @return
	 * @author lujian
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @create 2017年6月13日
	 */
	@RequestMapping("/upload7")
	public ModelAndView testUpload7(HttpServletRequest request) throws IllegalStateException, IOException {
		long begintime = System.currentTimeMillis();
		
		ModelAndView view = new ModelAndView("/file1");
		String fileUrl1="";
		String fileUrl2="";
		
		//解析servlet上下文
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getServletContext());
		//判断有没有multipart/form-data
		if(commonsMultipartResolver.isMultipart(request)) {
			//MultipartHttpServletRequest提供处理一个内容中的多部分内容的其他方法 ，多内容如servlet请求中允许访问上传的文件。
			MultipartHttpServletRequest multipartReuqest = (MultipartHttpServletRequest) request;
			
			//取得所有上传文件的name遍历
			Iterator<String> fieldNames = multipartReuqest.getFileNames();
			while(fieldNames.hasNext()) {
				String fieldName = fieldNames.next();
				MultipartFile file = multipartReuqest.getFile(fieldName);
				
				if(file!= null) {
					if(!file.isEmpty()) {
					
						String fileUrl = "upload/" + file.getOriginalFilename();
						String path = request.getServletContext().getRealPath(fileUrl);
						file.transferTo(new File(path));
	
						//判断是哪个上传name
						if(fieldName.equals("file")) {
							fileUrl1 = "upload/" + file.getOriginalFilename();
						}else if(fieldName.equals("file1")) {
							fileUrl2 = "upload/" + file.getOriginalFilename();
						}
					}
				}
			}
			
		}
		
		long overtime = System.currentTimeMillis();
		long useTime = overtime-begintime;
		
		view.addObject("fileUrl6", fileUrl1);
		view.addObject("fileUrl7", fileUrl2);
		view.addObject("useTime6", useTime);
		return view;
	}
	
	/**
	 * 下载文件(还有一种是使用超链接的方法下载，在上面一个方法已经有了）
	 * Java 通用方法
	 * 返回类型是String
	 * @return
	 * @author lujian
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @create 2017年6月13日
	 */
	@RequestMapping("/download")
	public String testdownload(String fileName, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		
		String filePath = request.getServletContext().getRealPath("upload/"+fileName);
		File file = new File(filePath);
		
		OutputStream os = response.getOutputStream();
		InputStream is = new FileInputStream(file);
		byte[] buffer = new byte[1024*1024];
		
		int temp=0;
		while((temp=is.read(buffer))!=-1) {
			os.write(buffer, 0, temp);
		}
		
		os.close();
		is.close();
		
		return null;
	}
	
	/**
	 * 下载文件
	 * ResponseEntity方法
	 * @return
	 * @author lujian
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @create 2017年6月13日
	 */
	@RequestMapping("/download1")
	public ResponseEntity<byte[]> testdownload1(String fileName, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
		byte[] buffer = null;
		int count = 0;
		
		String filePath = request.getServletContext().getRealPath("upload/"+fileName);
		File file = new File(filePath);
		InputStream is = new FileInputStream(file);
		
		//这里要这么写，
		//如果不写while直接成buffer = new byte[count]有可能调用available()方法时，对发发送的数据可能还没有到达，你得到的count是0。 
		while(count == 0) {
			count = is.available();
		}
		buffer = new byte[count];
		is.read(buffer);
		
		is.close();
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.MULTIPART_FORM_DATA);
		//fileName = new String(fileName.getBytes("ISO8859-1"),"UTF-8");  
		header.add("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("UTF-8"),"ISO8859-1"));
		//也可以这样写 headers.setContentDispositionFormData("attachment", fileName);   
		
		ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(buffer, header, HttpStatus.OK);
		
		return entity;
	}
}
