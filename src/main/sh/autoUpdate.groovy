!/usr/bin/groovy

new File("applications.txt").eachLine { line ->
	if (!line.startsWith("#")){
		println  "installing $line"
		println "sudo apt-get install -yy $line".execute().text
	}
}
