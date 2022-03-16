    public static int getRandom(int min, int max) {
        int rand = Double.valueOf(((max + 1 - min) * Math.random()) + min).intValue();
        if(rand>max)
            rand=max;
        return rand;
    }

