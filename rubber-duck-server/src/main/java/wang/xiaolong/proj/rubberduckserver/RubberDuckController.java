package wang.xiaolong.proj.rubberduckserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@RestController
public class RubberDuckController {
    @Value("${rubber.duck.ip: unspecified}")
    private String serverAddress;

    @GetMapping("/echo/{msg}")
    public Map<String, Object> echo(@PathVariable String msg, HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("server_host", serverAddress);
        response.addHeader("client_host", request.getRemoteAddr());
        response.addHeader("msg", msg);
        return Map.of("server", serverAddress, "client", request.getRemoteAddr(), "msg", msg);
    }
}
