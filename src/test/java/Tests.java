import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


class Tests {

    /**
     * <p>Some of test are not flexible in hindsight. In case you want to change the output, you could opt for putting the current
     * output in a seperate test method inside the source code and to remove this after version completion. This proces can be
     * repeated.</p>
     */
    @Test
    void factor28() {
        assertEquals(Arrays.asList(2, 2, 7), TournamentOptions.getPrimefactors(28));
    }

    @Test
    void manualGetPrimefactorsTest() {
        for (int i = 3; i < 1000; i++) {
            Integer product = 1;
            for (int num : TournamentOptions.getPrimefactors(i)) {
                product *= num;
            }
            assertEquals(product, i);
        }
    }

    @Test
    void OptionsTest1_10teams() {
        int number = 10;
        List<List<Integer>> output = Arrays.asList(
                Arrays.asList(1, 10, 0, 3),
                Arrays.asList(5, 2, 3, 3),
                Arrays.asList(0, 5, 5, 1, 3),
                Arrays.asList(2, 2, 3, 1, 1));

        TournamentOptions Options = new TournamentOptions(number);
        assertTrue(output.equals(Options.allOptions));
    }


    /**
     * If the number of participants is equal to a number of 2, the code only presents the even options. It throws an
     * exception upon entering uneven pool options. This has been tested manually. Here the toSting() output is tested.
     */
    @Test
    void OptionsTest2_2teams() {
        int number = 2;
        TournamentOptions Options = new TournamentOptions(number);
        String output = "option 1: 1 Pools of size 2. Possible number of post-pool-rounds: 0";
        assertFalse(output.equals(Options.toString()));
    }

    @Test
    void OptionsTest3_4teams() {
        int number = 4;
        List<List<Integer>> output = Arrays.asList(
                Arrays.asList(1, 4, 0, 1),
                Arrays.asList(2, 2, 1, 1));

        TournamentOptions Options = new TournamentOptions(number);
        assertTrue(output.equals(Options.allOptions));
    }



    @Test
    void OptionsTest4_6() {
        int number = 6;
        List<List<Integer>> output = Arrays.asList(
                Arrays.asList(1, 6, 0, 2),
                Arrays.asList(3, 2, 2, 2),
                Arrays.asList(0, 3, 3, 1, 2));
        TournamentOptions Options = new TournamentOptions(number);
        assertTrue(output.equals(Options.allOptions));
    }

    @Test
    void matchtest_participants_4_option_1() {

        String matchInfo = "\nTOURNAMENT SCHEMA\n" +
                "\nPOOL A\n" +
                "ROUND A1\n" +
                "match A.1.1 - A1 vs A2\n\n" +
                "POOL B\n" +
                "ROUND B1\n" +
                "match B.1.1 - B1 vs B2\n\n" +
                "POOL C\n" +
                "ROUND C1\n" +
                "match C.1.1 - C1 vs C2\n\n" +
                "POOL D\n" +
                "ROUND D1\n" +
                "match D.1.1 - D1 vs D2\n";

        Tournament tournament = new perfectTournament(4, 2);
        assertTrue(tournament.toString().equals(matchInfo));
    }

    @Test
    void OptionsTest7_250() {
        int number = 250;
        List<List<Integer>> output = Arrays.asList(
                Arrays.asList(1, 250, 0, 7), Arrays.asList(5, 50, 3, 7), Arrays.asList(25, 10, 5, 7), Arrays.asList(125, 2, 7, 7),
                Arrays.asList(0, 125, 125, 1, 7), Arrays.asList(4, 42, 41, 2, 7), Arrays.asList(5, 36, 35, 3, 7), Arrays.asList(7, 28, 27, 3, 7),
                Arrays.asList(12, 18, 17, 4, 7), Arrays.asList(16, 14, 13, 4, 7), Arrays.asList(19, 12, 11, 5, 7), Arrays.asList(40, 6, 5, 6, 7),
                Arrays.asList(61, 4, 3, 6, 7), Arrays.asList(2, 62, 63, 1, 6), Arrays.asList(29, 8, 9, 5, 7), Arrays.asList(60, 4, 5, 6, 7),
                Arrays.asList(122, 2, 3, 7, 7));

        TournamentOptions Options = new TournamentOptions(number);
        assertTrue(output.equals(Options.allOptions));
    }


    @Test
    void OptionsTest7_248() {

        int number = 248;

        List<List<Integer>> output = Arrays.asList(
                Arrays.asList(1, 248, 0, 7),
                Arrays.asList(2, 124, 1, 7),
                Arrays.asList(4, 62, 2, 7),
                Arrays.asList(31, 8, 5, 7),
                Arrays.asList(62, 4, 6, 7),
                Arrays.asList(124, 2, 7, 7),
                Arrays.asList(3, 50, 49, 2, 7),
                Arrays.asList(23, 10, 9, 5, 7),
                Arrays.asList(39, 6, 7, 6, 7),
                Arrays.asList(121, 2, 3, 7, 7)
        );

        TournamentOptions Options = new TournamentOptions(number);
        assertTrue(output.equals(Options.allOptions));
    }

    @Test
    void matchtest_participants_8_option_3() {

        String matchInfo = "\nTOURNAMENT SCHEMA\n" +
                "\nPOOL A\n" +
                "ROUND A1\n" +
                "match A.1.1 - A1 vs A2\n\n" +
                "POOL B\n" +
                "ROUND B1\n" +
                "match B.1.1 - B1 vs B2\n\n" +
                "POOL C\n" +
                "ROUND C1\n" +
                "match C.1.1 - C1 vs C2\n\n" +
                "POOL D\n" +
                "ROUND D1\n" +
                "match D.1.1 - D1 vs D2\n";

        Tournament tournament = new perfectTournament(4, 2);
        assertTrue(tournament.toString().equals(matchInfo));
    }

    @Test
    void matchtest_participants_8_option_1() {

        String matchInfo = "\nTOURNAMENT SCHEMA\n\n" +
                "POOL A\n" +
                "ROUND A1\n" +
                "match A.1.1 - A1 vs A2\n" +
                "match A.1.2 - A3 vs A5\n" +
                "match A.1.3 - A4 vs A6\n" +
                "match A.1.4 - A8 vs A7\n" +
                "ROUND A2\n" +
                "match A.2.1 - A1 vs A3\n" +
                "match A.2.2 - A4 vs A2\n" +
                "match A.2.3 - A8 vs A5\n" +
                "match A.2.4 - A7 vs A6\n" +
                "ROUND A3\n" +
                "match A.3.1 - A1 vs A4\n" +
                "match A.3.2 - A8 vs A3\n" +
                "match A.3.3 - A7 vs A2\n" +
                "match A.3.4 - A6 vs A5\n" +
                "ROUND A4\n" +
                "match A.4.1 - A1 vs A8\n" +
                "match A.4.2 - A7 vs A4\n" +
                "match A.4.3 - A6 vs A3\n" +
                "match A.4.4 - A5 vs A2\n" +
                "ROUND A5\n" +
                "match A.5.1 - A1 vs A7\n" +
                "match A.5.2 - A6 vs A8\n" +
                "match A.5.3 - A5 vs A4\n" +
                "match A.5.4 - A2 vs A3\n" +
                "ROUND A6\n" +
                "match A.6.1 - A1 vs A6\n" +
                "match A.6.2 - A5 vs A7\n" +
                "match A.6.3 - A2 vs A8\n" +
                "match A.6.4 - A3 vs A4\n" +
                "ROUND A7\n" +
                "match A.7.1 - A1 vs A5\n" +
                "match A.7.2 - A2 vs A6\n" +
                "match A.7.3 - A3 vs A7\n" +
                "match A.7.4 - A4 vs A8\n";

        Tournament tournament = new perfectTournament(1, 8);
        assertTrue(tournament.toString().equals(matchInfo));
    }

    @Test
    void matchtest_participants_6_option_2() {

        String matchInfo = "\nTOURNAMENT SCHEMA\n\n" +
                "POOL A\n" +
                "ROUND A1\n" +
                "match A.1.1 - A1 vs A2\n\n" +
                "POOL B\n" +
                "ROUND B1\n" +
                "match B.1.1 - B1 vs B2\n\n" +
                "POOL C\n" +
                "ROUND C1\n" +
                "match C.1.1 - C1 vs C2\n";

        Tournament tournament = new evenTournament(3, 2);
        assertTrue(tournament.toString().equals(matchInfo));
    }

    @Test
    void matchtest_participants_12_5() {

        String matchInfo = "\nTOURNAMENT SCHEMA\n\n" + "POOL A\n" +
                "ROUND A1\n" +
                "match A.1.1 - A1 vs A2\n" +
                "\n" +
                "POOL B\n" +
                "ROUND B1\n" +
                "match B.1.1 - B1 vs B2\n" +
                "\n" +
                "POOL C\n" +
                "ROUND C1\n" +
                "match C.1.1 - C1 vs C2\n" +
                "\n" +
                "POOL D\n" +
                "ROUND D1\n" +
                "match E.D.1.1 - D1 vs E1\n" +
                "match D.1.2 - D3 vs D2\n" +
                "\n" +
                "POOL E\n" +
                "ROUND E1\n" +
                "match D.E.1.1 - E1 vs D1\n" +
                "match E.1.2 - E3 vs E2\n";

        Tournament tournament = new unevenTournament(3, 2, 3);
        assertTrue(tournament.toString().equals(matchInfo));
    }

    @Test
    void OptionsTest_participants_12() {

        int number = 6;

        List<List<Integer>> options = Arrays.asList(
                Arrays.asList(1, 6, 0, 2),
                Arrays.asList(3, 2, 2, 2),
                Arrays.asList(0, 3, 3, 1, 2)
        );

        TournamentOptions Options = new TournamentOptions(number);
        assertTrue(options.equals(Options.allOptions));
    }

    @Test
    void OptionsTest_participants_10() {

        int number = 10;

        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1, 10, 0, 3),
                Arrays.asList(5, 2, 3, 3),
                Arrays.asList(0, 5, 5, 1, 3),
                Arrays.asList(2, 2, 3, 1, 1)
        );

        TournamentOptions options = new TournamentOptions(number);
        assertTrue(list.equals(options.allOptions));
    }

    @Test
    void matchtest_participants_10_4() {

        String matchInfo = "\nTOURNAMENT SCHEMA\n\n" +
                "POOL A\n" +
                "ROUND A1\n" +
                "match A.1.1 - A1 vs A2\n\n" +
                "POOL B\n" +
                "ROUND B1\n" +
                "match B.1.1 - B1 vs B2\n\n" +
                "POOL C\n" +
                "ROUND C1\n" +
                "match D.C.1.1 - C1 vs D1\n" +
                "match C.1.2 - C3 vs C2\n\n" +
                "POOL D\n" +
                "ROUND D1\n" +
                "match C.D.1.1 - D1 vs C1\n" +
                "match D.1.2 - D3 vs D2\n";

        Tournament tournament = new unevenTournament(2, 2, 3);
        assertTrue(tournament.toString().equals(matchInfo));
    }

    @Test
    void OptionsTest_participants_6() {

        int number = 6;

        List<List<Integer>> options = Arrays.asList(
                Arrays.asList(1, 6, 0, 2),
                Arrays.asList(3, 2, 2, 2),
                Arrays.asList(0, 3, 3, 1, 2)
        );

        TournamentOptions Options = new TournamentOptions(number);
        assertTrue(options.equals(Options.allOptions));
    }

    @Test
    void matchtest_participants_6_option_3() {

        String matchInfo = "\nTOURNAMENT SCHEMA\n\n" + "POOL A\n" +
                "ROUND A1\n" +
                "match B.A.1.1 - A1 vs B1\n" +
                "match A.1.2 - A3 vs A2\n" +
                "ROUND A2\n" +
                "match A.2.1 - A1 vs A3\n" +
                "match B.A.2.2 - A2 vs B2\n" +
                "\n" +
                "POOL B\n" +
                "ROUND B1\n" +
                "match A.B.1.1 - B1 vs A1\n" +
                "match B.1.2 - B3 vs B2\n" +
                "ROUND B2\n" +
                "match B.2.1 - B1 vs B3\n" +
                "match A.B.2.2 - B2 vs A2\n";

        Tournament tournament = new unevenTournament(0, 3, 3);
        assertTrue(tournament.toString().equals(matchInfo));
    }

    @Test
    void matchtest_participants_2_option_1() {

        String matchInfo = "\nTOURNAMENT SCHEMA\n\n" + "POOL A\n" +
                "ROUND A1\n" +
                "match A.1.1 - A1 vs A2\n";

        Tournament tournament = new perfectTournament(1,2);
        assertTrue(tournament.toString().equals(matchInfo));
    }
}