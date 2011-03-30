
class UnixUtils {

	static getHomePath () {
		System.getenv ("HOME")
	}
	static File getProfile(){
		return new File ("${UnixUtils.getHomePath()}/.profile")
	}
	
	static main(args){
		println UnixUtils.getProfile().text
	}
}
