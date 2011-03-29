
/**
 * @author sinarf
 */


/**
 * empty the directory, if exists.
 * 
 * @param directory directory to wipe.
 * @param verbose if true, turn the verbose flag to true on the antbuilder.
 */
def static emptyDirectory(String directory, verbose = true) {
	if (directory) emptyDirectory new File(directory), verbose
}

/**
 * empty the directory, if exists. 
 *
 * @param directory directory to wipe.
 * @param verbose if true, turn the verbose flag to true on the antbuilder.
 */
def static emptyDirectory(File directory, verbose = true){
	if (directory?.exists()) {
		print "Empty '$directory'"
		AntBuilder ant = new AntBuilder()
		ant.delete ( verbose: verbose, failonerror: false){
			ant.fileset(dir: directory, includes: "/**")
		}
		println " -- Done."
	} else println   " -- '$directory' doesn't exists."
}