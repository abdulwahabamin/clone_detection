		/**
		 * Recursively delete a file or directory and all of its children.
		 * 
		 * @returns 0 if successful, error value otherwise.
		 */
		private int recursiveDelete(File file) {
			if (file.isDirectory() && file.listFiles() != null)
				for (File childFile : file.listFiles()) {
					if (childFile.isDirectory()) {
						int result = recursiveDelete(childFile);
						if (result > 0) {
							return result;
						}
					} else {
						if (!childFile.delete()) {
							errorFile = childFile;
							return err_deleting_child_file;
						}
					}
				}

			if (!file.delete()) {
				errorFile = file;
				return file.isFile() ? err_deleting_file : err_deleting_folder;
			}

			return success;
		}

