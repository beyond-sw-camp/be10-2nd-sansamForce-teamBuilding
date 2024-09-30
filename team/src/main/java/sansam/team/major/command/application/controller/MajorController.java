package sansam.team.major.command.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.major.command.application.dto.MajorDTO;
import sansam.team.major.command.application.service.MajorService;

@RestController
@RequestMapping("/majors")
public class MajorController {

    private final MajorService majorService;

    public MajorController(MajorService majorService) {
        this.majorService = majorService;
    }

    @PostMapping
    public ResponseEntity<Void> createMajor(@RequestBody MajorDTO dto) {
        majorService.createMajor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{majorSeq}")
    public ResponseEntity<Void> updateMajor(@PathVariable Long majorSeq, @RequestBody MajorDTO dto) {
        majorService.updateMajor(majorSeq, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{majorSeq}")
    public ResponseEntity<Void> deleteMajor(@PathVariable Long majorSeq) {
        majorService.deleteMajor(majorSeq);
        return ResponseEntity.noContent().build();
    }
}
