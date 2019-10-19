/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Alkanet
 */
public class Reservas {
    private Integer numeroQuarto;
    private Date checkin;
    private Date checkout;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Reservas(){
        
    }
    public Reservas(Integer numeroQuarto, Date checkin, Date checkout){
        this.numeroQuarto=numeroQuarto;
        this.checkin=checkin;
        this.checkout=checkout;
    }

    /**
     * @return the numeroQuarto
     */
    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    /**
     * @param numeroQuarto the numeroQuarto to set
     */
    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    /**
     * @return the checkin
     */
    public Date getCheckin() {
        return checkin;
    }



    /**
     * @return the checkout
     */
    public Date getCheckout() {
        return checkout;
    }
    
    public long DuracaoDias(){
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkIn, Date checkOut){
        Date nova = new Date();
        if(checkIn.before(nova)||checkOut.before(nova)){
            return "As datas da reserva para atualização devem ser futuras";
        }
        if(!checkOut.after(checkIn)){
            return "A data do check-out deve ser superior a data do check-in";
        }  
        this.checkin=checkIn;
        this.checkout=checkOut;
        return null;
    }
    @Override
    public String toString(){
        return "Quarto "
                + numeroQuarto
                +" Check-In: "
                + sdf.format(checkin)
                +" Check-Out: "
                +sdf.format(checkout)
                +", "
                +DuracaoDias()
                +" noites";
    }
}
