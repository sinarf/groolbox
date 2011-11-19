
class UnixUtils {

	
	static getHomePath () {
		System.getenv ("HOME")
	}
	static File getProfile(){
		getHomeFile(".profile")
	}
	static File getBashrc(){
		getHomeFile(".bashrc")
	}
	
	static getHomeFile(String filename){
		new File ("${UnixUtils.getHomePath()}/$filename")
	}
	
	static main(args){
		println UnixUtils.getProfile().text
	}
}
