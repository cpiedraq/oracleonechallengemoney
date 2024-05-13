package com.alura.models;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;

public class ConversionCurrency
{
    private String resultWSConversion = "";
    private String originCurrency = "";
    private String optionDestination = "";
    private double conversion = 0;
    private double resultConversion = 0;
    private double amount = 0;
    private String hourOfConversion;

    public ConversionCurrency(ConversionCurrencyDTO conversionCurrencyDTO, double amountInserted)
    {
        this.resultWSConversion = conversionCurrencyDTO.result();
        this.originCurrency = conversionCurrencyDTO.base_code();
        this.optionDestination = conversionCurrencyDTO.target_code();
        this.conversion = Double.parseDouble(conversionCurrencyDTO.conversion_rate());
        this.amount = amountInserted;
        this.hourOfConversion = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
    }

    public double getResultOfConversion()
    {
        this.resultConversion =  amount * conversion;

        return resultConversion;
    }

    @Override
    public String toString() {
        return "\n ************************* RESUMEN DE LA CONVERSION ******************************" +
                "\nEl resumen de la conversion es la siguiente: " +
                "\nLa moneda de origen es: " + originCurrency +
                "\nLa moneda de destino es: " + optionDestination +
                "\nEl monto ingresado por el usuario " + amount +
                "\nEl valor de conversion es el siguiente: " + conversion +
                "\nEl resultado de la conversion es: " + getResultOfConversion()+
                "\nLa hora a la que se realizo la conversion fue: " + this.hourOfConversion +
                "\n*********************************************************************************";
    }

    public double getAmount() {
        return amount;
    }

    public String getHourOfConversion() {
        return hourOfConversion;
    }
}
