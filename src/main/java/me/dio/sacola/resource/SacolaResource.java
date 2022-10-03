package me.dio.sacola.resource;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import me.dio.sacola.model.Item;
import me.dio.sacola.model.Sacola;
import me.dio.sacola.resource.dto.ItemDto;
import me.dio.sacola.service.SacolaService;
import org.springframework.web.bind.annotation.*;

@Api(value="/ifood-devweek/sacolas")
@RestController // Indica que esta classe vai conter os endpoints
@RequestMapping("/ifood-devweek/sacolas")
@RequiredArgsConstructor // Para criar um construtor que retorna uma SacolaResource e tem como parâmetro uma SacolaService, pois o final obriga que seja feito um construtor
public class SacolaResource {

    private final SacolaService sacolaService;

    @PostMapping                    // O @RequestBody indica que o itemDio vai vim do corpo da requisição
    public Item incluirItemNaSacola(@RequestBody ItemDto itemDto){
        return sacolaService.incluirItemNaSacola(itemDto);
    }

    @GetMapping("/{id}")
    public Sacola verSacola(@PathVariable("id") Long id){
        return sacolaService.verSacola(id);
    }

    @PatchMapping("/fecharSacola/{idSacola}")  //Patch é um método HTTP para atualizar dados do banco de dados, parecido com o PUT
    public Sacola fecharSacola(@PathVariable("idSacola") Long idSacola,
                               @RequestParam("formaPagamento") int formaPagamento){
        return sacolaService.fecharSacola(idSacola, formaPagamento);
    }
}
