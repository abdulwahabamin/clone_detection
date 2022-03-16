    Flowable<List<FileDirectory>> loadMedia(final int select){
        return Flowable.create(new FlowableOnSubscribe<List<FileDirectory>>() {
            @Override
            public void subscribe(FlowableEmitter<List<FileDirectory>> e) throws Exception {
                fileList=getAllMediaPath(QuickAccess.this,e,select);
                e.onComplete();
            }

        }, BackpressureStrategy.BUFFER);
    }

