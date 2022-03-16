		@SuppressWarnings("unchecked")
		@Override
		protected Integer doInBackground(Object... params) {
			Object files = params[0];
			
			if (files instanceof List<?>) {
				for (File file: (List<File>)files) {
					int result = recursiveDelete(file);
					if (result != success) return result;
				}
				return success;
			} else
				return recursiveDelete((File)files);

		}

