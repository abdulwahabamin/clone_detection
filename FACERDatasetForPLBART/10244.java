    /**
     * Method that creates a temporary filter based in the current text
     *
     * @param data The global data array
     * @param current The current text
     * @return The filtered data array
     */
    private static List<String> filter(List<String> data, String current) {
        List<String> filter = new ArrayList<String>(data);
        int size = filter.size();
        for (int i = size-1; i >= 0; i--) {
            String s = filter.get(i);
            if (!s.startsWith(current)) {
                filter.remove(i);
            }
        }
        return filter;
    }

