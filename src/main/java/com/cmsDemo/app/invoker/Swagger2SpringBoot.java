package com.cmsDemo.app.invoker;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.cmsDemo.app.repository.SectionRepository;
import com.cmsDemo.app.repository.StudentRepository;
import com.cmsDemo.app.repository.TeacherRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "com.cmsDemo.app" })
@EnableMongoRepositories(basePackageClasses = { StudentRepository.class, TeacherRepository.class, SectionRepository.class} )
public class Swagger2SpringBoot implements CommandLineRunner {
	
    @Override
	public void run(String... args) throws Exception {
        if (args.length > 0 && args[0].equals("exitcode")) {
            throw new ExitException();
        }
        
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(Swagger2SpringBoot.class).run(args);
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
