    @OnClick(R.id.expandable_layout)
    void animateIcon() {
        if (isExpanded) {
            iconUpAnimator.start();
        } else {
            iconDownAnimator.start();
        }
    }

