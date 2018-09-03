package sbi.oneshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sbi.oneshot.service.AccountService;


@SpringBootApplication

public class OneshotApplication implements CommandLineRunner {


    @Autowired
    private AccountService accountService;


    public static void main(String[] args) {
        SpringApplication.run(OneshotApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
