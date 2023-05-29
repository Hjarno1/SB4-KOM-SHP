import dk.sdu.mmmi.cbse.collisionsystem.CollisionDetector;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module GameCollision {
    requires Common;
    provides IPostEntityProcessingService with CollisionDetector;
}