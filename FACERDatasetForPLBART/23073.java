	private int getNumCPUs() {
		int numCPUs = 0;
		BufferedReader in = null;
		try {
			/*
			 * To find out the number of CPUs it looks for folders inside
			 * /sys/devices/system/cpu/ which name is cpu plus one number from 0
			 * to 9. For example: /sys/devices/system/cpu/cpu0
			 * /sys/devices/system/cpu/cpu1 /sys/devices/system/cpu/cpu2
			 */
			Process process;
			process = Runtime.getRuntime().exec("ls /sys/devices/system/cpu");
			in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				String[] lines = line.split(" ");
				for (int i = 0; i < lines.length; i++) {
					String directory = lines[i].trim();
					if (Pattern.matches("cpu[0-9]", directory))
						numCPUs++;
				}
			}
		} catch (Exception e) {
			Log.e(e.getClass().getName(), e.getMessage(), e);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				Log.e(e.getClass().getName(), e.getMessage(), e);
			}
		}
		return numCPUs;
	}

