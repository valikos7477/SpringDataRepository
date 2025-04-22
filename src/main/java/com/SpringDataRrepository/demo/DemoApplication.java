package com.SpringDataRrepository.demo;

import com.SpringDataRrepository.Repositiry.UserCrudRepository;
import com.SpringDataRrepository.Repositiry.UserJpaRepository;
import com.SpringDataRrepository.Repositiry.UserPagingAndSortingRepository;
import com.SpringDataRrepository.demo.Entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.SpringDataRrepository.Repositiry")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserCrudRepository crudRepository,
						  UserJpaRepository jpaRepository,
						  UserPagingAndSortingRepository pagingAndSortingRepository) {
		return args -> {
			// Сохраняем тестовые данные
			crudRepository.save(new User(1L, "Вася"));
			crudRepository.save(new User(2L, "Петя"));
			crudRepository.save(new User(3L, "Маша"));

			// Проверка CrudRepository
			System.out.println("CrudRepository: Найден пользователь: " +
					crudRepository.findByName("Вася").getName());

			// Проверка JpaRepository
			System.out.println("JpaRepository: Все пользователи: " +
					jpaRepository.findAll());

			// Проверка PagingAndSortingRepository (пагинация и сортировка)
			Page<User> page = pagingAndSortingRepository.findAll(
					PageRequest.of(0, 2, Sort.by("name")));
			System.out.println("PagingAndSortingRepository: Первые 2 пользователя (сортировка по имени): " +
					page.getContent());
		};
	}
}
