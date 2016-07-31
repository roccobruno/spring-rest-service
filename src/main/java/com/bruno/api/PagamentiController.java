package com.bruno.api;


import com.bruno.model.FilePagamentiFiltri;
import com.bruno.model.Pagamento;
import com.bruno.service.PagamentoService;
import com.bruno.service.filejob.*;
import com.bruno.utils.FileResourceLoader;
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
    private FileResourceLoader fileResourceLoader;


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
        this.fileResourceLoader.download(
                "PAGAMENTI-43de446e-52b8-43ab-b368-e64c19f721ac.csv", resp, directoryurl);

        return  null;
    }



    @RequestMapping(value = "/file",method = RequestMethod.POST)
    public @ResponseBody
    FileJob generateFile(@RequestBody FilePagamentiFiltri pagamenti) {

        FileJob fileJob = fileJobService.creteJob(pagamenti);
        FileJobMessage message = new FileJobMessage(fileJob);

        consumer.startConsumer();
        producer.sendMessage(message);

        return fileJob;
    }





}
