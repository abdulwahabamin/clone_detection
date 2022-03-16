    private void setDirection(final String string) {
        directionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snack.make(view, getString(R.string.wind_blowing_in, string), Snackbar.LENGTH_SHORT);
            }
        });
    }

