    /**
     * Fetches data from the provided input stream.
     *
     * @param inputStream readable source of bytes
     * @return a set of characters representing the extracted data
     * @throws java.io.IOException in case of some stream reading problems
     */
    private StringBuilder readData(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line + "\n");
        }
        return stringBuilder;
    }

