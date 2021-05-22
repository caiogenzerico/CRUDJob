package br.com.crudjob.empresa;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class EmpresaController {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@GetMapping("/empresas")
	public List<EmpresaEntity> retornaTodasEmpresas(){
		return  empresaRepository.findAll();
	}
	
	@GetMapping("/empresas/{id}")
	public EmpresaEntity retornarEmpresa(@PathVariable long id) {
		Optional<EmpresaEntity> empresa = empresaRepository.findById(id);

		if (!empresa.isPresent())
			throw new EmpresaNotFoundException("id-" + id);

		return empresa.get();
	}

	@DeleteMapping("/empresas/{id}")
	public void excluirEmpresa(@PathVariable long id) {
		empresaRepository.deleteById(id);
	}

	@PostMapping("/empresas")
	public ResponseEntity<Object> criarEmpresa(@RequestBody EmpresaEntity empresa) {
		EmpresaEntity empresaSalva = empresaRepository.save(empresa);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(empresaSalva.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/empresas/{id}")
	public ResponseEntity<Object> atualizarEmpresa(@RequestBody EmpresaEntity empresa, @PathVariable long id) {

		Optional<EmpresaEntity> empresaOptional = empresaRepository.findById(id);

		if (!empresaOptional.isPresent())
			return ResponseEntity.notFound().build();

		empresa.setId(id);
		
		empresaRepository.save(empresa);

		return ResponseEntity.noContent().build();
	}
}
