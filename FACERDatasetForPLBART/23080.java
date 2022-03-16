	private int getMaxCPUFrequency() {
		BufferedReader in = null;
		try {
			Process process;
			process = Runtime.getRuntime().exec("cat /sys/devices/system/cpu/cpu0/cpufreq/scaling_max_freq");
			in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			if ((line = in.readLine()) != null)
				return new Integer(line.trim());
			Log.e(getClass().getName(), "Error reading max requency, in.readLine() is null");

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
		return -1;
	}

