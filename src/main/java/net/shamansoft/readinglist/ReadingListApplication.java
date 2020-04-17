package net.shamansoft.readinglist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReadingListApplication implements ApplicationRunner {

	private static final Logger log = LoggerFactory.getLogger(ReadingListApplication.class);
	private final HelloService helloService;

	public ReadingListApplication(HelloService helloService){
		this.helloService = helloService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ReadingListApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
//		log.info("*nonargs");
//		args.getNonOptionArgs().forEach(log::info);
//		log.info("*names");
//		args.getOptionNames().forEach(log::info);
//		log.info("*vals");
//		args.getOptionNames().forEach(option -> log.info(String.format("%s = %s", option, args.getOptionValues(option).toString())));

		log.info(helloService.sayHello(args.getOptionValues("name")));

	}
}
