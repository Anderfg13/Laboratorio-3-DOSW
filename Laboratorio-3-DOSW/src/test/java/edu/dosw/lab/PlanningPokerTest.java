package edu.dosw.lab;

import edu.dosw.lab.agilismo.PlanningPoker;


import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class PlanningPokerTest {

	@Test
	void testPlanningPokerMainConsensus() {
		// Simula votos iguales para todas las historias (consenso inmediato)
		StringBuilder inputBuilder = new StringBuilder();
		// 6 historias, 3 miembros cada una, todos votan 3
		for (int i = 0; i < 6 * 3; i++) {
			inputBuilder.append("3\n");
		}
		System.setIn(new ByteArrayInputStream(inputBuilder.toString().getBytes()));
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		new PlanningPoker().main(new String[]{});

		System.setOut(System.out); // Restaurar salida estándar
		String output = outContent.toString();
		// Debe contener "Consenso alcanzado" y el resumen final
		assertTrue(output.contains("Consenso alcanzado: 3"));
		assertTrue(output.contains("Resumen final"));
		assertTrue(output.contains("Usuario: Crear cuenta"));
	}

	@Test
	void testPlanningPokerMainDivergenteYConsenso() {
		// Simula votos divergentes y luego consenso
		StringBuilder inputBuilder = new StringBuilder();
		// Primera historia: 1, 2, 3 (divergente), luego 5, 5, 5 (consenso)
		inputBuilder.append("1\n2\n3\n5\n5\n5\n");
		// El resto historias: consenso inmediato (todos 2)
		for (int i = 0; i < 5 * 3; i++) {
			inputBuilder.append("2\n");
		}
		System.setIn(new ByteArrayInputStream(inputBuilder.toString().getBytes()));
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		new PlanningPoker().main(new String[]{});

		System.setOut(System.out); // Restaurar salida estándar
		String output = outContent.toString();
		// Debe mostrar votos divergentes y luego consenso
		assertTrue(output.contains("Votos divergentes: [1, 2, 3]"));
		assertTrue(output.contains("Consenso alcanzado: 5"));
		assertTrue(output.contains("Resumen final"));
	}

	@Test
	void testPlanningPokerMainValorInvalido() {
		// Simula un voto inválido seguido de uno válido
		StringBuilder inputBuilder = new StringBuilder();
		// Primera historia, primer miembro: 7 (inválido), luego 2 (válido), resto 2
		inputBuilder.append("7\n2\n2\n2\n");
		// El resto historias: consenso inmediato (todos 2)
		for (int i = 0; i < 5 * 3; i++) {
			inputBuilder.append("2\n");
		}
		System.setIn(new ByteArrayInputStream(inputBuilder.toString().getBytes()));
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		new PlanningPoker().main(new String[]{});

		System.setOut(System.out); // Restaurar salida estándar
		String output = outContent.toString();
		// Debe mostrar mensaje de valor inválido
		assertTrue(output.contains("Valor inválido. Intenta de nuevo."));
		assertTrue(output.contains("Resumen final"));
	}
}
