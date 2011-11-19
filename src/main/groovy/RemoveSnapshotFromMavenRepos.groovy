#!groovy

/**
 * Was working on a project with a lot of snapshots and most of the the time the sources were out of date, which make debuging somewhat complicated. 
 * 
 * This script deletes all the snapshots-sources artifact from the local repositories.
 * 
 * @author sinarf
 */

// FIXME hard code repos.  
// TODO extract he repo location from maven configuration.  
def rootDirPath = /D:\java\MavenRepos/

File rootDir = new File(rootDirPath)
println "Remove all SNAPSHOT-sources files from $rootDir.absolutePath. Some deletion might fail if the jar is used (by eclipse for exemple)"

if (rootDir.exists())
    rootDir.eachFileRecurse { file ->
        if (file?.exists() && file.isFile() && file.name.contains("SNAPSHOT-sources")) {
            print "Try to remove: $file  ---- "
            if (file.delete())	println "REMOVED"
            else println "FAILED"
        }
    }
else println "The directory ${rootDir.canonicalPath} doesn't exists."

ConsoleUtils.waitBeforeClosing()
