package com.projeto.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.app.model.Cliente;

@Repository
public class Clientes {
    
    private static String INSERT = "INSERT INTO cliente (nome) values(?) ";
    private static String SELECT_ALL = "SELECT * FROM cliente";
    private static String UPDATE = "UPDATE cliente set nome = ? WHERE id = ? ";
    private static String DELETE = "DELETE FROM cliente WHERE id = ?";
    private static String SELECT_POR_NOME = "SELECT * from cliente WHERE LIKE = ?";
   
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Cliente salvar(Cliente cliente){

       entityManager.persist(cliente);

        return cliente;
    }

    public Cliente atualizar(Cliente cliente){

        jdbcTemplate.update(UPDATE, new Object[]{cliente.getNome(),cliente.getId()});
        return cliente;
    }

    public void deletar(Cliente cliente){

        deletar(cliente.getId());
    }

    public void deletar(Long id){
        jdbcTemplate.update(DELETE, new Object[]{id});

    }

    public List<Cliente> buscarPorNome(String nome){

        return jdbcTemplate.query(SELECT_POR_NOME, new Object[]{"%"+nome+"%"} ,obterClienteMapper());
    }
    public List<Cliente> obterTodos(){

        return jdbcTemplate.query(SELECT_ALL,obterClienteMapper());
    }

    public RowMapper<Cliente> obterClienteMapper(){

        return new RowMapper<Cliente>() {
            
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException{

                return new Cliente(resultSet.getLong("id") ,resultSet.getString("nome"));
            }
        };
    }
}
