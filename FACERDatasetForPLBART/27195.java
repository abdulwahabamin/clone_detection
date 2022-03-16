    public void showProgressBar(boolean show) {
        if (progressFrame == null) {
            return;
        }
        if (show) {
            progressFrame.setVisibility(View.VISIBLE);
        } else {
            progressFrame.setVisibility(View.GONE);
        }
    }

