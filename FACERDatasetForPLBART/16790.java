    @Override
    public void onAttach(Context context) {
        FireLog.d(TAG, "(++) onAttach");

        if (context instanceof MediaBrowserProvider) {
            mediaBrowserProvider = (MediaBrowserProvider) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement MediaBrowserProvider");
        }

        super.onAttach(context);
    }

