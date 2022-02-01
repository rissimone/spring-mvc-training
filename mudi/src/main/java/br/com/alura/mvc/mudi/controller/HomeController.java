package br.com.alura.mvc.mudi.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;

@Controller
public class HomeController {
	
	public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	ArrayList<Pedido> pedidos = new ArrayList<>();
	
	public Pedido pedido = new Pedido
	(
		"Egeo On Me Desodorante Colônia",
		200.99,
		LocalDate.parse("31/01/2022", formatter),
		"https://produto.mercadolivre.com.br/MLB-1236177494-egeo-on-me-desodorante-colnia-90ml-_JM?variation=174137082139#reco_item_pos=0&reco_backend=machinalis-seller-items-pdp&reco_backend_type=low_level&reco_client=vip-seller_items-above&reco_id=a4255494-7750-4172-9492-b506f152c34c",
		"É uma fragrância Floriental Frutal irreverente e traz combinações nunca antes pensadas por perfumistas. Nessa fragrância há uma mistura entre emoção e máquina – o olfato do homem e o cérebro do sistema.",
		"https://http2.mlstatic.com/D_NQ_NP_742410-MLB47847369825_102021-O.webp"
	);	
	
	@GetMapping("/home")
	public String Home(Model model) {			
		pedidos.add(pedido);
		model.addAttribute("pedidos", pedidos);		
		return "home";
	}
}
