    @Override
    public void onAnimationStart(Animation animation) {
        if(!adapter.isEnabled())
        {
            adapter.enable();
        }
    }

