package dev.shroysha.control.computer.app.client;

import dev.shroysha.control.computer.app.client.view.ComputerControlClientFrame;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.*;


@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx =
                new SpringApplicationBuilder(App.class)
                        .headless(false)
                        .run(args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> SwingUtilities.invokeLater(() -> ctx.getBean(ComputerControlClientFrame.class).setVisible(true));
    }
}
