package _01_register.controller;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import _00_init.GlobalService;
import _01_register.model.*;
/*
 * 本程式讀取使用者輸入資料，進行必要的資料轉換，檢查使用者輸入資料，
 * 進行Business Logic運算，依照Business Logic運算結果來挑選適當的畫面
 * 
 */
//
//啟動檔案上傳的功能：
//1. <form>標籤的 method屬性必須是"post", 而且
//    enctype屬性必須是"multipart/form-data"
//注意：enctype屬性的預設值為"application/x-www-form-urlencoded"
//2. 定義可以挑選上傳檔案的表單欄位：
//<input type='file' name='user-defined_name' />
//
//所謂 HTTP multipart request是指由Http客戶端(如瀏覽器)所建構的ㄧ種請求，
//用來上傳一般的表單資料(form data)與檔案。
//參考網頁：http://stackoverflow.com/questions/913626/what-should-a-multipart-http-request-with-multiple-files-look-like
//
//Servlet規格書一直到Servlet 3.0才提出標準API將檔案上傳的功能標準化。
//
//在Servlet 3.0中，若要能夠處理瀏覽器送來的HTTP multipart request, 
//我們撰寫的Servlet程式必須以註釋
//『javax.servlet.annotation.MultipartConfig』來加以說明。
//
//MultipartConfig的屬性說明:
//location: 上傳之表單資料與檔案暫時存放在Server端之路徑，此路徑必須存在。
//fileSizeThreshold: 檔案的大小臨界值，超過此臨界值，上傳檔案會用存放在硬碟，
//否則存放在主記憶體。
//maxFileSize: 上傳單一檔案之長度限制，如果超過此數值，Web Container會丟出例外
//maxRequestSize: 上傳所有檔案之總長度限制，如果超過此數值，Web Container會丟出例外
@MultipartConfig(location = "", 
fileSizeThreshold = 1024 * 1024, 
maxFileSize = 1024 * 1024 * 500, 
maxRequestSize = 1024 * 1024 * 500 * 5)
@WebServlet("/_01_register/register.do")
public class RegisterServletMP extends HttpServlet {
	private static final long serialVersionUID = 1L;	
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
    	request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsg = new HashMap<String, String>();
		// 準備存放註冊成功之訊息的Map物件
		Map<String, String> msgOK = new HashMap<String, String>();
        // 註冊成功後將用response.sendRedirect()導向新的畫面，所以需要
		// session物件來存放共用資料。
		HttpSession session = request.getSession();
        request.setAttribute("MsgMap", errorMsg);  //顯示錯誤訊息
        session.setAttribute("MsgOK", msgOK);      //顯示正常訊息

		String memberID = "";
		String password  = "" ;
		String password2  = "";
		String name  = "";
		String email  = "";
		String addr  = "";
		String tel  = "";
		String expericnceStr  = "";
		String fileName = "";
		int experience = 0;
		long sizeInBytes = 0;
		InputStream is = null;
		Collection<Part> parts = request.getParts(); // 取出HTTP multipart request內所有的parts
		GlobalService.exploreParts(parts, request);
		// 由parts != null來判斷此上傳資料是否為HTTP multipart request
		if (parts != null) {   // 如果這是一個上傳資料的表單				
			for (Part p : parts) {   
				String fldName = p.getName();
				String value = request.getParameter(fldName);
				// 1. 讀取使用者輸入資料
				if (p.getContentType() == null) {
					if (fldName.equals("mid")) {
						memberID = value;
					} else if (fldName.equals("password")) {
						password = value;
					} else if (fldName.equalsIgnoreCase("password2")) {
						password2 = value;
					} else if (fldName.equalsIgnoreCase("name")) {
						name = value;
					} else if (fldName.equalsIgnoreCase("eMail")) {
						email = value;
					} else if (fldName.equalsIgnoreCase("address")) {
						addr = value;  
					} else if (fldName.equalsIgnoreCase("tel")) {
						tel = value;
					} else if (fldName.equalsIgnoreCase("experience")) {
						expericnceStr = value;  
					}
				} else {
					fileName = GlobalService.getFileName(p); // 此為圖片檔的檔名
					if (fileName != null && fileName.trim().length() > 0) {
						sizeInBytes = p.getSize();
						is = p.getInputStream();
					} else {
						errorMsg.put("errPicture", "必須挑選圖片檔");
					}
				
				}
			}
			// 2. 進行必要的資料轉換
			
			try {
				experience = Integer.parseInt(expericnceStr.trim());
			} catch (NumberFormatException e) {
				errorMsg.put("errorFormat","網路購物經驗格式錯誤，應該為整數");
			}
			// 3. 檢查使用者輸入資料
			if (memberID == null || memberID.trim().length() == 0) {
				errorMsg.put("errorIDEmpty","帳號欄必須輸入");
			}
			if (password == null || password.trim().length() == 0) {
				errorMsg.put("errorPasswordEmpty","密碼欄必須輸入");
			}
			if (password2 == null || password2.trim().length() == 0) {
				errorMsg.put("errorPassword2Empty","密碼確認欄必須輸入");
			}
			if (password.trim().length() > 0 && password2.trim().length() > 0){
				if (!password.trim().equals(password2.trim())){
					errorMsg.put("errorPassword2Empty","密碼欄必須與確認欄一致");
					errorMsg.put("errorPasswordEmpty","*");
				}			
			}
			if (name == null || name.trim().length() == 0) {
				errorMsg.put("errorName","姓名欄必須輸入");
			}
			if (addr == null || addr.trim().length() == 0) {
				errorMsg.put("errorAddr","地址欄必須輸入");
			}
			if (email == null || email.trim().length() == 0) {
				errorMsg.put("errorEmail","電子郵件欄必須輸入");
			}
			if (tel == null || tel.trim().length() == 0) {
				errorMsg.put("errorTel","電話號碼欄必須輸入");
			}
			if (experience < 0) {
				errorMsg.put("errorFormat","網路購物經驗應該為正整數或 0 ");
			}
		} else {
				errorMsg.put("errTitle", "此表單不是上傳檔案的表單");
		}
			// 如果有錯誤
			if (!errorMsg.isEmpty()) {
				// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
				return;
			}
			try {
			// 4. 進行Business Logic運算
			// RegisterServiceFile類別的功能：
			// 1.檢查帳號是否已經存在
			// 2.儲存會員的資料 
			RegisterServiceDB rs = new RegisterServiceDB();  
			if (rs.idExists(memberID)) {
				errorMsg.put("errorIDDup","此代號已存在，請換新代號");
			} else {
					MemberBean mem = new MemberBean(memberID, 
						name, password, addr, email, tel, experience);
					// 將MemberBean mem立即寫入Database				
					int n = rs.saveMember(mem, is, sizeInBytes, fileName);
					if ( n == 1) {
						msgOK.put("InsertOK","<Font color='red'>新增成功，請開始使用本系統</Font>");
						response.sendRedirect("../index.jsp");
						return;
					} else {
						errorMsg.put("errorIDDup","新增此筆資料有誤(RegisterServlet)");
					}
			}
			// 5.依照 Business Logic 運算結果來挑選適當的畫面
			if (!errorMsg.isEmpty()) {
				// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
				return;
			}		
		} catch (Exception e) {
			e.printStackTrace();
			errorMsg.put("errorIDDup", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		}		
     }
}   