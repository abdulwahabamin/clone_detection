    private Integer[] genPlayOrder(final int size) {
        Integer[] rslt = new Integer[size];

        // Set seed for shuffling
        rand.setSeed(shuffleSeed);

        // create sorted card deck (each value only occurs once)
        for (int i = 0; i < size; i++)
            rslt[i] = i;

        // shuffle the card deck using Durstenfeld algorithm
        for (int i = size - 1; i > 0; i--) {
            int j = rand.nextInt(i);
            int t = rslt[i];
            rslt[i] = rslt[j];
            rslt[j] = t;
        }

        lastShuffleSeed = shuffleSeed;
        shuffleSeed = shuffleRand.nextLong();
        return rslt;
    }

