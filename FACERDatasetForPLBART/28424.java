    public ConfettiManager(ConfettoGenerator confettoGenerator, ConfettiSource confettiSource, ViewGroup parentView, ConfettiView confettiView) {
        this.confettoGenerator = confettoGenerator;
        this.confettiSource = confettiSource;
        this.parentView = parentView;
        this.confettiView = confettiView;
        this.confettiView.bind(confetti);

        this.confettiView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {
            }

            @Override
            public void onViewDetachedFromWindow(View v) {
                terminate();
            }
        });

        // Set the defaults
        this.ttl = -1;
        this.bound = new Rect(0, 0, parentView.getWidth(), parentView.getHeight());
    }

