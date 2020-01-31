/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio2_p3;

import java.util.Scanner;

/**
 *
 * @author SEBAS
 */
public class Laboratorio2_P3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Declaracion de Variables
        float SueldoOrdinario, SueldoExtraordinario, Bonificaciones,
                Comisiones, Otros, TotalDevengadoI=0, IGSS, ISR, Anticipos,
                DescuentosJudiciales, OtrosD, TotalDescuentosI=0,TotalDevengado = 0 , TotalDescuentos = 0, TotalLiquidoI=0
                , TotalLiquidoT = 0;

        String nombre, apellido, puesto;
        //Matriz

        String[][] Datos = new String[10][3];
        Float [][] Sueldos = new Float[10][10];


        Scanner leer = new Scanner(System.in);

        for (int i=0; i<2;i++){
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
            System.out.println("Ingresa horas extra:");
            SueldoExtraordinario = leer.nextFloat();
            SueldoExtraordinario = SueldoExtraordinario * 1.5f;
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
            //Asignacion de valor al vector de datos
            Datos[i][0] = nombre;
            Datos[i][1] = apellido;
            Datos[i][2] = puesto;
            //Asignacion de Sueldo Bruto a la matriz de sueldos
            Sueldos[i][0] = SueldoExtraordinario;
            Sueldos[i][1] = TotalDevengadoI;

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
            Sueldos[i][2] = IGSS;
            Sueldos[i][3] = ISR;


            System.out.println("Descuento de IGSS: " + IGSS);
            System.out.println("Descuento de ISR: " + ISR);
            System.out.println("Ingrese los anticipos: ");
            Anticipos = leer.nextFloat();
            System.out.println("Ingrese los descuentos judiciales:  ");
            DescuentosJudiciales = leer.nextFloat();
            System.out.println("Ingrese otro tipo de descuentos: ");
            OtrosD = leer.nextFloat();
            //Asignacion de valores a matriz de sueldos
            Sueldos[i][4] = Anticipos;
            Sueldos [i][5] = DescuentosJudiciales;
            Sueldos[i][6] = OtrosD;
            Sueldos [i][7] = TotalDescuentosI;
            Sueldos[i][8] = TotalLiquidoI;

            TotalDescuentosI = IGSS + ISR + Anticipos + DescuentosJudiciales + OtrosD;
            TotalDescuentos += TotalDescuentosI;
            System.out.println("TOTAL DE DESCUENTOS: "+ TotalDescuentosI);
            TotalLiquidoI = TotalDevengadoI - TotalDescuentosI;
            TotalLiquidoT += TotalLiquidoI;
            System.out.println("TOTAL LIQUIDO: " + TotalLiquidoI);
            System.out.println(" ");
            System.out.println(" ");

        }

        System.out.println(" ");
        System.out.println("----  P L A N I L L A   D E   S U E L D O S  -----");
        for (int i = 0; i < 10  ; i++) {
            System.out.println(" ------------------------------------------------------------------------------------------");
            System.out.println("Nombre: " + Datos[i][0] + " " + Datos[i][1] );
            System.out.println("Puesto: " + Datos[i][2] );
            for (int j = 0; j<10; j++){
                switch(j){
                    case 0:
                         System.out.println("   Sueldo Extraordinario: " +Sueldos[i][j] );
                        break;
                    case 1: 
                         System.out.println("   Sueldo Bruto: " +Sueldos[i][j] );
                        break;
                    case 2:
                         System.out.println("   IGSS: " +Sueldos[i][j] );
                         break;
                    case 3: 
                         System.out.println("   ISR: " +Sueldos[i][j] );
                         break;
                    case 4:
                         System.out.println("   Anticipos: " +Sueldos[i][j] );
                        break;
                    case 5:
                         System.out.println("   Descuentos Judiciales: " +Sueldos[i][j] );
                        break;
                    case 6:
                         System.out.println("   Otros descuentos: " +Sueldos[i][j] );
                        break;
                    case 7:
                         System.out.println("   Total descuentos: " +Sueldos[i][j] );
                        break;
                    case 8:
                         System.out.println("   SUELDO TOTAL: " +Sueldos[i][j] );
                        break;
                        
                }
               
            }
        }

        System.out.println("------------------------------------------------------");
        System.out.println("TOTAL DEVENGADOS: " + TotalDevengado);
        System.out.println("TOTAL DESCUENTOS: " + TotalDescuentos);
        System.out.println("TOTAL LIQUIDOS: " + TotalLiquidoT);
    }
    
}
