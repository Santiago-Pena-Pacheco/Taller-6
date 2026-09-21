package com.example;

public class Guerrero extends Personaje {
    private int fuerza;

    public Guerrero(String id, String nombre) {
        super(id, nombre);
        this.fuerza = 30;    
    }

    @Override 
    public void calcularDaño(Personaje oponente){ 
        this.daño = this.fuerza * this.nivel;
        oponente.hpActual -= this.daño;
        if (oponente.hpActual <= 0){
            oponente.hpActual = 0;
            System.out.println(oponente.nombre + " Murió :(");
            this.xp += 100;
            System.out.println(this.nombre + " ganó 100xp");
            this.subirNivel();
        } else {
            System.out.println(oponente.nombre + " tiene " + oponente.hpActual + " HP restante");
        }
    }

    @Override 
    public void habilidadEspecial(Personaje oponente){ 
        this.daño = this.fuerza * this.nivel;
        if (this.hpActual <= this.hpMaxima * 0.3){
            this.daño += this.daño * 0.2; // Extra de daño si tiene poca vida
            System.out.println(this.nombre + " usa Golpe Furia con daño aumentado!");
        } else {
            System.out.println(this.nombre + " usa Golpe Furia.");
        }
        
        oponente.hpActual -= this.daño;
        if (oponente.hpActual <= 0){
            oponente.hpActual = 0;
            System.out.println(oponente.nombre + " Murió :(");
            this.xp += 100;
            System.out.println(this.nombre + " ganó 100xp");
            this.subirNivel();
        } else {
            System.out.println(oponente.nombre + " tiene " + oponente.hpActual + " HP restante");
        }
    }
}