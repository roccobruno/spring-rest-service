package com.bruno.service.filejob;

import org.springframework.stereotype.Service;
import com.bruno.model.filter.Filter;
import com.bruno.model.bo.Pagamento;
import java.util.UUID;

@Service
public class FileJobService {

    public FileJob creteJob(Filter pagamentiFiltri) {
        //save into db if not already existing
       return new FileJob(UUID.randomUUID().toString(),Pagamento.class.toString(),pagamentiFiltri.toJson(), "in-progress");
    }

    public FileJob getById(String id) {
        //leggi dal db il record
        return new FileJob(id,Pagamento.class.toString(),"", "in-progress");

    }
}
