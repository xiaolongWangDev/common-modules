package wang.xiaolong.proj.rubberduckserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;


@RestController
public class RubberDuckController {
    private String serverAddress;

    public RubberDuckController() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            this.serverAddress = address.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/echo/{msg}")
    public String echo(@PathVariable String msg, HttpServletResponse response) {
        response.addHeader("server_host", serverAddress);
        return serverAddress + " echos:" + msg;
    }
}
