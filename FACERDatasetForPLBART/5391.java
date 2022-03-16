	public Flowable<List<FileDirectory>> findwithDate(final String directory,final Date date){
		return Flowable.create(new FlowableOnSubscribe<List<FileDirectory>>() {
			@Override
			public void subscribe(FlowableEmitter<List<FileDirectory>> e) throws Exception {
				File file=new File(directory);
				searchResultList.clear();
				searchUtilDate(file,searchResultList,date);
				e.onNext(searchResultList);
				e.onComplete();
			}
		},BackpressureStrategy.BUFFER);
	}

