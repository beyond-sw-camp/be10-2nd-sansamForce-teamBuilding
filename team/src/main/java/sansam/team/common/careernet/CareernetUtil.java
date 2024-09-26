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
        private static final String API_URL = " //www.career.go.kr/cnet/openapi/getOpenApi.json?apiKey=";
        private static final String SERVICE_TYPE = "schoolInfo";

        private final CareernetConfig careernetConfig;

        @Autowired
        public CareernetUtil(CareernetConfig careernetConfig) {
            this.careernetConfig = careernetConfig;
        }

        public JSONArray getMajorInfo() throws Exception {
            RestTemplate restTemplate = new RestTemplate();
            String queryUrl = API_URL + careernetConfig.getApiKey();

            ResponseEntity<String> response = restTemplate.getForEntity(queryUrl, String.class);
            JSONObject jsonResponse = new JSONObject(response.getBody());

            return jsonResponse.getJSONArray("majors");
        }
}


