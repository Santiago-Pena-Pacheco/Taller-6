package com.example;

abstract public class Personaje {
    protected String id;
    protected String nombre;
    protected int nivel;
    protected double hpMaxima;
    protected double hpActual;
    protected double xp;
    protected double daño;

    public Personaje(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = 1;
        this.hpMaxima = 100;
        this.hpActual = this.hpMaxima;
        this.xp = 0.0;
        this.daño = 0.0;
    }

    public void info(){
        System.out.println("--- Información Del Personaje ---");
        System.out.println("id: " + id);
        System.out.println("nombre: " + nombre);
        System.out.println("nivel: " + nivel);
        System.out.println("hp máxima: " + hpMaxima);
        System.out.println("hp actual: " + hpActual);
        System.out.println("xp: " + xp);
        System.out.println("último daño causado: " + daño);
    }

    public void subirNivel(){
        double xpSubirNivel = (this.nivel * 100.0) + 100.0;
        if (this.xp >= xpSubirNivel){
            this.nivel += 1;
            this.hpMaxima += 20;
            this.hpActual = this.hpMaxima;
            System.out.println(this.nombre + " ha subido al nivel " + this.nivel + "!");
        } else {
            System.out.println("XP insuficiente para subir de nivel. XP actual: " + this.xp + " / Se requieren: " + xpSubirNivel);
        }
    }

    abstract void calcularDaño(Personaje oponente);
    abstract void habilidadEspecial(Personaje oponente);
}