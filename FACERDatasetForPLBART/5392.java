	/**
	 * Method to search files for the given query
	 * @param directory directory to be searched.
	 * @param query text to be searched.
	 * @return
	 */

	public Flowable<List<FileDirectory>> find(final String directory,final String query){

		return Flowable.create(new FlowableOnSubscribe<List<FileDirectory>>() {

			@Override
			public void subscribe(FlowableEmitter<List<FileDirectory>> e) throws Exception {
				File file=new File(directory);
				searchResultList.clear();
				searchUtil(file,searchResultList,query);
				e.onNext(searchResultList);
				e.onComplete();
			}
		},BackpressureStrategy.BUFFER);
	}

