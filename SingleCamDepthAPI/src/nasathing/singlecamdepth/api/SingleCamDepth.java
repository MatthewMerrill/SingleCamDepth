package nasathing.singlecamdepth.api;

public class SingleCamDepth {
	
	public static OutputModule out = new OutputModule(){

		@Override
		public void logInfo(String info) {
			System.out.println("[SCD:Info] " + info);
		}

		@Override
		public void logDebug(String debug) {
			System.out.println("[SCD:Debug] " + debug);
		}

		@Override
		public void logWarning(String warning) {
			System.out.println("[SCD:Warning] " + warning);			
		}

		@Override
		public void logError(String error) {
			System.err.print("[SCD:Error] " + error);
		}
		
	};
	
	public static OutputModule getOutputModule() {
		return out;
	}
	
	public static void setOutputModule(OutputModule outputModule) {
		SingleCamDepth.out = outputModule;
	}

}
