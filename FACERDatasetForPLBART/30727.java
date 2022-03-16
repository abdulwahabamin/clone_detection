    @Override
    public void detachView(boolean retainInstance) {

        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

