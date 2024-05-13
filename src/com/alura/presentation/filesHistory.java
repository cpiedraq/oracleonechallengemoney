package com.alura.presentation;

import com.alura.models.ConversionCurrency;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.text.html.Option;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class filesHistory
{

    public void selectIfWriteInFile(ArrayList<ConversionCurrency> listConversion)
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            int OptionToWrite = 0;

            System.out.println(".....................ESCRITURA EN ARCHIVO..........................");
            System.out.println("\nDesea escribir la información del historial en un archivo" +
                    "\n(1) Si" +
                    "\n(2) No");
            OptionToWrite = scanner.nextInt();

            if(OptionToWrite ==1)
            {
                WriteHistoryOnFile(listConversion);
            }
        }
        catch (Exception e)
        {
            System.out.println("Ingrese una ocpión válida para poder escribir el archivo");

            selectIfWriteInFile(listConversion);
        }
    }

    private void WriteHistoryOnFile(ArrayList<ConversionCurrency> listConversion)
    {
        try
        {
            Gson gson = new GsonBuilder().
                    setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).
                    setPrettyPrinting().
                    create();

            FileWriter createFile = new FileWriter("historialConversiones.txt");
            createFile.write(gson.toJson(listConversion));
            createFile.close();

            System.out.println("Se escribio el archivo historialConversiones de forma correcta");
        }
        catch (Exception e)
        {
            System.out.println("Ocurrio un error al escribir de historial");
        }
    }
}
