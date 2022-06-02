package com.projeto.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.projeto.app.model.Cliente;
import com.projeto.app.repository.Clientes;

@SpringBootApplication
public class AppApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes){

		return args -> {

			Cliente cliente = new Cliente();
			cliente.setNome("Leandro");
			clientes.salvar(cliente);

			Cliente cliente1 = new Cliente();
			cliente1.setNome("Maria");
			clientes.salvar(cliente1);

			List<Cliente> todosClientes = clientes.obterTodos();

			todosClientes.forEach(System.out::println);

		};
	}
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
