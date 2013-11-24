package org.register.listener;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;
/*
@Component
public class ApplicationListenerBean implements ApplicationListener<ContextStartedEvent>{

	public void onApplicationEvent(ContextStartedEvent event) {
		System.out.println("ARRANCANDOO:::::::::::::::::");
		
	}



 public class ApplicationListenerBean implements ApplicationListener<ContextStoppedEvent>{

	public void onApplicationEvent(ContextStoppedEvent event) {
		System.out.println("DETENIDOOOOOOOOOOOOOOOOOOOOOOO:::::::::::::::::");
		
	}

	
	

}

 */