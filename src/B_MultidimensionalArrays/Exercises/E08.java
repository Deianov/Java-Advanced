//08. The Heigan Dance
package B_MultidimensionalArrays.Exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class E08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double damage = Double.parseDouble(scanner.nextLine());
        double heigan = 3000000;
        Deque<Integer> cloudEffect = new ArrayDeque<>();

        Player player = new Player(damage);
        int spellRow = 0;
        int spellCol = 0;
        int spellDamage = 0;

        while (heigan > 0 && !player.isKilled()) {

            // Player attack Heigan
            heigan = heigan - player.getDamage();

            // Second cloud effect
            if (!cloudEffect.isEmpty()) {
                spellRow = cloudEffect.pop();
                spellCol = cloudEffect.pop();
                player.spell(spellRow, spellCol);
                if(!player.move()) { player.hit(3500);}
            }

            // Heigan is defeated.
            if (heigan <= 0) { break; }

            // Player is defeated.
            if (player.isKilled()) { break;}

            // Spell
            String[] spell = scanner.nextLine().split("\\s+");
            String spellName = spell[0];
            spellRow = Integer.parseInt(spell[1]);
            spellCol = Integer.parseInt(spell[2]);
            spellDamage = spellName.equals("Cloud") ? 3500 : 6000;

            player.spell(spellRow, spellCol);
            if(!player.move()) { player.hit(spellDamage); }

            // save for next turn
            if (spellName.equals("Cloud")) {
                if (spellRow > -1 && spellRow < 15 && spellCol > -1 && spellCol < 15) {
                    cloudEffect.offer(spellRow);
                    cloudEffect.offer(spellCol);
                }
            }
        }

        if (heigan <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.println(String.format("Heigan: %.2f", heigan));
        }

        if (player.isKilled()) {
            System.out.println(String.format("Player: Killed by %s", player.getLastHit()));
        } else {
            System.out.println(String.format("Player: %d", player.getPoints()));
        }
        System.out.println(String.format("Final position: %d, %d", player.getRow(), player.getCol()));
    }
}

class Player {
    private int row;
    private int col;
    private int rows = 15;
    private int cols = 15;
    private int points;
    private double damage;
    private int[][] matrix;
    private String lastHit;

    Player(double damage) {
        this.row = 7;
        this.col = 7;
        this.points = 18500;
        this.damage = damage;
        this.matrix = new int[this.rows][this.cols];
        this.lastHit = "";
    }

    int getRow() { return row; }
    int getCol() { return col; }
    int getPoints() { return points; }
    double getDamage() { return damage; }
    String getLastHit() { return lastHit; }

    void spell(int spellRow, int spellCol) {

        // clear matrix
        for (int r = 0; r < this.rows ; r++) {
            for (int c = 0; c < this.cols ; c++) {
                this.matrix[r][c] = 0;
            }
        }

        // add spell
        for (int r = spellRow - 1; r <= spellRow + 1 ; r++) {
            for (int c = spellCol - 1; c <= spellCol + 1; c++) {
                if (r >= 0 && r < this.rows && c >= 0 && c < this.cols) {
                    this.matrix[r][c] = 1;
                }
            }
        }
    }

    void hit (int dmg) {
        this.points -= dmg;
        this.lastHit = dmg == 3500 ? "Plague Cloud" : "Eruption";
    }

    boolean isKilled() {
        return this.points <= 0;
    }

    boolean move() {
        int r = this.row;
        int c = this.col;
        // save
        if (this.matrix[r][c] == 0) {
            return true;
        }
        // up
        r = this.row - 1;
        c = this.col;
        if (r >= 0 && this.matrix[r][c] == 0) {
            this.row = r;
            return true;
        }
        // right
        r = this.row;
        c = this.col + 1;
        if (c < this.cols && this.matrix[r][c] == 0) {
            this.col = c;
            return true;
        }
        // down
        r = this.row + 1;
        c = this.col;
        if (r < this.rows && this.matrix[r][c] == 0) {
            this.row = r;
            return true;
        }
        // left
        r = this.row;
        c = this.col - 1;
        if (c >= 0 && this.matrix[r][c] == 0) {
            this.col = c;
            return true;
        }
        return false;
    }
}
