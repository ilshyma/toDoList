package com.ilshyma.toDoList.Model.Util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by star on 10.02.2016.
 */
@Component
public class UsdCurrency extends CurrencyExchange {
    private static final Logger LOGGER = Logger.getLogger(UsdCurrency.class);
    private static double CURRENTRATE;
    private boolean actual;

    public boolean isActual() {
        return actual;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }

    public double getCurrentUsdUahRate() {
        return CURRENTRATE;
    }

    public void setCurrentUsdUahRate(double rate) {
        this.CURRENTRATE = rate;
    }

    public UsdCurrency() {
        checkUsdCurrency();
    }

    @Scheduled(fixedDelay = 60000)
    public void checkUsdCurrency() {
        LOGGER.info("update USD rate");

        double paymentPerHourRate = 25.50;
        boolean parseStatus = false;

        ObjectMapper mapper = new ObjectMapper();

        try {
            List<CurrencyExchange> list = mapper.readValue(new URL(CurrencyExchange.getExchangeUrl()), new TypeReference<List<CurrencyExchange>>() {
            });

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCcy().equalsIgnoreCase("USD")) {
                    paymentPerHourRate = Math.rint(1000.0 * (((list.get(i).getBuy() + list.get(i).getSale()) / 2)) / 1000.0);
                    break;
                }
            }
            parseStatus = true;

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            UsdCurrency.this.setCurrentUsdUahRate(paymentPerHourRate);
            UsdCurrency.this.setActual(parseStatus);
            if (UsdCurrency.this.isActual()) {
                LOGGER.info("usdCurrency update success");
            } else {
                LOGGER.info("usdCurrency update fail");
            }
            LOGGER.info("usd currency rate = " + UsdCurrency.this.getCurrentUsdUahRate());
        }

    }


}
