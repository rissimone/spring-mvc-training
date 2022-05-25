package br.com.alura.mvc.mudi.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mvc.mudi.model.Oferta;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/oferta")
public class OfertaRest {

	@Autowired
	private PedidoRepository pedidoRepository; 

	@PostMapping("/oferta")
	public Oferta criaOfertas(RequisicaoNovaOferta requisicao) {
		
		Optional<Pedido> idPedidoRequisicao = pedidoRepository.findById(requisicao.pedidoId);
		
		if(!idPedidoRequisicao.isPresent()) {
			return null;
		}
		
		Pedido pedido = idPedidoRequisicao.get();		
		Oferta nova = requisicao.toOferta();
		
		nova.setPedido(pedido);
		pedido.getOfertas().add(nova);
		
		pedidoRepository.save(pedido);
				
		return nova;
	}
}
