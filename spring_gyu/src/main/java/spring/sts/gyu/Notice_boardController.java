package spring.sts.gyu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.model.notice_board.Notice_boardDAO;
import spring.model.notice_board.Notice_boardDTO;
import spring.sts.utility.Utility;

@Controller
public class Notice_boardController {

	@Autowired
	private Notice_boardDAO dao;
	
	@RequestMapping("/notice/fileDel")
	public ModelAndView fileDel(String oldFile,String noticeno) throws Exception {
		ModelAndView mav = new ModelAndView();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("oldFile", oldFile);
		map.put("noticeno", noticeno);
		//boolean flag = dao.fileDel(map);
		mav.addObject("result", true);
		mav.setViewName("notice_board/update.tilse");
		return mav;
	}
	@RequestMapping(value="/notice/delete",method=RequestMethod.GET)
	public ModelAndView delete(int noticeno,String oldFile,HttpServletRequest request) throws Exception {
		String upDir = request.getRealPath("/notice_board/storage"); 
		ModelAndView mav = new ModelAndView();
		boolean flag = dao.delete(noticeno);
		if(flag) {
			Utility.deleteFile(upDir, oldFile);
			mav.setViewName("redirect:/notice_board/list");
		}else {
			mav.setViewName("error");
		}
		return mav;
	}
	@RequestMapping(value="/notice/update",method=RequestMethod.POST)
	public ModelAndView update(Notice_boardDTO dto,int nowPage,String col,String word) throws Exception {
		ModelAndView mav = new ModelAndView();
		boolean flag = dao.update(dto);
		if(flag){
			mav.addObject("nowPage", nowPage);
			mav.addObject("col", col);
			mav.addObject("word", word);
			mav.setViewName("redirect:/notice/list");
		}else {
			mav.setViewName("error");
		}
		return mav;
	}
	@RequestMapping(value="/notice/update",method=RequestMethod.GET)
	public ModelAndView update(int nowPage,String col,String word,int noticeno) throws Exception {
		ModelAndView mav = new ModelAndView();
		Notice_boardDTO dto = (Notice_boardDTO)dao.read(noticeno);
		
		mav.addObject("dto", dto);
		mav.addObject("nowPage", nowPage);
		mav.addObject("col", col);
		mav.addObject("word", word);
		mav.setViewName("notice_board/update.tiles");
		
		return mav;
	}
	@RequestMapping("/notice/list")
	public ModelAndView list(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		String col = Utility.checkNull(request.getParameter("col"));
		String word = Utility.checkNull(request.getParameter("word"));
		
		int nowPage = 1;
		if(request.getParameter("nowPage") != null) {
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		int recordPerPage = 5;
		int sno = ((nowPage-1)* recordPerPage) + 1;
		int eno = nowPage * recordPerPage;
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("col", col);
		map.put("word",word);
		map.put("sno",sno);
		map.put("eno",eno);
		
		List<Notice_boardDTO> list = dao.list(map);
		int total = dao.total(map);
		String paging = Utility.pagingHY("list", total, nowPage, recordPerPage, col, word);
		mav.addObject("paging", paging);
		mav.addObject("list", list);
		mav.addObject("nowPage", nowPage);
		mav.addObject("col", col);
		mav.addObject("word", word);
		mav.setViewName("notice_board/list.tiles");
		
		return mav;
	}
	@RequestMapping(value="/notice/read",method=RequestMethod.GET)
	public ModelAndView read(int noticeno,String col,String word,int nowPage) throws Exception {
		ModelAndView mav = new ModelAndView();
		dao.upViewcnt(noticeno);
		Notice_boardDTO dto = (Notice_boardDTO)dao.read(noticeno);
		
		mav.addObject("dto", dto);
		mav.addObject("nowPage", nowPage);
		mav.addObject("col", col);
		mav.addObject("word", word);
		mav.setViewName("notice_board/read.tiles");
		
		return mav;
	}
	
	@RequestMapping(value="/notice/create",method=RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notice_board/create.tiles");
		
		return mav;
	}
	
	@RequestMapping(value="/notice/create",method=RequestMethod.POST)
	public ModelAndView create(Notice_boardDTO dto,HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		String upDir = request.getRealPath("/notice_board/storage");
		String fname = "";
		for(int i=0; i<dto.getMultipartFiles().size(); i++) {
			int filesize = (int)dto.getMultipartFiles().get(i).getSize();
			if(filesize > 0) {
				fname = fname + Utility.saveFileSpring30(dto.getMultipartFiles().get(i), upDir);
				fname = fname + " ";
				
			}else {
				dto.setFname(" ");
			}
		}
		dto.setFname(fname);
		
		boolean flag = dao.create(dto);
		if(flag) {
			mav.setViewName("redirect:/notice/list");
		}else {
			Utility.deleteFile(upDir, dto.getFname());
			mav.setViewName("error");
		}
		return mav;
	}
}
