import java.io.IOException;
/**
 * A class containing a main method to simulate rounds of work in a Workshop.
 * Given a specified number of maker elves, builder elves, and toys,
 * keep working until the number of requested toys is made.
 */
public class ToySim {

    public static void main(String[] args) throws Exception {
        int nMakers = 2;
        int nBuilders = 2;
        int nToys = 14;

        if (args.length > 0) {
            try {
                nMakers = Integer.parseInt(args[0]);
            } catch (NumberFormatException nfe) {
                System.out.println("Could not use args[0] as it was not an integer: " + args[0]);
                System.out.printf("Defaulting to %d maker elves.\n", nMakers);
            }
        }
        if (args.length > 1) {
            try {
                nBuilders = Integer.parseInt(args[1]);
            } catch (NumberFormatException nfe) {
                System.out.println("Could not use args[1] as it was not an integer: " + args[1]);
                System.out.printf("Defaulting to %d builder elves.\n", nBuilders);
            }
        }
        if (args.length > 2) {
            try {
                nToys = Integer.parseInt(args[2]);
            } catch (NumberFormatException nfe) {
                System.out.println("Could not use args[2] as it was not an integer: " + args[2]);
                System.out.printf("Defaulting to %d toys to build.\n", nToys);
            }
        }

        Workshop workshop = new Workshop(nMakers, nBuilders);
        int nRounds = 0;
        while(true) {
            nRounds++;
            workshop.nextRound();
            if (workshop.buildCount() >= nToys) {
                break;
            }
        }

        System.out.printf("It took %d rounds to produce %d toys with %d leftover materials.\n", nRounds, workshop.buildCount(), workshop.materialCount());
    }
}
