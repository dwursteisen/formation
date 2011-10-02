package my.test;

import my.test.implementation.MonImplementationDeBase;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 02/10/11
 * Time: 23:18
 * To change this template use File | Settings | File Templates.
 */
public class MonProgrammeTest {
    @Test
    public void testConstructionAnnuaire() throws Exception {
        MonAnnuaire instance = MonProgramme.constructionAnnuaire();
        assertNotNull(instance);
        assertTrue(MonImplementationDeBase.class.isInstance(instance));
    }
}
