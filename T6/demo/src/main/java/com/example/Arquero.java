package com.example;

public class Arquero extends Personaje {
    private int fuerza;
    private double precision;

    public Arquero(String id, String nombre) {
        super(id, nombre);
        this.fuerza = 20;
        this.precision = 15.0;
    }

    @Override 
    public void calcularDaño(Personaje oponente){
        this.daño = (this.fuerza * this.nivel) + this.precision;
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
        // Aseguramos que el daño base esté calculado antes del crítico
        this.daño = ((this.fuerza * this.nivel) + this.precision) * 2;
        System.out.println(this.nombre + " dispara una Flecha Crítica!");
        
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
