		public IndexerDbTable(Context context) {

			super("IndexerFiles",
					new DbField[] {
							new DbField(IndexerFile.LONG_ID,DbField.FIELD_TYPE_INT,true,false),
							new DbField(IndexerFile.STRING_FILENAME,DbField.FIELD_TYPE_TEXT,false,true),
							new DbField(IndexerFile.STRING_FILEPATH,DbField.FIELD_TYPE_TEXT,false,true),
							new DbField(IndexerFile.INT_CATEGORY,DbField.FIELD_TYPE_INT,false,true),
							new DbField(IndexerFile.LONG_FILESIZE,DbField.FIELD_TYPE_INT),
							new DbField(IndexerFile.INT_ICONTYPE,DbField.FIELD_TYPE_INT),
							new DbField(IndexerFile.LONG_MODIFIED,DbField.FIELD_TYPE_INT,false,true),
							new DbField(IndexerFile.INT_BOOL_ISFOLDER,DbField.FIELD_TYPE_INT),
					}
					,context
			);
			this.context=context;

		}

