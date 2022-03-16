    private void sendToast(final String message) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(DownloadService.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

