    private String joinCodeList(List<String> codeList) {
        if (codeList.size() < 1) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(codeList.get(0));
        for (int i = 1; i < codeList.size(); i++) {
            stringBuilder.append(",")
                    .append(codeList.get(i));
        }
        return stringBuilder.toString();
    }

