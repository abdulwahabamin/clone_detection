    /**
     * Initialize the color assets into memory for direct access
     */
    private void initializeColors() {
        // Only load the colors if needed
        if (COLOR_LIST.size() == 0) {
            for (int colorId : INTERNAL_COLOR_LIST) {
                COLOR_LIST.add(getContext().getResources().getColor(colorId));
            }
        }
    }

