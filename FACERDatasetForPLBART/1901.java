    private boolean isViewAttached() {
        switch (TYPE) {
            case ACTIVITY:
                return activity_view.get() != null;
            case FRAGMENT:
                return frag_view.get() != null;
            case FRAGMENTv4:
                return frag_v4_view.get() != null;
        }
        return false;
    }

