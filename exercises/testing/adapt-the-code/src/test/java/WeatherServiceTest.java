import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public final class WeatherServiceTest {

    @Test
    void sunnyData() {
        HttpClient client = new HttpClient() {
            @Override
            public String get(String url) throws IOException {
                return "Sunny";
            }
        };

        WeatherService service = new WeatherService(client);
        assertThat(service.getWeatherToday(), is(Weather.SUNNY));
    }

    @Test
    void rainyData() {
        HttpClient client = new HttpClient() {
            @Override
            public String get(String url) throws IOException {
                return "Rainy";
            }
        };

        WeatherService service = new WeatherService(client);
        assertThat(service.getWeatherToday(), is(Weather.RAINY));
    }

    @Test
    void SnowyData() {
        HttpClient client = new HttpClient() {
            @Override
            public String get(String url) throws IOException {
                return "Snowy";
            }
        };

        WeatherService service = new WeatherService(client);
        assertThat(service.getWeatherToday(), is(Weather.SNOWY));
    }

    @Test
    void strangeData() {
        HttpClient client = new HttpClient() {
            @Override
            public String get(String url) throws IOException {
                return "???";
            }
        };

        WeatherService service = new WeatherService(client);
        assertThat(service.getWeatherToday(), is(Weather.ITS_RAINING_MEN_HALLELUJAH));
    }

    @Test
    void defaultData() {
        HttpClient client = new HttpClient() {
            @Override
            public String get(String url) throws IOException {
                return "";
            }
        };

        WeatherService service = new WeatherService(client);
        assertThat(service.getWeatherToday(), is(Weather.UNKNOWN));
    }

    @Test
    void getReturnExceptionData() {
        HttpClient client = new HttpClient() {
            @Override
            public String get(String url) throws IOException {
                throw new IOException();
            }
        };

        WeatherService service = new WeatherService(client);
        assertThat(service.getWeatherToday(), is(Weather.UNKNOWN));
    }

    /** MOCKITO **/


    @Test
    void ShouldReturnSunny() throws IOException {
        HttpClient client = mock(HttpClient.class);
        when(client.get(anyString())).thenReturn("Sunny");

        WeatherService ws = new WeatherService(client);
        assertThat(ws.getWeatherToday(), is(Weather.SUNNY));
    }
}
