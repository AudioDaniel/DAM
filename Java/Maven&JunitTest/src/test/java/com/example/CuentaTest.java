package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

// import java.io.ByteArrayOutputStream;
// import java.io.PrintStream;
// import org.junit.jupiter.api.AfterAll;
// import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

@TestInstance(Lifecycle.PER_CLASS)
public class CuentaTest {

    // Todo esto (los comentarios) lo tenía puesto porque quería
    // analizar el System.out redirigiendo el stream de datos,
    // pero realmente me di cuenta que era mucho mas sencillo y
    // legible retornar una copia del mensaje en el método de la clase Cuenta

    // private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    // private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    // private final PrintStream originalOut = System.out;
    // private final PrintStream originalErr = System.err;

    Cuenta cuenta;

    @BeforeEach
    public void setUpCuenta() {
        cuenta = new Cuenta(100, 100);
    }

    @Test
    public void ingresarDineroDebeDar100() {
        assertEquals(200, cuenta.ingresarDinero(100));
    }

    @Test
    public void extraerDineroDebedar0() {
        assertEquals(0, cuenta.extraerDinero(100));
    }

    @Test
    public void constructorDeCuentaDebeDar100y101() {
        Cuenta cuentatest = new Cuenta(102, 101);
        assertEquals(101, cuentatest.saldo);
        assertEquals(102, cuentatest.ncuenta);
    }

    @Test
    public void mostrarCuentaDebeImprimir100y100() {
        cuenta.mostrarCuenta();
        assertEquals("Nº de cuenta" + cuenta.ncuenta + "\n" + "Su saldo" + "\n" + cuenta.saldo, cuenta.mostrarCuenta());
    }
}
