package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

class MainTest {

    @Test
    void testStarterWithValidParametersEasyEasy() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        String input1 = "start easy easy\nexit\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input1.getBytes());
        System.setIn(in);

        Main.SCANNER = new Scanner(System.in);
        Main.starter();

        System.setOut(new PrintStream(outputStreamCaptor));

        String output = outputStreamCaptor.toString().trim();
        assertThat(output).contains("Making move level \"easy\"");
    }

    @Test
    void testStarterWithValidParametersMediumHard() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        String input1 = "start medium hard\nexit\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input1.getBytes());
        System.setIn(in);

        Main.SCANNER = new Scanner(System.in);
        Main.starter();

        System.setOut(new PrintStream(outputStreamCaptor));

        String output = outputStreamCaptor.toString().trim();
        assertThat(output).contains("Making move level \"medium\"");
        assertThat(output).contains("Making move level \"hard\"");
    }


    @Test
    void testStarterWithExit() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        String input = "exit\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.SCANNER = new Scanner(System.in);
        Main.starter();

        System.setOut(new PrintStream(outputStreamCaptor));

        String output = outputStreamCaptor.toString().trim();
        assertThat(output).isEqualToIgnoringCase("");
    }

    @Test
    void testStarterWithInvalidParameters() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        String input = "start invalid user\nexit\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.SCANNER = new Scanner(System.in);
        Main.starter();

        System.setOut(new PrintStream(outputStreamCaptor));

        String output = outputStreamCaptor.toString().trim();
        assertThat(output).isEqualToIgnoringCase("Bad parameters!");

    }

    @Test
    void testStarterWithInvalidStartParameter() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        String input = "invalid easy user\nexit\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.SCANNER = new Scanner(System.in);
        Main.starter();

        System.setOut(new PrintStream(outputStreamCaptor));

        String output = outputStreamCaptor.toString().trim();
        assertThat(output).isEqualToIgnoringCase("Bad parameters!");

    }

    @Test
    void testExitCommand() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        String input = "exit\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.SCANNER = new Scanner(System.in);
        Main.main(new String[]{});

        System.setOut(new PrintStream(outputStreamCaptor));

        String output = outputStreamCaptor.toString();
        assertTrue(output.trim().isEmpty());
    }
}
