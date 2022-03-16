    public static double getRandomDouble(double min, double max) {
        double rand = (((max+1-min)* Math.random())+min);
        if(rand>max)
            rand=max;
        return rand;
    }

