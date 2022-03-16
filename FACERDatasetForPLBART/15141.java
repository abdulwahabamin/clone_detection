    /**
     * @param view
     * @param bitmap This is to avoid Bitmap's IllegalArgumentException
     */
    public static void runnableBackground(final ImageView view, final Bitmap bitmap) {
        view.post(new Runnable() {

            @Override
            public void run() {
                ApolloUtils.setBackground(view, bitmap);
            }
        });
    }

