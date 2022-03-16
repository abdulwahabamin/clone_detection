    private boolean checkSameName(String name) {
        boolean result = false;
        List<String> tempList = new ArrayList<>();
        for (File webFile : webFiles) {
            if (!webFile.isFile()) {
                tempList.add(webFile.getName());
            }
        }
        if (tempList.contains(name)) {
            result = true;
        }
        return result;
    }

