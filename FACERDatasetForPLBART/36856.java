    private List<String> splitCodeList(String string) {
        if ("".equals(string)) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(string.split(",")));
    }

