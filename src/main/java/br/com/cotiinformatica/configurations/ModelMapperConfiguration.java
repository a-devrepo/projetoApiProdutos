package br.com.cotiinformatica.configurations;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.cotiinformatica.dtos.ProdutoRequest;
import br.com.cotiinformatica.entities.Produto;

@Configuration
public class ModelMapperConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();

		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		mapper.typeMap(ProdutoRequest.class, Produto.class).addMappings(m -> {
			m.skip(Produto::setId);
			m.skip(Produto::setDataHoraCriacao);
		});

		return mapper;
	}
}
