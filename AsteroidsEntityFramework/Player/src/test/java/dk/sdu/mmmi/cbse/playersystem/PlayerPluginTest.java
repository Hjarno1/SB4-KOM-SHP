package dk.sdu.mmmi.cbse.playersystem;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.player.Player;
import org.junit.jupiter.api.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PlayerPluginTest {
    private static GameData mockedGameData;
    private static World mockedWorld;
    private static PlayerPlugin player;

    @BeforeAll
    static void setUp()  { //executes before all tests
        mockedGameData = mock(GameData.class);
        mockedWorld = mock(World.class);
        player = new PlayerPlugin();
    }

    @Test
    @Order(1) //executes first
    void addPlayerToWorld() {
        player.start(mockedGameData, mockedWorld);
        verify(mockedWorld).addEntity(any(Player.class));
    }

    @Test
    @Order(2) //executes second
    void removePlayerFromWorld() {
        player.stop(mockedGameData, mockedWorld);
        verify(mockedWorld).removeEntity(any(Player.class));
    }
}