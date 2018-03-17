package br.com.danieldias.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
@Controller
@RequestMapping("*")
public class IndexController {

	@RequestMapping("*")
	public String index() {
		return "redirect:/pessoas/listaPessoa";
	}
}