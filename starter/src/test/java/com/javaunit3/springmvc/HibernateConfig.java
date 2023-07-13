package com.javaunit3.springmvc;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {
    SessionFactory factory = new org.hibernate.cfg.Configuration()
            .configure("hiberate.cfg.xml")
            .addAnnotatedClass(MovieEntity.class)
            .buildSessionFactory();

}
