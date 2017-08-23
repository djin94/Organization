package ru.kabatov.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Locale;

/**
 * Created by Кабатов on 23.08.2017.
 */
@Component("countryBean")
public class Country {

    @Value("RU") //inject string directly
    private String country;

    @Value("ru")
    private String language;

    public Country() {
    }

    public String getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    void loadSettings(){
        this.country = Locale.getDefault().getCountry();
        this.language = Locale.getDefault().getLanguage();
    }
}