    private String genSortTitle(String a) {
        Resources res = getResources();
        String[] prefixes = res.getStringArray(R.array.ignore_prefixes);
        String a1 = a.trim();

        for (String s : prefixes) {
            String s1 = s + " ";
            if (a1.startsWith(s1))
                return a1.substring(s1.length()).trim();
        }
        return a1;
    }

