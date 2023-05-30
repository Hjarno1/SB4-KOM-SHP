package dk.sdu.mmmi.cbse.enemysystem;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import org.junit.jupiter.api.*;
import dk.sdu.mmmi.cbse.common.enemy.Enemy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EnemyPluginTest {
    private static GameData mockedGameData;
    private static World mockedWorld;
    private static EnemyPlugin enemy;

    @BeforeAll
    static void setUp()  { //executes before all tests
        mockedGameData = mock(GameData.class);
        mockedWorld = mock(World.class);
        enemy = new EnemyPlugin();
    }

    @Test
    @Order(1) //executes first
    void addPLayerToWorld() {
        enemy.start(mockedGameData, mockedWorld);
        verify(mockedWorld).addEntity(any(Enemy.class));
    }

    @Test
    @Order(2) //executes second
    void removePlayerFromWorld() {
        enemy.stop(mockedGameData, mockedWorld);
        verify(mockedWorld).removeEntity(any(Enemy.class));
    }
}