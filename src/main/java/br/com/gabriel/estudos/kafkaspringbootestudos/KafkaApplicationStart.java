package br.com.gabriel.estudos.kafkaspringbootestudos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaApplicationStart {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplicationStart.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){
        return args -> {for (int i =0; i <= 100; i++){
            kafkaTemplate.send("ordertopic", "Hello World from OrderTopicBuilder. Numbers off 'hello': "+i);
        }
        };

    }

}
