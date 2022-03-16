    private void attachConfettiViewToParent() {
        final ViewParent currentParent = confettiView.getParent();
        if (currentParent != null) {
            if (currentParent != parentView) {
                ((ViewGroup) currentParent).removeView(confettiView);
                parentView.addView(confettiView);
            }
        } else {
            parentView.addView(confettiView);
        }

        confettiView.reset();
    }

