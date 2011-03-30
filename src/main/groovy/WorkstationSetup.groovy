

/**
 * This script should prepare a workstation, setting path and stuff.
 * @author sinarf 
 */

class WorkstationSetup {
	final  START_TAG = "### Start Groolbox - Do not edit manually, update the script instead ###"
	final  END_TAG = "### End Groolbox - Do not edit manually, update the script instead ###"
	final  EOL = '\n'



	/** 
	 * Extract the content of the file 
	 * @param file
	 * @return
	 */
	def captureFileContentWithoutGrooboxEditedPart(File file){
		String newContent = ""
		boolean groolboxContent = false

		file.eachLine { line ->
			if(START_TAG == line) groolboxContent = true
			else if (END_TAG == line) groolboxContent = false
			else if (!groolboxContent) newContent += line + EOL
		}

		if (groolboxContent) // start tag with no end tag
			throw new RuntimeException( "Start tag wiht no close tag - operation aborted. Please clean the file $file MANUALLY.")
		else return newContent
	}

	def wrapContentInTags (String contentToAppend){
		START_TAG + EOL + contentToAppend + EOL +	END_TAG + EOL
	}
	static main(args){
		println "Setting up the workstation. "

		File profile = UnixUtils.getProfile()
		def contentToAppend = """source /home/sinarf/Dropbox/config/linux/profile/devel.cnf
source /home/sinarf/Dropbox/config/linux/profile/alias.cnf"""
		new WorkstationSetup().with {
			def cleanFileContent = captureFileContentWithoutGrooboxEditedPart( profile)
			def editedContent = wrapContentInTags (contentToAppend) 
			profile.write(cleanFileContent + EOL + editedContent)
		}
		println profile.text
	}
}