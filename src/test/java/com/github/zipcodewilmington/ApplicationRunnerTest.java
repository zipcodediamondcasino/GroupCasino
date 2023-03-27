package com.github.zipcodewilmington;

import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

/**
 * Created by leon on 7/21/2020.
 */
public class ApplicationRunnerTest {
    @Test
    public void test() { // TODO - replace boiler-plate logic with business logic
        // given
        Casino c = new Casino();
        ByteArrayInputStream in = new ByteArrayInputStream("login\nroot\nadmin\ncheck-funds\nadd-funds\n50\ndrink\nlogout".getBytes());
        IOConsole con = new IOConsole(AnsiColor.BLUE, in, System.out);
        c.setConsole(con);

        c.run();

        Assert.assertNotNull(c);
    }

    @Test(expected = RuntimeException.class)
    public void testCreateAccount() {

        Casino c = new Casino();
        ByteArrayInputStream in = new ByteArrayInputStream("create-account\ntestUser\ntestPassword\nselect-game\nerror".getBytes());
        IOConsole con = new IOConsole(AnsiColor.BLUE, in, System.out);
        c.setConsole(con);

        c.run();
    }
}
