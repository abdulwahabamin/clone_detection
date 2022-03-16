    @Override
    public void onBackPressed() {
        if (isUp()) {
            goDown();
        }
        else {
            super.onBackPressed();}
    }

