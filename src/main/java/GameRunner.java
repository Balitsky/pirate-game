import core.Core;
import model.Location;

public class GameRunner {
    public static void run(Core core){
        Location current = core.getHome();
        while (true){
            current = current.move();
        }
    }
}
