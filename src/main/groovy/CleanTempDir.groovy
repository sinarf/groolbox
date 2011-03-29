
/**
 * Clean up the temporary directories. 
 * Should work on any OS but I only use it on windows since this system "manage" to slow down when temp directory are to crowded. 
 * 
 * @author sinarf
 *
 */

FileUtils.emptyDirectory System.getenv("TEMP")
FileUtils.emptyDirectory System.getenv("TMP")
ConsoleUtils.waitBeforeClosing()