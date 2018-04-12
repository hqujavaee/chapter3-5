package cn.edu.hqu.cst.javaee;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.edu.hqu.cst.javaee.performance.Performance;
import cn.edu.hqu.cst.javaee.performance.PerformanceConfig;
import cn.edu.hqu.cst.javaee.performance.Show;

public class Chapter35Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(PerformanceConfig.class);
		Performance performance=(Performance) ctx.getBean(Performance.class);
		((Show)performance).show();
		performance.perform("黄金甲");
		ctx.close();
	}
}
