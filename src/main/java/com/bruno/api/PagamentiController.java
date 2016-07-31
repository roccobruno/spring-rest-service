package com.bruno.api;


import com.bruno.model.FilePagamentiFiltri;
import com.bruno.model.Pagamento;
import com.bruno.service.PagamentoService;
import com.bruno.service.filejob.*;
import com.bruno.utils.FileResourceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/pagamenti")
public class PagamentiController {

    @Autowired
    private PagamentoService pagamentoService;

    @Value("${cartella.files.pagamenti}")
    private String fileLocation;

    @Autowired
    private FileJobProducer producer;

    @Autowired
    private FileJobPagamentiConsumer consumer;

    @Autowired
    private FileResourceUtil fileResourceUtil;


    @Autowired
    private FileJobService fileJobService;



    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Pagamento> getPagamenti() {
       return  pagamentoService.getPagamento();
    }


    @RequestMapping(value = "/file/job/{id}" ,method = RequestMethod.GET)
    public @ResponseBody
    FileJob getFileJob(@PathVariable("id") String fileId) {
        return  fileJobService.getById(fileId);
    }

    @RequestMapping(value = "/file/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<byte[]>
     getFile(HttpServletResponse resp, @PathVariable("id") String fileId) throws IOException {

        String directoryurl = fileLocation
                + "/";
        this.fileResourceUtil.download(
                "PAGAMENTI-"+fileId+".csv", resp, directoryurl);

        return  null;
    }



    @RequestMapping(value = "/file",method = RequestMethod.POST)
    public @ResponseBody
    FileJob generateFile(@RequestBody FilePagamentiFiltri paramsRicercaPagamenti) {

        FileJob fileJob = fileJobService.creteJob(paramsRicercaPagamenti);
        FileJobMessage message = new FileJobMessage(fileJob);

        consumer.startConsumer();
        producer.sendMessage(message);

        return fileJob;
    }





}
