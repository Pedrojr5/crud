package index.style.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import index.style.models.categoria;
import index.style.repositories.categoriaRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class categoriaController {

    @Autowired
    public categoriaRepository cat;

    @GetMapping("categoria")
    public String categoria() {
        return "Conectado";
    }

    @PostMapping("agcategoria")
    public String newcategoria(@RequestBody categoria c) {
        cat.save(c);

        return "Categoria guardada";
    }

    @PostMapping("crearcategoria")
    public ResponseEntity<Object> creacategoria(@RequestBody categoria c) {
        Optional<categoria> res = cat.findByNomcat(c.getNomcat());
        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("error", "true");
            datos.put("mensaje", "El nombre de categoria pertenece a otra categoria");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }
        cat.save(c);
        datos.put("data", c);
        datos.put("mensaje", "categoria creada");
        return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
    }

    @GetMapping("categorias")
    public List<categoria> getCalzados() {
        return cat.findAll();
    }

    @PutMapping("editarcategoria/{id}")
    public String editarcategoria(@PathVariable Integer id, @RequestBody categoria c) {
        categoria actualizaCategoria = cat.findById(id).get();
        actualizaCategoria.setNomcat(c.getNomcat());
        cat.save(actualizaCategoria);
        return "Categoria Actualizada";
    }

    @DeleteMapping("borrarcategoria/{id}")
    public String borrarcat(@PathVariable Integer id) {
        categoria borraCategoria = cat.findById(id).get();
        cat.delete(borraCategoria);
        return "Categoria Eliminada";

    }

}
