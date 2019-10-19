/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import modelo.entidades.Reservas;
import modelo.excecoes.DominioDeExcecoes;

/**
 *
 * @author Alkanet
 */
public class ExcecoesJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            System.out.print("Número do quarto: ");
            Integer numeroQuarto=leia.nextInt();
            System.out.print("Data de Check-In(dd/MM/yyyy): ");
            Date checkIn=sdf.parse(leia.next());
            System.out.print("Data de Check-Out(dd/MM/yyyy): ");
            Date checkOut=sdf.parse(leia.next());
            Reservas res = new Reservas(numeroQuarto, checkIn, checkOut);
            System.out.println("Reserva: "+res);


            System.out.println("Digite os dados para atualizar a reserva:");
            System.out.print("Data de Check-In(dd/MM/yyyy): ");
            checkIn=sdf.parse(leia.next());
            System.out.print("Data de Check-Out(dd/MM/yyyy): ");
            checkOut=sdf.parse(leia.next());
            res.updateDates(checkIn, checkOut);

            System.out.println("Reserva: "+res);
            
        }
        catch(ParseException e){
            System.out.println("Data com formato inválido!");
        }
        catch(DominioDeExcecoes e){
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("Erro inesperado!");
        }

        
        
        
        leia.close();
    }
    
}
