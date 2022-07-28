package wang.xiaolong.proj.rubberduckserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;


@RestController
public class RubberDuckController {
    private final String serverAddress;

    public RubberDuckController() throws UnknownHostException {
        this.serverAddress = InetAddress.getLocalHost().getHostName();
    }

    @GetMapping("/echo/{msg}")
    public Map<String, Object> echo(@PathVariable String msg, HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("server_host", serverAddress);
        response.addHeader("client_host", request.getRemoteAddr());
        response.addHeader("msg", msg);

        return Map.of("server", serverAddress, "client", request.getRemoteAddr(), "msg", msg);
    }
}
