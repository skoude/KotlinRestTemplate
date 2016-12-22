

import org.junit.Assert.assertNotEquals
import org.junit.Test
import utils.SystemParameters
import utils.SystemUtils


/**
 * Multiple system Utils tests..
 * @author Kari Skyttä
 */
class SystemUtilsTest {

    /**
     * example test for checking that SystemParameter are not null.
     */
    @Test fun readSystemParameters() {
        val systemparams: SystemParameters = SystemUtils.readSystemParameters()

        // test that the username is not empty.. We don't allow empyt usernames and passwords, even in development
        assertNotEquals("", systemparams.username)
        assertNotEquals("", systemparams.password)


    }
}