package com.alura.presentation;

import com.alura.models.ConversionCurrency;
import com.alura.models.ConversionCurrencyDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestWebAPI
{
    String bodyOfWebServices = "";

    public ConversionCurrency MakeRequest(String originCurrency, String destinationCurrency, int amount)
    {
        try
        {
            String url = "https://v6.exchangerate-api.com/v6/";
            String keyForAPI= "2c454c8c9c82203cf29d56c7";
            String parametersCurrency = "/pair/" + originCurrency + "/" + destinationCurrency;
            String urlWithParameters = url + keyForAPI + parametersCurrency;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = (HttpRequest) HttpRequest.newBuilder().
                    uri(URI.create(urlWithParameters))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            this.bodyOfWebServices = response.body();

            return InfoOfConversion(response.body(), amount);

        }
        catch(Exception e)
        {
            System.out.println("Ocurrio un error al consumir el servicio web para conversión de monedas");

            return null;
        }
    }

    public ConversionCurrency InfoOfConversion(String bodyOfWebServices, int amount)
    {
        try
        {
            ConversionCurrency conversionCurrency;
            Gson gson = new GsonBuilder().create();

            ConversionCurrencyDTO conversionDTO = gson.fromJson(bodyOfWebServices, ConversionCurrencyDTO.class);

            conversionCurrency  = new ConversionCurrency(conversionDTO, amount);

            return conversionCurrency;
        }
        catch (Exception e)
        {
            return null;
        }
    }

}
