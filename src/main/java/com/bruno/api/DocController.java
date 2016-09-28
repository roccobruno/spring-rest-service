package com.bruno.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class DocController {
	
	private static final Logger log = LoggerFactory.getLogger(DocController.class);
	
	@RequestMapping(value = "/api-docs")
	public ModelAndView doc(ModelAndView model) throws Exception {
		log.info("Start DocController.doc method");		
		
		model.setViewName("swagger-ui.html");
		return model;
	}

}
