package sansam.team.major.query.service;

import org.springframework.stereotype.Service;
import sansam.team.major.query.dto.MajorQueryDTO;
import sansam.team.major.query.mapper.MajorQueryMapper;
import sansam.team.common.careernet.CareernetUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

@Service
public class MajorQueryService {

    private final MajorQueryMapper majorQueryMapper;
    private final CareernetUtil careernetUtil;

    public MajorQueryService(MajorQueryMapper majorQueryMapper, CareernetUtil careernetUtil) {
        this.majorQueryMapper = majorQueryMapper;
        this.careernetUtil = careernetUtil;
    }

    public MajorQueryDTO getMajorById(Long majorSeq) {
        return majorQueryMapper.findById(majorSeq);
    }

    public List<MajorQueryDTO> getAllMajors() {
        return majorQueryMapper.findAll();
    }

    public JSONArray getMajorInfoFromApi() throws Exception {
        return careernetUtil.getMajorInfo("universityName", "departmentName", "departmentCode");
    }

    public JSONObject getIntegratedMajorInfo() throws Exception {
        List<MajorQueryDTO> dbMajors = majorQueryMapper.findAll();
        JSONArray apiMajors = careernetUtil.getMajorInfo("universityName", "departmentName", "departmentCode");

        JSONObject result = new JSONObject();
        result.put("dbMajors", dbMajors);
        result.put("apiMajors", apiMajors);

        return result;
    }
}
