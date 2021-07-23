package com.homegym.controller.homegym;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.homegym.biz.homegym.Criteria;
import com.homegym.biz.homegym.HomegymDetailService;
import com.homegym.biz.homegym.HomegymDetailVO;
import com.homegym.security.CustomUserDetails;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/details/")
public class HomegymDetailController {
	
	@Autowired
	HomegymDetailService service;
	
	// 예약 페이지 보여주기(GET)
	@RequestMapping("/reservationView.do")
	public String reservationView(Model model, @ModelAttribute("cri") Criteria cri,
			@ModelAttribute("hId") int hId) {
		
		log.info("예약하기: " + model);
		
		// 주소 가져오기
		model.addAttribute("address", service.getAddr(hId));
		
		// 예약된 내역 가져오기
		model.addAttribute("reservation", service.getReservationList(hId));
		
		return "/homegym/hg_reservation";
	}
	
	// 홈짐 예약 신청시 동작(POST)
	@RequestMapping("/reservation.do")
	public String reservation(HomegymDetailVO vo, Criteria cri) {

		service.register(vo);
		return "redirect: /homegym/homegymDetailView.do" + cri.getListLink() + "&hId=" + vo.getHId();
	}
}
