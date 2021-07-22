package com.ict.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ict.service.MyService;
import com.ict.service.Paging;
import com.ict.vo.BVO;
import com.ict.vo.CVO;

@Controller
public class MyController {
	@Autowired
	private MyService myService;
	@Autowired
	private Paging paging;
	
	@RequestMapping("list.do")
	public ModelAndView getListCommand(@ModelAttribute("cPage")String cPage) {
		try {
			ModelAndView mv = new ModelAndView("list");
			// 전체 게시물의 수
			int count = myService.selectCount();
			paging.setTotalRecord(count);
			
			// 전체 페이지의 수
			if(paging.getTotalRecord() <= paging.getNumPerPage()) {
				paging.setTotalPage(1);
			}else {
				paging.setTotalPage(paging.getTotalRecord()/paging.getNumPerPage());
				// 나머지가 존재하면 전체 페이지수에서 1증가 
				if(paging.getTotalRecord()%paging.getNumPerPage() !=0) {
					paging.setTotalPage(paging.getTotalPage()+1);
				}
			}
			
			// 현재 페이지 구하기 
			paging.setNowPage(Integer.parseInt(cPage));
			
			// 시작번호, 끝번호 
			paging.setBegin((paging.getNowPage()-1) * paging.getNumPerPage() + 1);
			paging.setEnd((paging.getBegin()-1) + paging.getNumPerPage());
			
			// 시작블록, 끝블록
			paging.setBeginBlock((int)((paging.getNowPage()-1) / paging.getPagePerBlock()) * paging.getPagePerBlock() +1);
			paging.setEndBlock(paging.getBeginBlock() + paging.getPagePerBlock() - 1);
			
			// 주의사항 : endBlock 이 totalPage 보다 큰 경우 발생 할 수 있다.
			//            이 경우 endBlock를 totalPage에 맞춰야 한다.
			if(paging.getEndBlock() > paging.getTotalPage()) {
				paging.setEndBlock(paging.getTotalPage());
			}
			
			// 시작 번호와 끝번호를 이용해서 list를 구하자
			List<BVO> list = myService.selectBVOList(paging.getBegin(), paging.getEnd());
			
			mv.addObject("list", list);
			mv.addObject("pvo", paging);
			return mv;
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("error");
		}
	}
	@RequestMapping("write.do")
	public ModelAndView writeCommand(@ModelAttribute("cPage")String cPage) {
		return new ModelAndView("write");
	}
	
	@RequestMapping(value = "write_ok.do", method = RequestMethod.POST)
	public ModelAndView writeOkCommand(BVO bvo, HttpServletRequest request, 
			@ModelAttribute("cPage")String cPage) {
		try {
			String path = request.getSession().getServletContext().getRealPath("/resources/upload");
			MultipartFile file = bvo.getF_name();
			if(file.isEmpty()) {
				bvo.setFile_name("");
			}else {
				bvo.setFile_name(file.getOriginalFilename());
			}
			int result = myService.insertBVO(bvo);
			if(result>0) {
				if(! bvo.getFile_name().isEmpty()) {
					byte[] in = file.getBytes();
					File out = new File(path, bvo.getFile_name());
					FileCopyUtils.copy(in, out);
				}
				return new ModelAndView("redirect:list.do?cPage="+cPage);
			}else{
				return new ModelAndView("redirect:write.do?cPage="+cPage);
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("redirect:write.do?cPage="+cPage);
		}
	}
	
	@RequestMapping("onelist.do")
	public ModelAndView oneListCommand(@RequestParam("b_idx")String b_idx,
			@ModelAttribute("cPage")String cPage) {
		try {
			ModelAndView mv = new ModelAndView("onelist");
			
			// 조회수 업데이트 및 상세보기
			BVO bvo = myService.updateBVO_selectBVOOneList(b_idx);
			
			mv.addObject("bvo", bvo);
			return mv;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@RequestMapping(value = "clist.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<CVO> cListCommand(@RequestParam("b_idx")String b_idx){
		try {
			return myService.selectCVOList(b_idx);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@RequestMapping(value = "c_insert.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int c_insertCommand(CVO cvo){
		try {
			return myService.insertCVO(cvo);
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	@RequestMapping(value = "c_delete.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int c_deletCommand(@RequestParam("c_idx")String c_idx){
		try {
			return myService.deleteCVO(c_idx);
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	@RequestMapping("delete.do")
	public ModelAndView deleteCommand(@ModelAttribute("cPage")String cPage,
			@ModelAttribute("b_idx")String b_idx) {
		return new ModelAndView("delete");
	}
	
	@RequestMapping(value="pwd_ck.do", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String pwd_chkCommand(@ModelAttribute("pwd")String pwd,
			@ModelAttribute("b_idx")String b_idx){
		try {
			BVO bvo = new BVO();
			
			bvo.setB_idx(b_idx);
			bvo.setPwd(pwd);
		
			int result = myService.selectPwdchk(bvo);
			
			return String.valueOf(result);
		} catch (Exception e) {
			System.out.println(e);
			return null; 
		}
	}
	@RequestMapping("delete_ok.do")
	public ModelAndView deleteOKCommand(@ModelAttribute("cPage")String cPage,
			@ModelAttribute("b_idx")String b_idx) {
		try {
			int result1 = myService.deleteCVOComm_All(b_idx); 
			int result2 = myService.deleteBVO(b_idx);
			return new ModelAndView("redirect:list.do?cPage="+cPage);
		} catch (Exception e) {
		}
		return null;
	}
	@RequestMapping("update.do")
	public ModelAndView updateCommand(@ModelAttribute("cPage")String cPage,
			@ModelAttribute("b_idx")String b_idx) {
		try {
			ModelAndView mv = new ModelAndView("update");
			BVO bvo = myService.selectBVOOneList(b_idx);
			mv.addObject("bvo", bvo);
			return mv;
		} catch (Exception e) {
		}
		return null;
	}
	@RequestMapping(value = "update_ok.do", method = RequestMethod.POST)
	public ModelAndView updateokCommand(BVO bvo, @RequestParam("cPage")String cPage,
			HttpServletRequest request) {
		try {
			String path = request.getSession().getServletContext().getRealPath("/resources/upload");
			MultipartFile file = bvo.getF_name();
			String old_file_name = request.getParameter("old_file_name");
			if(old_file_name == null) { // 이전 파일이 없을 때 
				if(file.isEmpty()) {    // 현재 파일이 없을 때 
					bvo.setFile_name("");
				}else {
					bvo.setFile_name(file.getOriginalFilename());
				}
			}else {                   // 이전 파일이 있을 때 
				if(file.isEmpty()) {  // 현재 파일이 없을 때  
					bvo.setFile_name(old_file_name);
				}else {
					bvo.setFile_name(file.getOriginalFilename());
				}
			}
			int result = myService.updateBVO(bvo);
			if(! file.isEmpty()) {
				byte[] in = file.getBytes();
				File out = new File(path, bvo.getFile_name());
				FileCopyUtils.copy(in, out);
			}
			return new ModelAndView("redirect:onelist.do?b_idx="+bvo.getB_idx()+"&cPage="+cPage);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	@RequestMapping("download.do")
	public void downCommand(@RequestParam("file_name")String file_name,
			HttpServletRequest request, HttpServletResponse response) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			String path = request.getSession().getServletContext()
					.getRealPath("/resources/upload/"+file_name);
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition",
					"attachment; filename="+URLEncoder.encode(file_name,"utf-8"));
			File file = new File(new String(path.getBytes("utf-8")));
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(response.getOutputStream());
			
			FileCopyUtils.copy(bis, bos);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				bos.close();
				bis.close();
				fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}








