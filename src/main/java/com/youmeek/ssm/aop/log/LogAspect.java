package com.youmeek.ssm.aop.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * AOP的资料：
 * http://www.xdemo.org/springmvc-aop-annotation/
 * http://www.cnblogs.com/-bumblebee-/archive/2012/03/29/2423408.html
 * http://hotstrong.iteye.com/blog/1330046
 */
@Component
@Aspect
public class LogAspect {
	
	private static final Logger LOG = LoggerFactory.getLogger(LogAspect.class);
	private Long takeTime = 0L;
	private Long startTime = 0L;
	private Long endTime = 0L;
	
	//对 Controller 进行日志记录
	@Before("com.youmeek.ssm.aop.log.LogPointcut.inControllerLayer()")
	public void logBefore(JoinPoint joinPoint) {
		String className = joinPoint.getThis().toString();
		String methodName = joinPoint.getSignature().getName();//获得方法名
		startTime = System.currentTimeMillis();
		LOG.info("================== Controller 日志记录 start ===================");
		LOG.info("1.当前访问的类为：" + className);
		LOG.info("2.调用的方法开始：" + methodName);
		Object[] args = joinPoint.getArgs();//获得参数列表
		if (args.length <= 0) {
			LOG.info(methodName + " 方法没有参数");
		} else {
			LOG.info("--------- 遍历方法参数 start ---------");
			for (int i = 0; i < args.length; i++) {
				LOG.info("参数位数：" + (i + 1) + "，该参数值 = { " + args[i] + " }");
			}
			LOG.info("--------- 遍历方法参数 end ---------");
		}
	}
	
	@After("com.youmeek.ssm.aop.log.LogPointcut.inControllerLayer()")
	public void logAfter() {
		endTime = System.currentTimeMillis();
		takeTime = endTime - startTime;
		LOG.info("3.共花费时间：" + takeTime + " 毫秒");
		Long seconds = takeTime / 1000;
		if (seconds > 10) {
			LOG.info("严重注意：该方法可能存在严重性能问题");
		} else if (seconds > 5) {
			LOG.info("注意：该方法可能存在一般性能问题");
		}
		LOG.info("================== Controller 日志记录 End ===================");
		
	}
	
}
