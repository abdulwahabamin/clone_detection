    @Override
    public float getPageWidth(int position) {
        if (context.getResources().getConfiguration().orientation == 1) {
            return 1f;
        } else {
            return 0.5f;
        }
    }

