    /**
     * Method that decides if the history item should be saved to database.
     *
     * @param historyItem the history item to be saved to database
     * @return boolean
     */
    private boolean shouldAddHistory(HistoryNavigable historyItem) {
        final String description = historyItem.getDescription();
        if (description == null) {
            return false;
        }

        for (History history : mHistorySaved) {
            String desc = history.getItem().getDescription();
            if (desc != null && desc.equals(description)) {
                return false;
            }
        }
        return true;
    }

