package cn.edu.hqu.cst.javaee.performance.impl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import cn.edu.hqu.cst.javaee.performance.Show;

@Component
@Aspect
public class AdvertiseIntroducer {
	@DeclareParents(value="cn.edu.hqu.cst.javaee.performance.Performance+",defaultImpl=Advertise.class)
	public static Show show;

}
