package br.com.alura.mvc.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/oferta")
public class OfertaRest {

	@Autowired
	private PedidoRepository pedidoRepository; 

	@GetMapping("/oferta")
	public List<Pedido> getFormularioParaOfertas() {
		
		Sort sort = Sort.by("id").descending();
		PageRequest pagina = PageRequest.of(0, 10, sort);		
		List<Pedido> pedidosAguardandoOfertas = pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, pagina);
		
		return pedidosAguardandoOfertas;
	}
}
