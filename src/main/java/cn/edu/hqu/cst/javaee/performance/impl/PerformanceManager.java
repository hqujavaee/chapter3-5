package cn.edu.hqu.cst.javaee.performance.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class PerformanceManager {
	@Pointcut("execution(** cn.edu.hqu.cst.javaee.performance.Performance.perform(String))"+
     "&& args(title)")
	public void perform(String title) {
		
	}
	@Before("perform(title)")
	public void silenceCellPhones(String title) {
		System.out.println("电影《"+title+"》即将开始，请将手机调为静音！");
	}
	
	@Before("perform(title)")
	public void takeSeats(String title) {
		System.out.println("请坐在自己位置上，不要到处走动");
	}
	@AfterReturning("perform(title)")
	public void orderlyRetreat(String title) {
		System.out.println("电影《"+title+"》播放完毕，请大家有序退场");
	}
	@AfterThrowing("perform(title)")
	public void refound(String title) {
		System.out.println("到售票处退票");
	}
	@Around("perform(title)")
	public void checkSecurity(ProceedingJoinPoint jp,String title) {
		try {
			System.out.println("电影《"+title+"》表演前安全检查");
			jp.proceed();
			System.out.println("电影《"+title+"》表演后安全检查");
		}catch(Throwable e){
			System.out.println("《"+title+"》播放出现问题");
		}
		
	}
	
}
