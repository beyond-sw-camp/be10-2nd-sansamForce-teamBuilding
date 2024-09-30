package sansam.team.major.command.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.common.response.ResponseUtil;
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
    public ResponseEntity<?> createMajor(@RequestBody MajorDTO dto) {
        try {
            majorService.createMajor(dto);
            return ResponseUtil.successResponse("Major created successfully", null);
        } catch (Exception e) {
            return ResponseUtil.exceptionResponse(e, "MAJOR_CREATE_ERROR");
        }
    }

    @PutMapping("/{majorSeq}")
    public ResponseEntity<?> updateMajor(@PathVariable Long majorSeq, @RequestBody MajorDTO dto) {
        try {
            majorService.updateMajor(majorSeq, dto);
            return ResponseUtil.successResponse("Major updated successfully", null);
        } catch (Exception e) {
            return ResponseUtil.exceptionResponse(e, "MAJOR_UPDATE_ERROR");
        }
    }

    @DeleteMapping("/{majorSeq}")
    public ResponseEntity<?> deleteMajor(@PathVariable Long majorSeq) {
        try {
            majorService.deleteMajor(majorSeq);
            return ResponseUtil.successResponse("Major deleted successfully", null);
        } catch (Exception e) {
            return ResponseUtil.exceptionResponse(e, "MAJOR_DELETE_ERROR");
        }
    }
}
