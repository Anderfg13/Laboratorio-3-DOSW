package edu.dosw.lab.agilismo;

import java.util.*;

public class PlanningPoker {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> fibonacci = Arrays.asList(1, 2, 3, 5, 8, 13);
        Map<String, Integer> results = new LinkedHashMap<>();

        String[] stories = {"Usuario: Crear cuenta", "Bankify: Validar cuenta", "Usuario: Consultar saldo",    
        "Usuario: Hacer depósito", "Banco: Consultar usuarios", "Bankify: Gestionar bancos"};
        int teamMembers = 3;

        for (String story : stories) {
            boolean consensus = false;
            while (!consensus) {
                System.out.println("\nHistoria: " + story);
                List<Integer> votes = new ArrayList<>();

                for (int i = 1; i <= teamMembers; i++) {
                    int vote;
                    while (true) {
                        System.out.print("Miembro " + i + ", elige un puntaje " + fibonacci + ": ");
                        vote = scanner.nextInt();
                        if (fibonacci.contains(vote)) break;
                        System.out.println("Valor inválido. Intenta de nuevo.");
                    }
                    votes.add(vote);
                }

                boolean allEqual = votes.stream().allMatch(v -> v.equals(votes.get(0)));
                if (allEqual) {
                    System.out.println("Consenso alcanzado: " + votes.get(0));
                    results.put(story, votes.get(0));
                    consensus = true;
                } else {
                    System.out.println("Votos divergentes: " + votes);
                    System.out.println("Discutan y vuelvan a votar...");
                }
            }
        }

        System.out.println("\n Resumen final:");
        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
    }
}

