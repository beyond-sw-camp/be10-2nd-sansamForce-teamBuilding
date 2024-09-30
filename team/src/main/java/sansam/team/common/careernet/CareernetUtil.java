package sansam.team.common.careernet;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sansam.team.config.CareernetConfig;
import org.json.JSONObject;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class CareernetUtil {
    private static final String API_URL = "http://www.career.go.kr/cnet/openapi/getOpenApi.json";

    @Autowired
    private final CareernetConfig careernetConfig;

    public CareernetUtil(CareernetConfig careernetConfig) {
        this.careernetConfig = careernetConfig;
    }

    public JSONArray getMajorInfo(String gubun, String thisPage, String perPage) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        // 필수 파라미터 설정
        String queryUrl = API_URL + "?apiKey=" + careernetConfig.getApiKey()
                + "&svcType=api"   // 필수 요청 변수
                + "&svcCode=MAJOR" // 리스트 조회
                + "&gubun=" + gubun // 고등학교 or 대학교
                + "&thisPage=" + thisPage  // 현재 페이지
                + "&perPage=" + perPage;   // 페이지 당 조회 건수

        ResponseEntity<String> response = restTemplate.getForEntity(queryUrl, String.class);

        // 응답 처리
        JSONObject jsonResponse = new JSONObject(response.getBody());
        JSONObject dataSearch = jsonResponse.getJSONObject("dataSearch");

        return dataSearch.getJSONArray("content");  // 학과 정보 리스트 반환
    }
}


