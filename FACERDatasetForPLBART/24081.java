    public static void shuffleArray(long[] array) {
        Random random = new Random();
        for (int i=0; i < array.length; i++) {
            int randomPosition = random.nextInt(array.length);
            long temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }
    }

