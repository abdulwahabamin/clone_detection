    private Activity getActivity() {
        switch (TYPE) {
            case ACTIVITY:
                return getActivityView();
            case FRAGMENT:
                return getFrag_view().getActivity();
            case FRAGMENTv4:
                return getFrag_v4_view().getActivity();
        }
        return null;
    }

