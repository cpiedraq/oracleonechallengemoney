package com.alura.presentation;

import com.alura.models.ConversionCurrency;

import java.util.ArrayList;

public class ShowHistoryOnScreen
{
    public void showHistory(ArrayList<ConversionCurrency> listConversion)
    {
        System.out.println("***************************************");
        System.out.println("RESUMEN/HISTORIAL DE CONVERSIONES REALIZADAS");

        for(int i=0; i< listConversion.size();i++)
        {
            System.out.println("//////////// REGISTRO " + (i + 1) + " /////////////");
            System.out.println(listConversion.get(i).toString());
        }
    }
}
