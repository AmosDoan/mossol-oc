package net.mossol.oc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
public class CryptoTest {

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void testCrypto() {
        String raw = "test";

        String encoded = bCryptPasswordEncoder.encode(raw);
        System.out.println(encoded);
    }
}
