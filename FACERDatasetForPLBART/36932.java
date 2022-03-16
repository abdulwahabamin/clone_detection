    private String timeFormat(String time) {
        SimpleDateFormat fromSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        SimpleDateFormat toSdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        try {
            return toSdf.format(fromSdf.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return toSdf.format(new Date());
    }

