package com.ilshyma.toDoList.Utility;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilshyma.toDoList.Model.Util.CurrencyExchange;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by user on 10.02.2016.
 */
public class UsdRateServise {
    public static double GETUSDRATE() {

        double paymentPerHourRate = 0;
        ObjectMapper mapper = new ObjectMapper();

        try {
            List<CurrencyExchange> list = mapper.readValue(new URL(CurrencyExchange.getExchangeUrl()), new TypeReference<List<CurrencyExchange>>() {});

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCcy().equalsIgnoreCase("USD")){
                    paymentPerHourRate =  Math.rint(100.0 * (((list.get(i).getBuy()+list.get(i).getSale())/2)) / 100.0);
                    break;
                }
            }
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return paymentPerHourRate;
    }
}
