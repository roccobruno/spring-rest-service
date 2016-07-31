package com.bruno.service.filejob;

import com.bruno.model.FilePagamentiFiltri;
import com.bruno.model.Pagamento;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by roccobruno on 31/07/2016.
 */
@Service
public class FileJobService {

    public FileJob creteJob(FilePagamentiFiltri pagamentiFiltri) {
        //save into db
       return new FileJob(UUID.randomUUID().toString(),Pagamento.class.toString(),pagamentiFiltri.toJson(), "in-progress");
    }

    public FileJob getById(String id) {
        //leggi dal db il record
        return new FileJob(id,Pagamento.class.toString(),"", "in-progress");

    }


}
