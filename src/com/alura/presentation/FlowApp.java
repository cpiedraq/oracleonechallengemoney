package com.alura.presentation;

import com.alura.models.ConversionCurrency;

import java.util.ArrayList;
import java.util.List;

public class FlowApp
{
    public void CompleteFlowOfApp()
    {
        boolean FinishApplication = false;
        ArrayList<ConversionCurrency> listConversion = new ArrayList<ConversionCurrency>();
        ShowHistoryOnScreen showHistoryOnScreen = new ShowHistoryOnScreen();
        filesHistory fileHistory = new filesHistory();

        while(!FinishApplication)
        {
            Menu menu = new Menu();
            RequestWebAPI requestAPI = new RequestWebAPI();
            menu.showMenu();

            FinishApplication = menu.isFinishNow();

            System.out.println("*********** Espere un momento mientras se realice su conversión *************");

            ConversionCurrency conversionCurrency = requestAPI.MakeRequest(menu.getOriginCurrency(), menu.getDestinationCurrency(), menu.getAmountToConverter());

            if(conversionCurrency != null)
            {
                listConversion.add(conversionCurrency);

                System.out.println(conversionCurrency.toString());
            }
        }

        //Resumen de las conversiones realizadas
        showHistoryOnScreen.showHistory(listConversion);
        fileHistory.selectIfWriteInFile(listConversion);
    }
}
