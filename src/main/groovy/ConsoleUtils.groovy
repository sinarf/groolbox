/**
 * @author sinarf
 */

/**
 * @param wait time to wait b
 * @return
 */
static def waitBeforeClosing(int wait = 5, boolean verbose = true){
	if (verbose) println "Waiting for $wait seconds."
	Thread.sleep wait * 1000
}

/**
 * 
 * @param filePath path of the file containing the list of commands
 * 
 */
static def runCommands (String filePath){
	runCommands(new File (filePath))
}

/**
 * Excecute all the line in this file. 
 *
 * @param file File containing the list of commands
 */
static def runCommands (File file){
	file.eachLine { line -> executeCommand(line) }
}

/**
 * Execute a command and displays the result on the console.  
 * 
 * @param command command to execute. 
 */
static def executeCommand(String command){
	println "Running $command"
	def proc = command.execute()
	println proc.text
}
