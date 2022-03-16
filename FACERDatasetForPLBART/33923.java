    /**
     * Returns a comparable abstract length/width an integer number uses as a chart label (works best for fonts with monospaced digits).
     * @param i number
     * @return length
     */
    private int getLengthAsString(int i) {
        char[] array = String.valueOf(i).toCharArray();
        int sum = 0;
        for (char c : array) {
            sum += (c == '-') ? 1 : 2; // minus is smaller than digits
        }
        return sum;
    }

