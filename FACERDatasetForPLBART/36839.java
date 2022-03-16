    public static void get(final String urlString) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                getSync(urlString);
            }
        }).start();
    }

