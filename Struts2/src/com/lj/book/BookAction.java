package com.lj.book;

import java.io.File;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BookAction extends ActionSupport{
	
	private File bookPic;
	private String bookPicContentType;
	private String bookPicFileName;
	private InputStream inputStream;
	private String contentType;
	private String fileName;
	
	
	/**
	 * 用一句话说明这个方法做什么 
	 * @return
	 * @author lujian
	 * @create 2017年4月17日
	 */
	public String add() {
		System.out.println("add Method");
		return SUCCESS;
	}
	
	public String del() {
		System.out.println("del Method");
		return SUCCESS;
	}
	
	public String search() {
		System.out.println("search Method");
		return SUCCESS;
	}
	
	//上传
	public String upload() throws IOException {
		System.out.println(1);
		//1:上传文件
		FileUtils.copyFile(bookPic, new File("H:/upload",bookPicFileName));
		//2：上传路径里的文件
		//FileUtils.copyDirectory(new File("H:/sj"), new File("H:/upload"));
		System.out.println(2);
		return SUCCESS;
	}
	
	@Override  
    public void addActionError(String anErrorMessage) {  
        // 这里要先判断一下，是我们要替换的错误，才处理  
        if (anErrorMessage  
                .startsWith("the request was rejected because its size")) {  
            Matcher m = Pattern.compile("\\d+").matcher(anErrorMessage);  
            String s1 = "";  
            if (m.find())  
                s1 = m.group();  
            String s2 = "";  
            if (m.find())  
                s2 = m.group();  
            // 偷梁换柱，将信息替换掉  
            super.addActionError("你上传的文件大小（" + s1 + "）超过允许的大小（" + s2 + "）");  
            // 也可以改为在Field级别的错误  
            // super.addFieldError("file","你上传的文件大小（" + s1 + "）超过允许的大小（" + s2 +  
            // "）");  
        } else {// 否则按原来的方法处理  
            super.addActionError(anErrorMessage);  
            try {
				super.input();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }  
    }  
	
	//下载 视频中的方法
	public String download1() throws FileNotFoundException {
		
		return SUCCESS;
	}
	
	//
	public String download2() {
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getBookPicContentType() {
		return bookPicContentType;
	}

	public void setBookPicContentType(String bookPicContentType) {
		this.bookPicContentType = bookPicContentType;
	}

	public String getFileName() throws UnsupportedEncodingException {
		return fileName = new String("啊啊1862.jpg".getBytes(),"ISO8859-1");
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return ServletActionContext.getServletContext().getMimeType(fileName);
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public InputStream getInputStream() throws FileNotFoundException {
		inputStream = new FileInputStream("H:/upload/1862.jpg");
		if(inputStream == null) {
			System.out.println("inputStream is null");
		}
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public File getBookPic() {
		return bookPic;
	}

	public void setBookPic(File bookPic) {
		this.bookPic = bookPic;
	}

	public String getBookPicFileName() {
		return bookPicFileName;
	}

	public void setBookPicFileName(String bookPicFileName) {
		this.bookPicFileName = bookPicFileName;
	}

}
