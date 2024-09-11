package aws.elb.elb.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/value")
    public ResponseEntity<String> getCacheValue(@RequestParam String key) {
        String value = redisTemplate.opsForValue().get(key);
        if (value == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Key not found");
        }
        return ResponseEntity.ok(value);
    }

    @PutMapping("/value")
    public ResponseEntity<String> putCacheValue(@RequestBody Map<String, String> pair) {
        redisTemplate.opsForValue().set(pair.get("key"), pair.get("value"));
        return ResponseEntity.ok("Value set successfully");
    }
}
