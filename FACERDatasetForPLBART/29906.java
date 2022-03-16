    public String getDay(long dt) {
        dt *= 1000;
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(dt));
        return c.getDisplayName(Calendar.DAY_OF_WEEK , Calendar.SHORT , new Locale(new Prefs(getActivity()).getLanguage()));
    }

