package com.example;

public class Juego {
    public static void main(String[] args) {
        // Creación de los personajes requeridos (2 guerreros, 2 magos, 2 arqueros)
        Guerrero g1 = new Guerrero("1", "Aragorn");
        Guerrero g2 = new Guerrero("2", "Boromir");
        
        Mago m1 = new Mago("3", "Gandalf");
        Mago m2 = new Mago("4", "Saruman");
        
        Arquero a1 = new Arquero("5", "Legolas");
        Arquero a2 = new Arquero("6", "Faramir");

        System.out.println(" INFORMACIÓN INICIAL DE LOS PARTICIPANTES");

        int turno = 1;
        while (g1.hpActual > 0 && m1.hpActual > 0) {
            System.out.println("\nTurno " + turno);
            
            System.out.println(g1.nombre + " ataca a " + m1.nombre + "!");
            g1.calcularDaño(m1);
            
            if (m1.hpActual > 0) {
                System.out.println(m1.nombre + " contraataca a " + g1.nombre + "!");
                m1.calcularDaño(g1);
            } else {
                System.out.println(m1.nombre + " ha caído. El combate ha terminado.");
                break;
            }
            
            if (g1.hpActual <= 0) {
                System.out.println(g1.nombre + " ha caído. El combate ha terminado.");
                break;
            }
            
            turno++;
        }

        System.out.println(" INFORMACIÓN INICIAL DE LOS PARTICIPANTES");
        g1.info();
        g2.info();
        m1.info();
        m2.info();
        a1.info();
        a2.info();

        System.out.println("\nINICIO DE COMBATES");

        System.out.println("\nTurno 1: Aragorn (Guerrero) ataca a Faramir (Arquero)");
        g1.calcularDaño(a2);

        System.out.println("\nTurno 2: Legolas (Arquero) usa habilidad especial contra Boromir (Guerrero)");
        a1.habilidadEspecial(g2);

        System.out.println("\nTurno 3: Saruman (Mago) ataca a Legolas (Arquero)");
        m2.calcularDaño(a1);

        System.out.println("\nTurno 4: Gandalf (Mago) ataca a Aragorn (Guerrero)");
        System.out.println("Gandalf usa su primer hechizo especial contra Aragorn:");
        m1.habilidadEspecial(g1);
        System.out.println("Gandalf remata con su segundo hechizo especial:");
        m1.habilidadEspecial(g1);

        System.out.println("\nTurno 5: Gandalf (Mago) ataca a Faramir (Arquero)");
        System.out.println("Gandalf lanza hechizo especial contra Faramir:");
        m1.habilidadEspecial(a2);
        System.out.println("Gandalf usa otro hechizo especial y derrota a Faramir:");
        m1.habilidadEspecial(a2); 

        System.out.println("\n ESTADO FINAL DE LOS PARTICIPANTES");

        g1.info();
        g2.info();
        m1.info();
        m2.info();
        a1.info();
        a2.info();
    }
}