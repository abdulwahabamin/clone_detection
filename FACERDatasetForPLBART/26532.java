    /**
     * 一个类中，对�?�一个  {@link BaseViewModel} 应该�?�调用一次getModel，然�?�类中�?�缓存
     * @param fragment ViewModelProvider 所�?赖的fragment
     * @param viewModel �?获�?�的 BaseViewModel
     * @param <T> BaseViewModel 的实现
     * @return <T> 的实例
     */
    @MainThread
    public static <T extends BaseViewModel> T getModel(Fragment fragment , Class<T> viewModel) {
        return ViewModelProviders.of(fragment).get(viewModel).attachLifecycleOwner(fragment);
    }

