
package luolastoseikkailu.domain;

import java.util.Scanner;


public class Luolastoseikkailu {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
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
        
        
        
        char[][] testmap = new char[10][20];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                testmap[i][j] = tester.charAt(i*20 + j);
            }            
        }
        Map test = new Map(testmap, 1);
        Player player = new Player("Timo", 1, 1, test);
        System.out.print(test);
        while (true) {            
            System.out.print("\nKomento: ");
            char c = reader.next().charAt(0);
            switch (c) {
                case '1':
                    if (!player.move(-1, 1)) continue;
                    break;
                case '2':
                    if (!player.move(0, 1)) continue;
                    break;
                case '3':
                    if (!player.move(1, 1)) continue;
                    break;
                case '4':
                    if (!player.move(-1, 0)) continue;
                    break;
                case '6':
                    if (!player.move(1, 0)) continue;
                    break;
                case '7':
                    if (!player.move(-1, -1)) continue;
                    break;
                case '8':
                    if (!player.move(0, -1)) continue;
                    break;
                case '9':
                    if (!player.move(1, -1)) continue;
                    break;
                case 'q':
                    return;
            }
            System.out.print(test);
        }
    }
    
}
