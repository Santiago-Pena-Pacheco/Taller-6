package com.example;

public class Mago extends Personaje {
    private int poderMagico;
    private int mana;

    public Mago(String id, String nombre) {
        super(id, nombre);
        this.poderMagico = 30;
        this.mana = 100;
    }

    @Override 
    public void calcularDaño(Personaje oponente){ 
        this.daño = this.poderMagico * this.nivel;
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
        if (this.mana >= 20){
            this.mana -= 20;
            System.out.println(this.nombre + " lanza hechizo especial. Maná actual: " + this.mana);
            this.daño = this.poderMagico * this.nivel * 2;
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
        } else {
            System.out.println("Maná insuficiente para lanzar la habilidad especial.");
        }
    }
}
