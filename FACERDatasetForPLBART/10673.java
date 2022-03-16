    /**
     * Method that returns the name string highlighted with the match query.
     *
     * @param result The result to highlight
     * @param queries The list of queries that parameterized the search
     * @param highlightedColor The highlight color
     * @return CharSequence The name string highlighted
     */
    public static CharSequence getHighlightedName(
            SearchResult result, List<String> queries, int highlightedColor) {
        String name = result.getFso().getName();
        int cc = queries.size();
        for (int i = 0; i < cc; i++) {
            //Get the query removing wildcards
            String query =
                    queries.get(i)
                        .replace(".", "[.]") //$NON-NLS-1$//$NON-NLS-2$
                        .replace("*", ".*"); //$NON-NLS-1$//$NON-NLS-2$
            Pattern pattern;
            try {
                pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
            } catch (PatternSyntaxException e) {
                Log.w(TAG, "Invalid regex syntax. Using literal query. Error=" + e);
                pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
            }
            Matcher matcher = pattern.matcher(name);
            Spannable span =  new SpannableString(name);
            if (matcher.find()) {
                //Highlight the match
                span.setSpan(
                        new BackgroundColorSpan(highlightedColor),
                        matcher.start(), matcher.end(), 0);
                span.setSpan(
                        new StyleSpan(Typeface.BOLD), matcher.start(), matcher.end(), 0);
                return span;
            }
        }

        // Something is wrong!!!. Name should be matched by some of the queries
        // No highlight terms
        return name;
    }

