package sbi.oneshot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sbi.oneshot.entities.Go;
import sbi.oneshot.repositories.GoRepository;

import java.util.List;

@SpringBootApplication
public class OneshotApplication  {



    public static void main(String[] args) {
        SpringApplication.run(OneshotApplication.class, args);
    }





    }
