    /**
     *  see {@link #getModel}
     */
    @MainThread
    public static <T extends BaseViewModel> T getModel(Context activity , Class<T> viewModel) {

        if(!(activity instanceof FragmentActivity)) {
            throw new RuntimeException("context must a FragmentActivity instance");
        }
        FragmentActivity fragmentActivity = (FragmentActivity) activity;

        return ViewModelProviders.of(fragmentActivity).get(viewModel).attachLifecycleOwner(fragmentActivity);
    }

