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

/**
 * Handles requests for the application home page.
 */
@Controller

public class MemberController {

	@Autowired
	private MemberDAO dao;

	@RequestMapping("/member/list")
	public String list(HttpServletRequest request) {
		/*String col = Utility.checkNull(request.getParameter("col")); // null인 경우도 허용하는 메소드
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
		request.setAttribute("nowPage", nowPage);*/
		Map map = new HashMap();
		map.put("col", "");
		map.put("word", "");
		map.put("sno", 1);
		map.put("eno", 3);
		List<MemberDTO> list = dao.list(map);
		request.setAttribute("list", list);
		
		
		return "member/list.tiles";
	}
	
	/*@RequestMapping(value = "/member/agreement", method = RequestMethod.GET)
	public String agreement() {

		return "member/agreement.tiles";
	}

	@RequestMapping(value = "/member/create", method = RequestMethod.GET)
	public String create() {

		return "member/create.tiles";
	}

	@RequestMapping(value = "/member/create", method = RequestMethod.POST)
	public String create(MemberVO vo) {

		boolean flag = false;
		SecurityUtil securityUtil = new SecurityUtil();
		String rtn1 = securityUtil.encryptSHA256(vo.getPasswd());
		vo.setPasswd(rtn1);

		// 회원가입시 비밀번호를 SHA-256 으로 SALT 이용해 암호화 하기
		
		 * String salt = SHA256Util.generateSalt(); String newPassword =
		 * SHA256Util.getEncrypt(vo.getPasswd(), salt); vo.setPasswd(newPassword);
		 * vo.setSalt(salt);
		 

		flag = dao.create(vo);
		System.out.println("vo:" + vo.getPasswd());

		if (flag) {
			return "redirect:login";
		} else {
			return "error/error";
		}
	}

	@RequestMapping(value = "/member/id_proc")
	public String idCheck(String id, Model model) {
		model.addAttribute("flag", dao.duplicateId(id));
		return "member/id_proc";
	}

	@RequestMapping(value = "/member/email_proc")
	public String emailCheck(String email, Model model) {
		model.addAttribute("flag", dao.duplicateEmail(email));
		return "member/email_proc";
	}

	@RequestMapping(value = "/member/login_proc")
	public String login_proc(Model model, HttpServletRequest request, MemberVO vo) {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");

		SecurityUtil securityUtil = new SecurityUtil();
		String rtn1 = securityUtil.encryptSHA256(passwd);
		vo.setPasswd(rtn1);

		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("passwd", vo.getPasswd());

		boolean flag = dao.loginCheck(map);
		model.addAttribute("flag", flag);
		return "member/login_proc";
	}

	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model, MemberVO vo) {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		boolean flag = false;

		SecurityUtil securityUtil = new SecurityUtil();
		String rtn1 = securityUtil.encryptSHA256(passwd);
		vo.setPasswd(rtn1);

		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("passwd", vo.getPasswd());

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
	}*/

}
