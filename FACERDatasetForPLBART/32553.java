    private int getGreetingId() {
        int hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        if ((hours >= 3) && (hours < 10)) {
            return R.string.tts_say_greeting_morning;
        } else if ((hours >= 10) && (hours < 18)) {
            return R.string.tts_say_greeting_day;
        } else if (hours >= 18) {
            return R.string.tts_say_greeting_evening;
        } else {
            return R.string.tts_say_greeting_evening;
        }
    }

