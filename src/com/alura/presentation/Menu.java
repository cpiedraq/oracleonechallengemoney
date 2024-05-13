package com.alura.presentation;

import com.sun.source.tree.TryTree;

import javax.swing.text.html.Option;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu
{
    private String originCurrency = "";
    private String destinationCurrency = "";
    private int amountToConverter = 0;
    private int originOptionSelected = 0;
    private int destinationOptionSelected = 0;
    private boolean FinishNow = false;

    public void showMenu()
    {
        int originCurrentSelected = 0;
        int destinationCurrentSelected = 0;

        createMenuWelcome();
        originCurrentSelected = createMenuOrigin();

        if(!FinishNow)
        {
            destinationCurrentSelected = createMenuDestination();

            if(!FinishNow)
            {
                this.originCurrency = returnAbreviationOfMoney(originCurrentSelected);
                this.destinationCurrency= returnAbreviationOfMoney(destinationCurrentSelected);
                this. amountToConverter = createAmountMenu(originCurrency, destinationCurrency);
            }
        }
    }

    public String getOriginCurrency() {
        return originCurrency;
    }

    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public int getAmountToConverter() {
        return amountToConverter;
    }

    public void setOriginCurrency(String originCurrency) {
        this.originCurrency = originCurrency;
    }

    public void setDestinationCurrency(String destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public void setAmountToConverter(int amountToConverter) {
        this.amountToConverter = amountToConverter;
    }

    public void createMenuWelcome()
    {
        String menuOptions = "";

        menuOptions = "\n-----------------------------------------------" +
                "\nConversor de Monedas, seleccione una opcion" +
                "\n-----------------------------------------------------";
        System.out.println(menuOptions);
    }

    public int createMenuOrigin()
    {
        try
        {
            Scanner inputUser = new Scanner(System.in);
            String menuOptions = "";
            int optionSelected = 0;

            menuOptions = "\n MONEDA DE ORIGEN" +
                    "\n ---------------------------------------------------------" +
                    "\n Seleccione la moneda de origen de su dinero:  " +
                    "\n (1) ARS - Peso argentino" +
                    "\n (2) BOB - Boliviano boliviano" +
                    "\n (3) BRL - Real brasileño" +
                    "\n (4) CLP - Peso chileno" +
                    "\n (5) COP - Peso colombiano" +
                    "\n (6) USD - Dólar estadounidense" +
                    "\n (7) Salir";

            System.out.println(menuOptions);
            optionSelected = inputUser.nextInt();

            this.originOptionSelected = optionSelected;

            if(checkIfTheOptionIsCorrect(optionSelected))
            {
                return optionSelected;
            }
            else
            {
                return createMenuOrigin();
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println("La opcion insertada debe ser entre 1 a 7");

            return createMenuOrigin();
        }
        catch(Exception e)
        {
            System.out.println("Se encontro un error al ingresar la moneda de origen");

            return createMenuOrigin();
        }
    }

    public int createMenuDestination()
    {
        try
        {
            Scanner inputUser = new Scanner(System.in);
            String menuOptions = "";
            int optionSelected = 0;

            menuOptions = " MONEDA DE DESTINO" +
                    "\n-------------------------------------------------------------" +
                    "\nSeleccione la moneda a la cual desea convertir el dinero:  " +
                    "\n (1) ARS - Peso argentino" +
                    "\n (2) BOB - Boliviano boliviano" +
                    "\n (3) BRL - Real brasileño" +
                    "\n (4) CLP - Peso chileno" +
                    "\n (5) COP - Peso colombiano" +
                    "\n (6) USD - Dólar estadounidense" +
                    "\n (7) Salir";

            System.out.println(menuOptions);
            optionSelected = inputUser.nextInt();

            if(checkIfTheOptionIsCorrect(optionSelected))
            {
                if(originOptionSelected != optionSelected)
                {
                    return optionSelected;
                }
                else
                {
                    System.out.println("La opcion de la moneda de destino debe ser diferente a la moneda de origen, ingrese una opcion diferente");

                    return createMenuDestination();
                }

            }
            else
            {
                return createMenuDestination();
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println("La opcion insertada debe ser entre 1 a 7");

            return createMenuDestination();
        }
        catch(Exception e)
        {
            System.out.println("Se encontro un error al ingresar la moneda de origen");

            return createMenuDestination();
        }
    }

    public int createAmountMenu(String originCurrency, String destinationCurrency)
    {
        try
        {
            Scanner inputUser = new Scanner(System.in);
            String menuOptions = "";
            int optionSelected = 0;

            menuOptions = "Ingrese el monto que desea convertir de " + originCurrency + " a " + destinationCurrency;

            System.out.println(menuOptions);
            optionSelected = inputUser.nextInt();

            return optionSelected;
        }
        catch(Exception e)
        {
            System.out.println("Debe de ingresar un monto correcto");

            return createAmountMenu(originCurrency,destinationCurrency);
        }
    }

    public void showFinishMessage()
    {
        String textForShow = "";

        textForShow= "Gracias por utilizar el conversor de monedas";
        System.out.println(textForShow);
    }

    public boolean checkIfTheOptionIsCorrect(int OptionInserted)
    {
        if(OptionInserted  >=1 && OptionInserted <=7)
        {
            if(OptionInserted == 7)
            {
                FinishNow = true;
            }

            return true;
        }
        else
        {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("La opcion insertada no es correcta, por favor seleccione una opcion valida");

            return false;
        }
    }

    public String returnAbreviationOfMoney(int optionSelected)
    {
        String abreviationOfMoney = "";

        switch (optionSelected)
        {
            case 1:
                abreviationOfMoney = "ARS";
                break;
            case 2:
                abreviationOfMoney = "BOB";
                break;
            case 3:
                abreviationOfMoney = "BRL";
                break;
            case 4:
                abreviationOfMoney = "CLP";
                break;
            case 5:
                abreviationOfMoney = "COP";
                break;
            case 6:
                abreviationOfMoney = "USD";
                break;
        }

        return abreviationOfMoney;
    }

    public boolean isFinishNow() {
        return FinishNow;
    }
}
