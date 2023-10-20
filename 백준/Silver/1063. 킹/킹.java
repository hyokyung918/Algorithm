import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        String stone = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        char rawKing = king.charAt(0);
        char rawStone = stone.charAt(0);
        int colKing = (int)king.charAt(1) - 48;
        int colStone = (int)stone.charAt(1) - 48;

        for (int i=0; i<n; i++) {
            String order = br.readLine();

            switch (order) {
                case "R":
                    if (rawKing == 'H') {
                        break;
                    } else {
                        rawKing++;
                    }

                    if (isEquals(rawKing, rawStone, colKing, colStone)) {
                        rawStone++;
                        if (rawStone > 'H') {
                            rawStone--;
                            rawKing--;
                        }
                    }
                    break;

                case "L":
                    if (rawKing == 'A') {
                        break;
                    } else {
                        rawKing--;
                    }

                    if (isEquals(rawKing, rawStone, colKing, colStone)) {
                        rawStone--;
                        if (rawStone < 'A') {
                            rawStone++;
                            rawKing++;
                        }
                    }
                    break;

                case "B":
                    if (colKing == 1) {
                        break;
                    } else {
                        colKing--;
                    }

                    if (isEquals(rawKing, rawStone, colKing, colStone)) {
                        colStone--;
                        if (colStone < 1) {
                            colKing++;
                            colStone++;
                        }
                    }
                    break;

                case "T":
                    if (colKing == 8) {
                        break;
                    } else {
                        colKing++;
                    }

                    if (isEquals(rawKing, rawStone, colKing, colStone)) {
                        colStone++;
                        if (colStone > 8) {
                            colKing--;
                            colStone--;
                        }
                    }
                    break;

                case "RT":
                    if (rawKing == 'H' || colKing == 8) {
                        break;
                    } else {
                        rawKing++;
                        colKing++;
                    }

                    if (isEquals(rawKing, rawStone, colKing, colStone)) {
                        rawStone++;
                        colStone++;
                        if (rawStone > 'H' || colStone > 8) {
                            rawKing--;
                            rawStone--;
                            colKing--;
                            colStone--;
                        }
                    }
                    break;

                case "LT":
                    if (rawKing == 'A' || colKing == 8) {
                        break;
                    } else {
                        rawKing--;
                        colKing++;
                    }

                    if (isEquals(rawKing, rawStone, colKing, colStone)) {
                        rawStone--;
                        colStone++;
                        if (rawStone < 'A' || colStone > 8) {
                            rawKing++;
                            rawStone++;
                            colKing--;
                            colStone--;
                        }
                    }
                    break;

                case "RB":
                    if (rawKing == 'H' || colKing == 1) {
                        break;
                    } else {
                        rawKing++;
                        colKing--;
                    }

                    if (isEquals(rawKing, rawStone, colKing, colStone)) {
                        rawStone++;
                        colStone--;
                        if (rawStone > 'H' || colStone < 1) {
                            rawKing--;
                            rawStone--;
                            colKing++;
                            colStone++;
                        }
                    }
                    break;

                case "LB":
                    if (rawKing == 'A' || colKing == 1) {
                        break;
                    } else {
                        rawKing--;
                        colKing--;
                    }

                    if (isEquals(rawKing, rawStone, colKing, colStone)) {
                        rawStone--;
                        colStone--;
                        if (rawStone < 'A' || colStone < 1) {
                            rawKing++;
                            rawStone++;
                            colKing++;
                            colStone++;
                        }
                    }
                    break;
            }
        }

        System.out.printf("%c%d\n", rawKing, colKing);
        System.out.printf("%c%d", rawStone, colStone);
    }

    public static boolean isEquals(char rawKing, char rawStone, int colKing, int colStone) {
        if (rawKing == rawStone) {
            if (colKing == colStone) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}