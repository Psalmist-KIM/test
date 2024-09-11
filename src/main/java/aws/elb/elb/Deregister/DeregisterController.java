package aws.elb.elb.Deregister;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deregister")
public class DeregisterController {
    private final Logger logger = LoggerFactory.getLogger(DeregisterController.class);

    @GetMapping("/check")
    public String check(@RequestParam(name = "sleep", defaultValue = "1000") String sleep) throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread.sleep(Long.parseLong(sleep));

        long end = System.currentTimeMillis();

        long elapsed = end - start;

        return "elapsed time : " + elapsed + " ms";
    }
}
