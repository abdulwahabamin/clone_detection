    /**
     * Method that calculates the relevance of a file system object for the terms
     * of a query.<br/>
     * <br/>
     * The algorithm is described as:<br/>
     * <br/>
     * By Name:<br/>
     * <ul>
     * <li>3 points if the term matches the name</li>
     * <li>2 points if the term starts or ends in the name</li>
     * <li>1 point if the term has other matches in the name</li>
     * </ul>
     * <br/>
     * By Accuracy:<br/>
     * <ul>
     * <li>3 points if the term is the more accuracy (1st term)</li>
     * <li>1 point if the term is the less accuracy (last term)</li>
     * <li>2 points in other cases</li>
     * <li></li>
     * </ul>
     * <br/>
     * <code>Relevance = By Name * By Accuracy</code>
     *
     * @param fso The file system object
     * @param queries The terms of the search
     * @return double A value from 1 to 10 where 10 has more relevance
     */
    public static double calculateRelevance(FileSystemObject fso, Query queries) {
        double relevance = 1.0;  //Minimum relevance (is in the result so has some relevance)
        List<String> terms = queries.getQueries();
        String name = fso.getName();
        int cc = terms.size();
        for (int i = 0; i < cc; i++) {
            String query =
                    terms.get(i)
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
            if (matcher.find()) {
                //By name
                double byNameRelevance = 1.0;
                if (matcher.group().length() == name.length()) {
                    byNameRelevance = 3.0;
                } else if (name.startsWith(matcher.group()) || name.endsWith(matcher.group())) {
                    byNameRelevance = 2.0;
                }

                //By accuracy
                double byNameAccuracy = 1.0;
                if (i == 0) {
                    byNameAccuracy = 3.0;
                } else if (i != terms.size()) {
                    byNameAccuracy = 2.0;
                }

                //Calculate the relevance
                relevance += byNameRelevance * byNameAccuracy;
            }
        }
        return relevance;

    }

