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