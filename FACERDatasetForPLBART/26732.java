    @TargetApi(21)
    private void initEnterAnimation() {
        final Transition sharedElementEnterTransition = getWindow().getSharedElementEnterTransition();
        sharedElementEnterTransition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {
            }

            @Override
            public void onTransitionCancel(Transition transition) {
            }

            @Override
            public void onTransitionPause(Transition transition) {
            }

            @Override
            public void onTransitionResume(Transition transition) {
            }

            @Override
            public void onTransitionEnd(Transition transition) {
                CityDetailFragment fragment = (CityDetailFragment) getSupportFragmentManager().findFragmentById(R.id.city_detail_container);
                fragment.loadContent();
                sharedElementEnterTransition.removeListener(this);
            }
        });
    }

