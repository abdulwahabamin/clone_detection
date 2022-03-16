    public static void get(final String urlString, @NonNull final HttpCallbackListener listener, @NonNull final Handler handler) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String response = getSync(urlString);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (response != null) {
                            listener.onSuccess(response);
                        } else {
                            listener.onFailure();
                        }
                    }
                });
            }
        }).start();
    }

