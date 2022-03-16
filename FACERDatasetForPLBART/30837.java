    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {

                RxJavaTestPlugins.resetPlugins();
                RxAndroidPlugins.getInstance().reset();
                RxJavaPlugins.getInstance().registerSchedulersHook(rxJavaSchedulersHook);
                RxAndroidPlugins.getInstance().registerSchedulersHook(rxAndroidSchedulersHook);

                base.evaluate();

                RxJavaTestPlugins.resetPlugins();
                RxAndroidPlugins.getInstance().reset();
            }
        };
    }

