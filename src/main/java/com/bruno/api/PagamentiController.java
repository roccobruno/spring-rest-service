package com.bruno.api;


import com.bruno.model.Pagamento;
import com.bruno.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pagamenti")
public class PagamentiController {

    @Autowired
    private PagamentoService pagamentoService;



    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Pagamento> getPagamenti() {
       return  pagamentoService.getPagamento();
    }

}
