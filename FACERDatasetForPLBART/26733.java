    @TargetApi(21)
    private void initExitAnimation() {
        final Transition elementExitTransition = getWindow().getSharedElementReturnTransition();
        elementExitTransition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {
                CityDetailFragment fragment = (CityDetailFragment) getSupportFragmentManager().findFragmentById(R.id.city_detail_container);
                fragment.clearContent();
                elementExitTransition.removeListener(this);
            }

            @Override
            public void onTransitionEnd(Transition transition) {
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
        });
    }

