package ru.kabatov.config;

/**
 * Created by Кабатов on 23.08.2017.
 */
import java.util.Locale;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("userSettings")
public class UserSettings {

    @Value("#{countryBean}") //inject bean
    private Country country;

    public UserSettings() {
    }

    public void loadSettings(){
        country.loadSettings();
    }

    public String getLanguage(){
        return country.getLanguage();
    }

    public String getCountry(){
        return country.getCountry();
    }
}
