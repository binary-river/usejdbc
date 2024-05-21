package com.hellogroup.usejdbc;

import com.hellogroup.usejdbc.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class UsejdbcApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UsejdbcApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UsejdbcApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		log.info("Creating tables");

		jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE customers ("
			+ "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

		List<Object[]> splitUpNames = Arrays.asList("John Doe", "John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
				.map(name -> name.split(" "))
				.collect(Collectors.toList());

		splitUpNames.stream().forEach(name -> log.info(String.format("inserting customer record for %s %s", name[0], name[1])));

		jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) values(?,?)", splitUpNames);

		log.info("Querying for customer records where first name is Jeff : ");
		jdbcTemplate.query("SELECT id, first_name, last_name, FROM customers WHERE first_name = ?",
							(rs,rowNum) -> new Customer( rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")), "Jeff"
						).forEach(customer -> log.info(customer.toString()));


	}
}
