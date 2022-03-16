    @Override
    protected void onResume() {
        super.onResume();
        // in case of a locale change, invalidate the headers
        invalidateHeaders();
    }

