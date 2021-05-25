package com.hunza.test.config;

import com.hunza.test.document.Caterer;
import com.hunza.test.repo.CatererRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoRepositories(basePackages = {
        "com.hunza.test.repo.*",
        "com.hunza.test.controller.*"
})
@Configuration
public class MongoDbConfig {

    @Bean
    CommandLineRunner commandLineRunner(CatererRepository userRepository) {

        return strings -> {
//            catererRepo.save(new Caterer("Saad", new Location("Hyderabad", "Gari Khata", "71000"),
//                    new Capacity(1, 10), new ContactInfo("0222783981", "03453538636", "saadkhan371@gmail.com")));
        };

    }

}

