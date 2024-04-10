package index.style.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import index.style.models.producto;
import index.style.repositories.productoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class productoController {

    @Autowired
    private productoRepository prod;

    @GetMapping("")
    public String inicio() {
        return "Conectado";
    }

    @PostMapping("crearproducto")
    public String crearproducto(@RequestBody producto p) {
        prod.save(p);
        return "Producto Guardado";
    }

    @GetMapping("productos")
    public List<producto> veProductos() {
        return prod.findAll();
    }

    @PutMapping("editar/{id}")
    public String editproducto(@PathVariable Integer id, @RequestBody producto p) {
        producto actualizaProducto = prod.findById(id).get();
        actualizaProducto.setCategoria(p.getCategoria());
        actualizaProducto.setColor(p.getColor());
        actualizaProducto.setTalla(p.getTalla());
        actualizaProducto.setMarca(p.getMarca());
        actualizaProducto.setPrecio(p.getPrecio());
        prod.save(actualizaProducto);
        return "Producto Actualizado";
    }

    @DeleteMapping("borrar/{id}")
    public String borrarprod(@PathVariable Integer id) {
        producto borrapProducto = prod.findById(id).get();
        prod.delete(borrapProducto);
        return "Producto Eliminado";

    }

}
