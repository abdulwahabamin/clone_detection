    private int max(int[] lastPositions) {
        int max = lastPositions[0];
        for (int i : lastPositions) {
            max = Math.max(i, max);
        }
        return max;
    }

