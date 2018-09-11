package com.avdev.utchipster.web.rest;

import com.avdev.utchipster.domain.MyData;
import com.avdev.utchipster.repository.MyDataRepository;
import com.avdev.utchipster.service.dto.MyDataDTO;
import com.avdev.utchipster.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.Collection;

@RestController
@RequestMapping("/api")
public class MyDataResource {

    private final Logger log = LoggerFactory.getLogger(MyDataResource.class);

    private final MyDataRepository myDataRepository;

    public MyDataResource(MyDataRepository userRepository) {
        this.myDataRepository = userRepository;
    }

    @PostMapping("/myData")
    public ResponseEntity<MyData> createMyData(@Valid @RequestBody MyDataDTO myDataDTO) throws URISyntaxException {
        log.debug("REST request to save MyData : {}", myDataDTO);
        MyData myData = new MyData();
        myData.setName(myDataDTO.getName());
        myData.setDateTime(Instant.now());

        myDataRepository.save(myData);

        return ResponseEntity.created(new URI("/api/mydata/" + myData.getId()))
            .headers(HeaderUtil.createAlert("myData.created", String.valueOf(myData.getId())))
            .body(myData);
    }

    @GetMapping("/myData")
    public ResponseEntity<Collection<MyData>> getAllMyData() {
        log.debug("REST request to get all MyData");

        return ResponseEntity.ok(myDataRepository.findAll());
    }
}
