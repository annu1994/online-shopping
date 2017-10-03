package com.project.onlineshopping.globalExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView NoHandlerFoundException() {
		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "This Page is not Contructed!");
		mv.addObject("errorDescription", "The page you are looking for is not available now..");
		mv.addObject("title", "404 Error page");

		return mv;

	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView HandlerNoProductFoundException() {
		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "Product not available !");
		mv.addObject("errorDescription", "The Product you are looking for is not available right now..");
		mv.addObject("title", "Product unavailable");

		return mv;

	}
	@ExceptionHandler(Exception.class)
	public ModelAndView HandlerException(Exception ex) {
		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "Contact Your Administrator !");
		/*only For Debuging our Application*/
		StringWriter stringWriter=new StringWriter();
		PrintWriter printWriter=new PrintWriter(stringWriter);
		ex.printStackTrace(printWriter);
		
		mv.addObject("errorDescription", stringWriter.toString());
		mv.addObject("title", "Error");

		return mv;

	}

}
