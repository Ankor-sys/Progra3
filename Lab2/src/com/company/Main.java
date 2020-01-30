package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Declaracion de Variables
        float SueldoOrdinario, SueldoExtraordinario, Bonificaciones,
                Comisiones, Otros, TotalDevengadoI=0, IGSS, ISR, Anticipos,
                DescuentosJudiciales, OtrosD, TotalDescuentosI=0,TotalDevengado = 0 , TotalDescuentos = 0, TotalLiquidoI=0
                , TotalLiquidoT = 0;

        String nombre, apellido, puesto;
        //Matriz

        String[] Nombres = new String[10];
        Float [][] Sueldos = new Float[10][9];


        Scanner leer = new Scanner(System.in);

        for (int i=0; i<7;i++){
            System.out.println("***** BIENVENIDO A LA PLANILLA ******");
            System.out.println("Ingrese Nombre del Empleado: ");
            nombre = leer.next();
            System.out.println("Ingrese Apellido");
            apellido = leer.next();
            System.out.println("Ingrese el puesto:");
            puesto = leer.next();
            System.out.println("***********************************************");
            System.out.println("Ingrese el sueldo ordinario:");
            SueldoOrdinario = leer.nextFloat();
            System.out.println("Ingresar sueldo extraordinario:");
            SueldoExtraordinario = leer.nextFloat();
            System.out.println("Ingresar Bonificaciones");
            Bonificaciones = leer.nextFloat();
            System.out.println("Ingrese comisiones: ");
            Comisiones = leer.nextFloat();
            System.out.println("Ingrese otros ingresos: ");
            Otros = leer.nextFloat();
            if (SueldoOrdinario < 2800){
                SueldoOrdinario = 2800;

            }

            TotalDevengadoI = SueldoOrdinario + SueldoExtraordinario + Bonificaciones +
                    Comisiones + Otros;
            TotalDevengado += TotalDevengadoI;
            //Asignacion de valor al vector de nombres
            Nombres[i] = nombre;
            //Asignacion de Sueldo Bruto a la matriz de sueldos
            Sueldos[i][0] = TotalDevengadoI;

            System.out.println("TOTAL DEVENGADO: " + TotalDevengadoI);

            System.out.println(" - ");

            System.out.println("**** D E S C U E N T O S");


            if(TotalDevengadoI >= 6000.00 && TotalDevengadoI < 7500 ){
                IGSS = TotalDevengadoI * 0.0483f;
                ISR = TotalDevengadoI * 0.05f;
            }
            else if(TotalDevengadoI >= 7500 && TotalDevengadoI < 9000){
                IGSS = TotalDevengadoI*0.0483f;
                ISR = TotalDevengadoI * 0.06f;
            }
            else if(TotalDevengadoI > 9000){
                IGSS = TotalDevengadoI * 0.0483f;
                ISR = TotalDevengadoI * 0.08f;
            }
            else{
                IGSS = SueldoOrdinario * 0.0483f;
                ISR = 0;
            }
            //Asignacion de valores a la matriz de sueldos
            Sueldos[i][1] = IGSS;
            Sueldos[i][2] = ISR;


            System.out.println("Descuento de IGSS: " + IGSS);
            System.out.println("Descuento de ISR: " + ISR);
            System.out.println("Ingrese los anticipos: ");
            Anticipos = leer.nextFloat();
            System.out.println("Ingrese los descuentos judiciales:  ");
            DescuentosJudiciales = leer.nextFloat();
            System.out.println("Ingrese otro tipo de descuentos: ");
            OtrosD = leer.nextFloat();
            //Asignacion de valores a matriz de sueldos
            
            TotalDescuentosI = IGSS + ISR + Anticipos + DescuentosJudiciales + OtrosD;
            TotalDescuentos += TotalDescuentosI;
            System.out.println("TOTAL DE DESCUENTOS: "+ TotalDescuentosI);
            TotalLiquidoI = TotalDevengadoI - TotalDescuentosI;
            TotalLiquidoT += TotalLiquidoI;
            System.out.println("TOTAL LIQUIDO: " + TotalLiquidoI);

            Sueldos[i][0]= nombre;
            Sueldos[i][1] = apellido;
            Sueldos[i][2] = puesto;
            Sueldos[i][3] = Float.toString(TotalLiquidoI);
        }

        System.out.println(" NOMBRE                      |  APELLIDO                       | PUESTO                        |  TOTAL LIQUIDO                 " );
        for (int i = 0; i < 7  ; i++) {
            for (int j = 0; j<4; j++){
                System.out.print(Sueldos[i][j] + "                     ");
            }
            System.out.println("");
        }

        System.out.println("------------------------------------------------------");
        System.out.println("TOTAL DEVENGADOS: " + TotalDevengado);
        System.out.println("TOTAL DESCUENTOS: " + TotalDescuentos);
        System.out.println("TOTAL LIQUIDOS: " + TotalLiquidoT);
    }
}
