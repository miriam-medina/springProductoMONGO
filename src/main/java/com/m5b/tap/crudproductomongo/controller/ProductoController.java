package com.m5b.tap.crudproductomongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.m5b.tap.crudproductomongo.model.ProductoDTO;
import com.m5b.tap.crudproductomongo.repository.IProductoDAO;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("/api/productos")
public class ProductoController {

	@Autowired
	private IProductoDAO repository;

	@PostMapping("/producto")
	public ProductoDTO create(@Validated @RequestBody ProductoDTO p) {
		return repository.insert(p);
	}

	@GetMapping("/")
	public List<ProductoDTO> readAll() {
		return repository.findAll();
	}

	@PutMapping("/producto/{id}")
	public ProductoDTO update(@PathVariable String id, @Validated @RequestBody ProductoDTO p) {
		return repository.save(p);
	}

	@DeleteMapping("/producto/{id}")
	public void delete(@PathVariable String id) {
		repository.deleteById(id);
	}
	
}