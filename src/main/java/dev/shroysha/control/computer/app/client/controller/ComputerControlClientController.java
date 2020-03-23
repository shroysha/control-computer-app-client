package dev.shroysha.control.computer.app.client.controller;

import dev.shroysha.control.computer.ejb.ControlComputerEntityScanTag;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class ComputerControlClientController {

    public static final WebClient WEB_CLIENT = WebClient.create(ControlComputerEntityScanTag.BASE_URL);

    public static void doSomething() {
        WEB_CLIENT.post()
                .uri(ControlComputerEntityScanTag.POPUP_TEXT)
                .accept(MediaType.TEXT_PLAIN)
                .retrieve();
    }

}
