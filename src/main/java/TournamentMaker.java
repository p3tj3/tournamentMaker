import java.util.List;
import java.util.Scanner;

/**
 * @author petruz
 * @email 8olwerk@gmail.com
 * @version 1.1.6
 */

public class TournamentMaker {

    /**
     * Starts a loop that can only be exited by putting in "exit".
     *
     * Asks for an even positive number of participants. Entering other input
     * results in repetition.
     *
     * If an even number of participants is entered, the class TournamentOptions generates
     * several possible tournament configurations. User has to select a configuration by
     * putting in a valid digit. If the input is invalid the loop resumes and the user is
     * asked to enter the positive even number of participants again.
     */

    public static void main(String[] args) {
            Scanner sc;
            while (true) {
                System.out.println("\nEnter an even positive number of tournament participants. 250 maximally.\nEnter 'exit' to exit.");
                sc = new Scanner(System.in);
                if (sc.hasNext("exit")){
                    break;
                }
                try {
                    int number = sc.nextInt();
                    if ((number & 1) == 1 || number < 1) {
                        System.out.println("\nEnter an even number of participants\n");
                    } else if (number > 250) {
                        System.out.println("\nMaximum number of participants (250) exceeded.\n");
                    } else {
                        TournamentOptions Options = new TournamentOptions(number);
                        System.out.println(Options);
                        Scanner sc2 = new Scanner(System.in);
                        int optionNumber;
                        System.out.println("\nWhat option do you want to implement?");
                        try {
                            optionNumber = sc2.nextInt() - 1;
                            List<Integer> options = Options.allOptions.get(optionNumber);
                            if ((options.get(0) & (options.get(0) - 1)) == 0 && options.size() == 4) {
                                    System.out.println("\nCreating perfect tournament.");
                                    Tournament tournament = new perfectTournament(options.get(0), options.get(1));
                                    System.out.print(tournament);
                            }
                            else if (options.size() == 4) {
                                System.out.println("\nCreating an even tournament.");
                                Tournament tournament = new evenTournament(options.get(0), options.get(1));
                                System.out.print(tournament);
                            }
                            else if (!(options.get(2) == 1))  {
                                System.out.println("\nCreating an tournament with two uneven pools.");
                                Tournament tournament = new unevenTournament(options.get(0), options.get(1), options.get(2));
                                System.out.print(tournament);
                            }
                            else {
                                System.out.println("\nINVALID OPTION\n");
                            }
                        } catch(Exception e){
                            System.out.println("\nThis is not a valid option\n");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("\nThis is not an even number.");
                }
            }
    }
}