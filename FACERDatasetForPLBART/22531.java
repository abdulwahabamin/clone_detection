    private View addViewToOverlay(ViewGroup sceneRoot, int width, int height, Drawable background) {
        View view = new NoOverlapView(sceneRoot.getContext());
        view.setBackground(background);
        int widthSpec = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY);
        int heightSpec = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY);
        view.measure(widthSpec, heightSpec);
        view.layout(0, 0, width, height);
        sceneRoot.getOverlay().add(view);
        return view;
    }

