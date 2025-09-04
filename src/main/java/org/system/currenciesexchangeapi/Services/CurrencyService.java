package org.system.currenciesexchangeapi.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@Service
public class CurrencyService {
    @Value("${currency.key}")
    String api_key;
    @Value("${currency.url}")
    String api_url;
    RestTemplate restTemplate = new RestTemplate();
    public double getExchangeResult(String from, String to,float amount) {
        String url = api_url + "?from="+from+"&to="+to+"&amount="+amount+"&access_key="+api_key;
        Map<String,Object> response = restTemplate.getForObject(url, Map.class);
        return (double)response.get("result");
    }
}
