package spring.sts.gyu;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.member.MemberDAO;
import spring.model.member.MemberDTO;
import spring.sts.utility.Utility;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO dao;
	
	@RequestMapping(value ="/member/delete", method =RequestMethod.POST)
	public String delete(String id, String col, String word, String nowPage, Model model) throws Exception {
		Map map2 = new HashMap();
	      //마지막페이지 처리를 위한
	      map2.put("col", col);
	      map2.put("word", word);
	      int total = dao.total(map2);   //댓글전체레코드값을 가져와서
	      int totalPage = (int)(Math.ceil((double)total/5)); //올림 전체페이지
	      
	      
	      int nowPage2 = Integer.parseInt(nowPage);
	      
	      boolean flag = dao.delete(id);
	      
	      if(flag) {
	         if(nowPage2!=1 && nowPage2 == totalPage && total % 5 == 1) { 
	         //현페이지가 마지막페이지고 레코드가 하나만 남은 경우
	         nowPage2 = nowPage2-1;
	         }
	         model.addAttribute("flag", flag);
	         model.addAttribute("col", col);
	         model.addAttribute("word", word);
	         model.addAttribute("nowPage", nowPage2);
	         return "member/deleteProc.tiles";
	      }else {
	         return "error/error";
	      }
	}
	
	@RequestMapping(value ="/member/delete", method =RequestMethod.GET)
	public String delete() {
		
		return "member/deleteForm.tiles";
	}
	
	@RequestMapping(value ="/member/update", method =RequestMethod.POST)
	public String update(MemberDTO dto, Model model, String col, String word, String nowPage) throws Exception {
		boolean flag = dao.update(dto);
		if(flag) {
			model.addAttribute("col",col);
			model.addAttribute("word",word);
			model.addAttribute("nowPage",nowPage);
			return "redirect:list";			
		} else {
			return "error/error";
		}
	}
	
	@RequestMapping(value ="/member/update", method =RequestMethod.GET)
	public String update(Model model,String id) throws Exception {
		
		model.addAttribute("dto", dao.read(id));
		return "member/update.tiles";
	}
	
	@RequestMapping(value ="/member/read", method =RequestMethod.GET)
	public String read(Model model, MemberDTO dto, HttpServletRequest request) throws Exception {
		
		dto = dao.read(dto.getId());
		model.addAttribute("dto", dto);
		
		return "member/read.tiles";
	}
	
	@RequestMapping("/member/list")
	public String list(HttpServletRequest request) throws Exception {
		String col = Utility.checkNull(request.getParameter("col")); // null인 경우도 허용하는 메소드
		String word = Utility.checkNull(request.getParameter("word")); // 가장 첫페이지인 리스트에서 col, word값을 받기 위해
		if (col.equals("total")) { // 전체출력은 word값 공란 허용
			word = "";
		}
		// 페이지관련
		int nowPage = 1; // 현재 보고있는 페이지
		if (request.getParameter("nowPage") != null) {
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		int recordPerPage = 10; // 한 페이지당 보여줄 레코드 갯수
		// DB에서 데이터를 가져올 순번
		int sno = ((nowPage - 1) * recordPerPage) + 1;
		int eno = nowPage * recordPerPage;

		Map map = new HashMap();
		map.put("col", col);
		map.put("word", word);
		map.put("sno", sno);
		map.put("eno", eno);

		List<MemberDTO> list = dao.list(map); // 맵을 매개로 list객체 생성
		int totalRecord = dao.total(map); // 맵을 매개로 전체출력 메소드 호출해 값을 totalRecord로 저장
		String paging = Utility.paging2("list", totalRecord, nowPage, recordPerPage, col, word);

		// 4. 결과를 request 또는 session의 setAttribute()메소드를 사용하여 저장
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		request.setAttribute("col", col);
		request.setAttribute("word", word);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("list", list);
		
		
		return "member/list.tiles";
	}
	
	@RequestMapping(value = "/member/agreement", method = RequestMethod.GET)
	public String agreement() {

		return "member/agreement.tiles";
	}

	@RequestMapping(value = "/member/create", method = RequestMethod.GET)
	public String create() {

		return "member/create.tiles";
	}

	@RequestMapping(value = "/member/create", method = RequestMethod.POST)
	public String create(MemberDTO dto) throws Exception {
		 
		boolean flag = dao.create(dto);
		System.out.println("dto:" + dto.getPasswd());

		if (flag) {
			return "redirect:login";
		} else {
			return "error/error";
		}
	}

	@RequestMapping(value = "/member/id_proc")
	public String idCheck(String id, Model model) throws Exception {
		model.addAttribute("flag", dao.duplicateId(id));
		return "member/id_proc";
	}

	/*@RequestMapping(value = "/member/login_proc")
	public String login_proc(Model model, HttpServletRequest request, Memberdto dto) {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");

		Util_Security Util_Security = new Util_Security();
		String rtn1 = Util_Security.encryptSHA256(passwd);
		dto.setPasswd(rtn1);

		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("passwd", dto.getPasswd());

		boolean flag = dao.loginCheck(map);
		model.addAttribute("flag", flag);
		return "member/login_proc";
	}*/

	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model, MemberDTO dto) throws Exception {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		boolean flag = false;

		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("passwd", dto.getPasswd());

		flag = dao.loginCheck(map);
		String grade = null;// 회원등급
		if (flag) {// 회원인경우
			grade = dao.getGrade(id);
			request.getSession().setAttribute("id", id);
			request.getSession().setAttribute("grade", grade);

			// ----------------------------------------------
			// Cookie 저장, Checkbox는 선택하지 않으면 null 임
			// ----------------------------------------------
			Cookie cookie = null;
			String c_id = request.getParameter("c_id"); // Y, 아이디 저장 여부

			if (c_id != null) { // 처음에는 값이 없음으로 null 체크로 처리
				cookie = new Cookie("c_id", "Y"); // 아이디 저장 여부 쿠키
				cookie.setMaxAge(120); // 2 분 유지
				response.addCookie(cookie); // 쿠키 기록

				cookie = new Cookie("c_id_val", id); // 아이디 값 저장 쿠키
				cookie.setMaxAge(120); // 2 분 유지
				response.addCookie(cookie); // 쿠키 기록

			} else {
				cookie = new Cookie("c_id", ""); // 쿠키 삭제
				cookie.setMaxAge(0);
				response.addCookie(cookie);

				cookie = new Cookie("c_id_val", ""); // 쿠키 삭제
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			// ---------------------------------------------
		} else {
			return "member/login.tiles";
		}

		return "redirect:/";
	}

	@RequestMapping(value = "member/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		String c_id = ""; // ID 저장 여부를 저장하는 변수, Y
		String c_id_val = ""; // ID 값

		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;

		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];

				if (cookie.getName().equals("c_id")) {
					c_id = cookie.getValue(); // Y
				} else if (cookie.getName().equals("c_id_val")) {
					c_id_val = cookie.getValue(); // user1...
				}
			}
		}

		request.setAttribute("c_id", c_id);
		request.setAttribute("c_id_val", c_id_val);

		return "member/login.tiles";
	}

	@RequestMapping("member/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
