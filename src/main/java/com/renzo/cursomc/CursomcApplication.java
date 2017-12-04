package com.renzo.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.renzo.cursomc.domain.Categoria;
import com.renzo.cursomc.domain.Cidade;
import com.renzo.cursomc.domain.Cliente;
import com.renzo.cursomc.domain.Endereco;
import com.renzo.cursomc.domain.Estado;
import com.renzo.cursomc.domain.Produto;
import com.renzo.cursomc.domain.enums.TipoCliente;
import com.renzo.cursomc.repositories.CategoriaRepository;
import com.renzo.cursomc.repositories.CidadeRepository;
import com.renzo.cursomc.repositories.ClienteRepository;
import com.renzo.cursomc.repositories.EnderecoRepository;
import com.renzo.cursomc.repositories.EstadoRepository;
import com.renzo.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
				
		categoriaRepository.save(Arrays.asList(cat1,cat2));
		produtoRepository.save(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Uberlândia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
		
		estadoRepository.save(Arrays.asList(est1,est2));
		cidadeRepository.save(Arrays.asList(cid1,cid2,cid3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva", "maria@gmail.com", "1243256700", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("32324343","99990102"));
		
		Endereco end1 = new Endereco(null, "Rua Flores", "300", "Apto 201", "Jardim", "38412058", cli1, cid1);
		Endereco end2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777000", cli1, cid2);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1,end2));
		
		clienteRepository.save(Arrays.asList(cli1));
		enderecoRepository.save(Arrays.asList(end1, end2));
	}
}
