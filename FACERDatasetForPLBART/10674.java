    /**
     * Method that returns the name but not highlight the search terms
     *
     * @param result The result to highlight
     * @return CharSequence The non highlighted name string
     */
    public static CharSequence getNonHighlightedName(SearchResult result) {
        String name = result.getFso().getName();
        Spannable span = new SpannableString(name);
        span.setSpan(new StyleSpan(Typeface.BOLD), 0, name.length(), 0);
        return span;
    }

