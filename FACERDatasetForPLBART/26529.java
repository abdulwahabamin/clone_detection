    <T extends BaseViewModel> T attachLifecycleOwner(LifecycleOwner lifecycleOwner) {
        T currentModel =  (T) this;

        if(mLifecycleOwner != null) {
            return currentModel;
        }

        this.mLifecycleOwner = lifecycleOwner;
        /*
         * router 注册时�?影�?性能
         */
        Router.instance().register(this);
        onCreate();
        return currentModel;
    }

