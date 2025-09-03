package edu.dosw.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import edu.dosw.lab.agilismo.PlanningPoker; // importa tu clase PlanningPoker

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("Proyecto Maven creado y corriendo correctamente 🚀");

        // Ejecutar Planning Poker directamente
        PlanningPoker poker = new PlanningPoker();
        poker.main(args); // aquí llamas al método que implementa tu lógica
    }
}
