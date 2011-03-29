package utils.os
/**
 * Clean up the temp directories. 
 * Should work on any OS but I only use it on windows since this system "manage" to slow down when temp directory are to crowded. 
 * 
 * @author Michel Blavin
 *
 */
def ant = new AntBuilder()
def tempDirectories = []

wipeDirectory System.getenv("TEMP")
wipeDirectory System.getenv("TMP")

def wipeDirectory(String directory){
	if (directory) {
		if (new File(directory)?.exists()) {
			print "Wipe '$directory'"
			AntBuilder ant = new AntBuilder()
			ant.delete ( verbose: true, failonerror: false){
				ant.fileset(dir: directory, includes: "/**")
			}
			println " -- Done."
		} else println   "'$directory' doesn't exists, maybe you should check your configuration."
	}
}

Thread.sleep 5000 // wait 5s before closing the window.