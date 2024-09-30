package sansam.team.major.query.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.major.query.dto.MajorQueryDTO;
import sansam.team.major.query.service.MajorQueryService;
import sansam.team.common.response.ResponseUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

@RestController
@RequestMapping("/majors")
public class MajorQueryController {

    private final MajorQueryService majorQueryService;

    public MajorQueryController(MajorQueryService majorQueryService) {
        this.majorQueryService = majorQueryService;
    }

    @GetMapping("/{majorSeq}")
    public ResponseEntity<?> getMajorById(@PathVariable Long majorSeq) {
        MajorQueryDTO major = majorQueryService.getMajorById(majorSeq);
        return ResponseUtil.successResponse(major);
    }

    @GetMapping
    public ResponseEntity<?> getAllMajors() {
        List<MajorQueryDTO> majors = majorQueryService.getAllMajors();
        return ResponseUtil.successResponse(majors);
    }

    // 외부 API에서 전공 데이터 조회
    @GetMapping("/api")
    public ResponseEntity<?> getMajorsFromApi() throws Exception {
        JSONArray apiMajors = majorQueryService.getMajorInfoFromApi();
        return ResponseUtil.successResponse(apiMajors);
    }

    // 외부 API와 DB 데이터를 통합하여 조회
    @GetMapping("/integrated")
    public ResponseEntity<?> getIntegratedMajorInfo() throws Exception {
        JSONObject integratedMajors = majorQueryService.getIntegratedMajorInfo();
        return ResponseUtil.successResponse(integratedMajors);
    }
}
