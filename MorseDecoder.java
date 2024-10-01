class Tree {
    String charValue;
    Tree left;
    Tree right;

    public Tree(String charValue, Tree left, Tree right) {
        this.charValue = charValue;
        this.left = left;
        this.right = right;
    }
}

public class MorseDecoder {

    public static String morseToChar(Tree morseTree, String sequence, int i) {
        if (i == sequence.length()) {
            return morseTree.charValue;
        } else if (sequence.charAt(i) == '.') {
            return morseToChar(morseTree.left, sequence, i + 1);
        } else {
            return morseToChar(morseTree.right, sequence, i + 1);
        }
    }

    public static String decodeMorse(Tree morseTree, String str) {
        StringBuilder decoded = new StringBuilder();
        String[] sequences = str.split(" ");

        for (String sequence : sequences) {
            if (sequence.equals("/")) {
                decoded.append(" ");
            } else {
                decoded.append(morseToChar(morseTree, sequence, 0));
            }
        }
        return decoded.toString();
    }

    public static void main(String[] args) {
        Tree morseTree = new Tree("",
                new Tree("E",
                        new Tree("I",
                                new Tree("S",
                                        new Tree("H",
                                                new Tree("5", null, null),
                                                new Tree("4", null, null)),
                                        new Tree("V",
                                                new Tree("", null, null),
                                                new Tree("3", null, null))),
                                new Tree("U",
                                        new Tree("F",
                                                new Tree("", null, null),
                                                new Tree("", null, null)),
                                        new Tree("",
                                                new Tree("", null, null),
                                                new Tree("2", null, null)))),
                        new Tree("A",
                                new Tree("R",
                                        new Tree("L",
                                                new Tree("", null, null),
                                                new Tree("", null, null)),
                                        new Tree("",
                                                new Tree("+", null, null),
                                                new Tree("", null, null))),
                                new Tree("W",
                                        new Tree("P",
                                                new Tree("", null, null),
                                                new Tree("", null, null)),
                                        new Tree("J",
                                                new Tree("", null, null),
                                                new Tree("1", null, null))))),
                new Tree("T",
                        new Tree("N",
                                new Tree("D",
                                        new Tree("B",
                                                new Tree("6", null, null),
                                                new Tree("=", null, null)),
                                        new Tree("X",
                                                new Tree("/", null, null),
                                                new Tree("", null, null))),
                                new Tree("K",
                                        new Tree("C",
                                                new Tree("", null, null),
                                                new Tree("", null, null)),
                                        new Tree("Y",
                                                new Tree("", null, null),
                                                new Tree("", null, null)))),
                        new Tree("M",
                                new Tree("G",
                                        new Tree("Z",
                                                new Tree("7", null, null),
                                                new Tree("", null, null)),
                                        new Tree("Q",
                                                new Tree("", null, null),
                                                new Tree("", null, null))),
                                new Tree("O",
                                        new Tree("",
                                                new Tree("8", null, null),
                                                new Tree("", null, null)),
                                        new Tree("",
                                                new Tree("9", null, null),
                                                new Tree("0", null, null))))));

        System.out.println(decodeMorse(morseTree, "--. .- -... .-. .. . .-.. / --- .-.. . .-. .. .- -. ---"));
    }
}
