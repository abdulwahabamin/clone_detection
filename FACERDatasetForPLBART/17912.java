    private String getFormattedDuration(@NonNull long duration) {
        String formattedDuration = "";

        formattedDuration += duration/60000;
        formattedDuration += ":";
        formattedDuration += String.format("%02d", (duration/1000)%60);

        return formattedDuration;
    }

