    /**
     * Function to get Progress percentage
     *
     * @param currentDuration c
     * @param totalDuration   t
     */
    public int getProgressPercentage(long currentDuration, long totalDuration) {
        try {
            long currentSeconds = (int) (currentDuration / 1000);
            long totalSeconds = (int) (totalDuration / 1000);
            Double percentage = (((double) currentSeconds) / totalSeconds) * 100;
            return percentage.intValue();
        } catch (Exception e) {
            return 0;
        }
    }

