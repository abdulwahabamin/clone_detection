    /**
     * Update the history positions after one of the history is removed from drawer
     */
    private void updateHistoryPositions() {
        int cc = this.mHistory.size() - 1;
        for (int i = 0; i <= cc ; i++) {
            History history = this.mHistory.get(i);
            history.setPosition(i + 1);
        }
    }

