package com.example.demo;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.UUID;

@EnableWebMvc
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public class StringToUUIDConverter implements Converter<String, UUID> {
		public UUID convert(String source) {
			return UUID.fromString(source);
		}

		@Override
		public JavaType getInputType(TypeFactory typeFactory) {
			return null;
		}

		@Override
		public JavaType getOutputType(TypeFactory typeFactory) {
			return null;
		}
	}

}
