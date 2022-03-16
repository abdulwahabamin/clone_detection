	public Flowable<Integer> copyOrMoveFile(final String source, final FileInputStream sourceStream ,
											final FileOutputStream destinationStream, final int selection) {
		try {
			final File f = new File(source);
			return Flowable.create(new FlowableOnSubscribe<Integer>() {
				@Override
				public void subscribe(FlowableEmitter<Integer> e) throws Exception {

					if (!f.isDirectory()) {
						fileUtility(f.getAbsolutePath(),sourceStream
								, destinationStream, e);
						if(selection==MOVE)
							f.delete();
						e.onComplete();
					} else {
						int n = f.listFiles().length, i = 0;
						for (File file : f.listFiles()) {
							fileUtility(file.getAbsolutePath(),sourceStream
									, destinationStream, e);
							i++;
							if(selection==MOVE)
								file.delete();
							e.onNext((int) ((float) i / n * 100));
						}
						e.onComplete();
					}
				}
			}, BackpressureStrategy.BUFFER);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

