package co.istad.forumproject.repository;

import com.fasterxml.uuid.Generators;

import org.kohsuke.randname.RandomNameGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.fasterxml.uuid.impl.TimeBasedGenerator;


@Component
public class Util {

    @Bean
    public String generateName() {
        RandomNameGenerator randomName = new RandomNameGenerator();
        return randomName.next();
    }

    @Bean
    public String generateUUID() {
        TimeBasedGenerator uuidGenerator = Generators.timeBasedGenerator();
        return uuidGenerator.generate().toString();
    }

}
