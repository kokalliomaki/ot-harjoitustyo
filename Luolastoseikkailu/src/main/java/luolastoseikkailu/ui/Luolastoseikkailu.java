
package luolastoseikkailu.ui;

import java.util.Scanner;
import luolastoseikkailu.logiikka.Map;
import luolastoseikkailu.logiikka.Monster;
import luolastoseikkailu.logiikka.Orc;
import luolastoseikkailu.logiikka.Player;


public class Luolastoseikkailu {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String tester = "####################"
                        + "#..########.....####"
                        + "#..####.........####"
                        + "#.#####.######.#####"
                        + "#.#####.######...###"
                        + "#.#####.########.###"
                        + "#.###....######....#"
                        + "#........######....#"
                        + "#####....######....#"
                        + "####################";
        int height = 10;
        int width = 20;
        char[][] testmap = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                testmap[i][j] = tester.charAt(i * width + j);
            }
        }
        Map test = new Map(testmap, 1);
        Player player = new Player("Timo", 1, 1, test);
        Monster orc = new Orc(2, 2, test);
        Monster orc2 = new Orc(13, 1, test);
        System.out.print(test);
        while (true) {
            System.out.print("\nKomento: ");
            char c = reader.next().charAt(0);
            switch (c) {
                case '1':
                    if (!player.move(-1, 1)) {
                    continue;
                    }
                    break;
                case '2':
                    if (!player.move(0, 1)) {
                    continue;
                    }
                    break;
                case '3':
                    if (!player.move(1, 1)) {
                    continue;
                    }
                    break;
                case '4':
                    if (!player.move(-1, 0)) {
                    continue;
                    }
                    break;
                case '6':
                    if (!player.move(1, 0)) {
                    continue;
                    }
                    break;
                case '7':
                    if (!player.move(-1, -1)) {
                    continue;
                    }
                    break;
                case '8':
                    if (!player.move(0, -1)) {
                    continue;
                    }
                    break;
                case '9':
                    if (!player.move(1, -1)) {
                    continue;
                    }
                    break;
                case 'q':
                    return;
                default:
                    continue;
            }
            test.moveMonsters();
            System.out.print(test);
        }
    }
}
