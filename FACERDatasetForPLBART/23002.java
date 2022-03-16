    /**
     * Function to change progress to timer
     *
     * @param progress      p
     * @param totalDuration t
     *                      returns current duration in milliseconds
     */
    public int progressToTimer(int progress, int totalDuration) {
        try {
            totalDuration = (totalDuration / 1000);
            int currentDuration = (int) ((((double) progress) / 100) * totalDuration);
            return currentDuration * 1000;
        } catch (Exception e) {
            return 0;
        }
    }

