package ru.vsu.cs.util.steblev_d_v;

import ru.vsu.cs.util.steblev_d_v.cards.*;

import java.util.*;

public class BoardReader {

    private static final String CARD_TOKEN = "card";
    private static final String CHANCE_CARD_TOKEN = "chance";
    private static final String CHARGE_CARD_TOKEN = "charge";
    private static final String COMPANY_CARD_TOKEN = "comp";
    private static final String JACKPOT_CARD_TOKEN = "jac";
    private static final String JAIL_CARD_TOKEN = "jail";
    private static final String TRAVEL_CARD_TOKEN = "trav";

    public static Board read(String fileContent) throws BoardReaderException {
        Board board = new Board();

        int lineInd = 0;
        Scanner scanner = new Scanner(fileContent);
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            ArrayList<String> wordsInLine = new ArrayList<String>(Arrays.asList(line.split("\\s+")));
            if (wordsInLine.isEmpty()) {
                continue;
            }

            final String token = wordsInLine.get(0);
            wordsInLine.remove(0);

            ++lineInd;
            switch (token) {
                case CARD_TOKEN -> board.getBoard().add(parseCard(wordsInLine, lineInd));
                case CHANCE_CARD_TOKEN -> board.getBoard().add(parseChanceCard(wordsInLine, lineInd));
                case CHARGE_CARD_TOKEN -> board.getBoard().add(parseChargeCard(wordsInLine, lineInd));
                case COMPANY_CARD_TOKEN -> board.getBoard().add(parseCompanyCard(wordsInLine, lineInd));
                case JACKPOT_CARD_TOKEN -> board.getBoard().add(parseJackpotCard(wordsInLine, lineInd));
                case JAIL_CARD_TOKEN -> board.getBoard().add(parseJailCard(wordsInLine, lineInd));
                case TRAVEL_CARD_TOKEN -> board.getBoard().add(parseTravelCard(wordsInLine, lineInd));
                default -> {
                }
            }
        }
        return board;
    }

    protected static Card parseCard(final ArrayList<String> wordsInLineWithoutToken, int lineInd) throws BoardReaderException {
        try {
            return new Card(wordsInLineWithoutToken.get(0),
                    lineInd - 1,
                    GraphicsUtils.convertColorNameToConsole(wordsInLineWithoutToken.get(1), getBoolean(wordsInLineWithoutToken.get(2))));

        } catch (NumberFormatException e) {
            throw new BoardReaderException("Failed to parse String value.", lineInd);

        } catch (IndexOutOfBoundsException e) {
            throw new BoardReaderException("Too few card arguments.", lineInd);
        }
    }

    protected static Card parseChanceCard(final ArrayList<String> wordsInLineWithoutToken, int lineInd) throws BoardReaderException {
        try {
            return new ChanceCard(lineInd - 1,
                    GraphicsUtils.convertColorNameToConsole(wordsInLineWithoutToken.get(0), getBoolean(wordsInLineWithoutToken.get(1))));

        } catch (NumberFormatException e) {
            throw new BoardReaderException("Failed to parse String value.", lineInd);

        } catch (IndexOutOfBoundsException e) {
            throw new BoardReaderException("Too few card arguments.", lineInd);
        }
    }

    protected static Card parseChargeCard(final ArrayList<String> wordsInLineWithoutToken, int lineInd) throws BoardReaderException {
        try {
            return new ChargeCard(lineInd - 1,
                    GraphicsUtils.convertColorNameToConsole(wordsInLineWithoutToken.get(0), getBoolean(wordsInLineWithoutToken.get(1))));

        } catch (NumberFormatException e) {
            throw new BoardReaderException("Failed to parse String value.", lineInd);

        } catch (IndexOutOfBoundsException e) {
            throw new BoardReaderException("Too few card arguments.", lineInd);
        }
    }

    protected static Card parseCompanyCard(final ArrayList<String> wordsInLineWithoutToken, int lineInd) throws BoardReaderException {
        try {
            return new CompanyCard(
                    wordsInLineWithoutToken.get(0),
                    lineInd - 1,
                    Integer.parseInt(wordsInLineWithoutToken.get(1)),
                    Integer.parseInt(wordsInLineWithoutToken.get(2)),
                    GraphicsUtils.convertColorNameToConsole(wordsInLineWithoutToken.get(3), getBoolean(wordsInLineWithoutToken.get(4))));


        } catch (NumberFormatException e) {
            throw new BoardReaderException("Failed to parse String value.", lineInd);

        } catch (IndexOutOfBoundsException e) {
            throw new BoardReaderException("Too few card arguments.", lineInd);
        }
    }

    protected static Card parseJackpotCard(final ArrayList<String> wordsInLineWithoutToken, int lineInd) throws BoardReaderException {
        try {
            return new JackpotCard(lineInd - 1,
                    GraphicsUtils.convertColorNameToConsole(wordsInLineWithoutToken.get(0), getBoolean(wordsInLineWithoutToken.get(1))));

        } catch (NumberFormatException e) {
            throw new BoardReaderException("Failed to parse String value.", lineInd);

        } catch (IndexOutOfBoundsException e) {
            throw new BoardReaderException("Too few card arguments.", lineInd);
        }
    }

    protected static Card parseJailCard(final ArrayList<String> wordsInLineWithoutToken, int lineInd) throws BoardReaderException {
        try {
            return new JailCard(lineInd - 1, 0,
                    GraphicsUtils.convertColorNameToConsole(wordsInLineWithoutToken.get(0), getBoolean(wordsInLineWithoutToken.get(1))));

        } catch (NumberFormatException e) {
            throw new BoardReaderException("Failed to parse String value.", lineInd);

        } catch (IndexOutOfBoundsException e) {
            throw new BoardReaderException("Too few card arguments.", lineInd);
        }
    }

    protected static Card parseTravelCard(final ArrayList<String> wordsInLineWithoutToken, int lineInd) throws BoardReaderException {
        try {
            return new TravelCard(lineInd - 1,
                    GraphicsUtils.convertColorNameToConsole(wordsInLineWithoutToken.get(0),getBoolean(wordsInLineWithoutToken.get(1))));

        } catch (NumberFormatException e) {
            throw new BoardReaderException("Failed to parse String value.", lineInd);

        } catch (IndexOutOfBoundsException e) {
            throw new BoardReaderException("Too few card arguments.", lineInd);
        }
    }

    public static boolean getBoolean(String value) {
        return !value.equals("0");
    }
}
