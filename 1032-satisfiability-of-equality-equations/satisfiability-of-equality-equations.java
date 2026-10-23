class Solution {
    public char findParent(char x, Map<Character, Character> parent) {
        if (x == parent.get(x))
            return x;

        parent.put(x, findParent(parent.get(x), parent));
        return parent.get(x);
    }

    public void unionXY(char x_parent, char y_parent, Map<Character, Character> parent, Map<Character, Integer> rank) {
        if (rank.get(x_parent) > rank.get(y_parent)) {
            parent.put(y_parent, x_parent);
        } else if (rank.get(x_parent) < rank.get(y_parent)) {
            parent.put(x_parent, y_parent);
        } else {
            parent.put(y_parent, x_parent);
            rank.put(x_parent, rank.get(x_parent) + 1);
        }
    }

    public boolean equationsPossible(String[] equations) {
        Map<Character, Character> parent = new HashMap<>();
        Map<Character, Integer> rank = new HashMap<>();

        for (String equation : equations) {
            char x = equation.charAt(0);
            char y = equation.charAt(3);

            parent.put(x, x);
            parent.put(y, y);

            rank.put(x, 0);
            rank.put(y, 0);
        }

        for (String equation : equations) {
            char x = equation.charAt(0);
            char y = equation.charAt(3);
            char op = equation.charAt(1);

            if (op == '!')
                continue;

            char x_parent = findParent(x, parent);
            char y_parent = findParent(y, parent);

            if (x_parent != y_parent && op == '=')
                unionXY(x_parent, y_parent, parent, rank);
        }

        for (String equation : equations) {
            char x = equation.charAt(0);
            char y = equation.charAt(3);
            char op = equation.charAt(1);

            if (op == '=')
                continue;

            char x_parent = findParent(x, parent);
            char y_parent = findParent(y, parent);

            if (x_parent == y_parent && op == '!')
                return false;
        }

        return true;
    }
}