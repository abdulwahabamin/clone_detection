    @Override
    public void onNext(T t) {
        logger.info("-----------------------------------------onNext-----------------------------------------");
        LogContent(t);
        logger.info("-----------------------------------------onNext-----------------------------------------");
    }
