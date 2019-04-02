
import luolastoseikkailu.domain.Map;
import luolastoseikkailu.domain.Player;
import luolastoseikkailu.domain.MapSquare;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    
    Map testMap;
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        String tester = "####################" +
                        "#..########.....####" +
                        "#..####.........####" +
                        "#.#####.######.#####" +
                        "#.#####.######...###" +
                        "#.#####.########.###" +
                        "#.###....######....#" +
                        "#........######....#" +
                        "#####....######....#" +
                        "####################";
        
        
        
        char[][] test = new char[10][20];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                test[i][j] = tester.charAt(i*20 + j);
            }            
        }
        this.testMap = new Map(test, 1);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void playerMovesToFreeSpace() {
        Player player = new Player("", 1, 1, testMap);
        assertTrue(player.move(1, 0));
    }
    
    @Test
    public void playerHitsWall() {
        Player player = new Player("", 1, 1, testMap);
        assertTrue(!player.move(-1, 0));
    }
    
    @Test
    public void correctSymbol() {
        Player player = new Player("", 1, 1, testMap);
        assertEquals("@", player.getSymbol());
    }


}
