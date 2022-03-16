    private String buildPostBody(String method, Map<String, String> params, String... strings) {
        StringBuilder builder = new StringBuilder(100);
        builder.append("method=");
        builder.append(method);
        builder.append('&');
        for (Iterator<Entry<String, String>> it = params.entrySet().iterator(); it.hasNext();) {
            Entry<String, String> entry = it.next();
            builder.append(entry.getKey());
            builder.append('=');
            builder.append(encode(entry.getValue()));
            if (it.hasNext() || strings.length > 0)
                builder.append('&');
        }
        int count = 0;
        for (String string : strings) {
            builder.append(count % 2 == 0 ? string : encode(string));
            count++;
            if (count != strings.length) {
                if (count % 2 == 0) {
                    builder.append('&');
                } else {
                    builder.append('=');
                }
            }
        }
        return builder.toString();
    }

