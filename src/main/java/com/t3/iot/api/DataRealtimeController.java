package com.t3.iot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data-realtime")
public class DataRealtimeController {
    DataRealltimeRepository dataRealltimeRepository;

    @Autowired
    public DataRealtimeController(DataRealltimeRepository dataRealltimeRepository) {
        this.dataRealltimeRepository = dataRealltimeRepository;
    }

    @GetMapping
    public ResponseEntity<List<DataRealtime>> getAll() {
        return ResponseEntity.ok(this.dataRealltimeRepository.findAll());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody DataRealtime dataRealtime) {
        this.dataRealltimeRepository.save(dataRealtime);
        return ResponseEntity.ok().build();
    }
}
