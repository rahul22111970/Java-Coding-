import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
public class EncryptController {

    @GetMapping("/encrypt/{input}")
    public String encrypt(@PathVariable String input) throws NoSuchAlgorithmException {
        return Sha256Encryptor.encrypt(input);
    }
}
