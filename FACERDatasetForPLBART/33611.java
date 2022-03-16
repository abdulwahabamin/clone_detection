    private String getNightMorningEveningTitle() {
        Resources res = getResources();

        String title = res.getString(R.string.night);
        title += "\n";
        title += res.getString(R.string.morning);
        title += "\n";
        title += res.getString(R.string.evening);

        return title;
    }

